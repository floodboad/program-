package top.tangyh.lamp.learnpm.workflowservice.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.database.mybatis.conditions.query.QueryWrap;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.dfhcglock.service.lock.PessimisticLockClientService;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.service.*;
import top.tangyh.lamp.learnpm.vo.save.PmApprovalProcessInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmApprovalProcessInstanceUpdateVO;
import top.tangyh.lamp.learnpm.workflowservice.WorkFlowService;
import top.tangyh.lamp.model.entity.system.SysUser;
import top.tangyh.lamp.msg.service.MsgService;
import top.tangyh.lamp.msg.vo.save.MsgSaveVO;
import top.tangyh.lamp.msg.vo.save.MsgVO;
import top.tangyh.lamp.system.entity.tenant.DefUser;
import top.tangyh.lamp.system.service.tenant.DefUserService;
import top.tangyh.lamp.workflow.vo.AuditVO;
import top.tangyh.lamp.workflow.vo.SearchToDoVO;
import top.tangyh.lamp.workflow.vo.StartVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 工作流服务实现
 *
 * </p>
 *
 * @author longsebo
 * @date 2022-06-21
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkFlowServiceImpl implements WorkFlowService {
    //流程定义
    @Autowired
    private PmApprovalProcessConfigService pmApprovalProcessConfigService;
    //流程节点定义
    @Autowired
    private PmProcessPhaseConfService pmProcessPhaseConfService;
    //流程实例
    @Autowired
    private PmApprovalProcessInstanceService pmApprovalProcessInstanceService;
    //流程节点实例
    @Autowired
    private PmProcessPhaseInstanceService pmProcessPhaseInstanceService;
    //用户服务
    @Autowired
    private DefUserService defUserService;
    //项目干系人
    @Autowired
    private PmProjectStakeholderService pmProjectStakeholderService;
    //公司财务人员
    @Autowired
    private PmCompanyFinanceService pmCompanyFinanceService;
    //加锁服务
    @Autowired
    private PessimisticLockClientService pessimisticLockClientService;
    @Autowired
    private MsgService msgService;
    /**
     * 审批通过消息模版
     */
    @Value(value="${lamp.message.auditpasstpl}")
    private String auditPassTpl;
    /**
     * 审批不通过消息模版
     */
    @Value(value="${lamp.message.auditnopasstpl}")
    private String auditNoPassTpl;

    @Override
    @Transactional( rollbackFor=Exception.class)
    public long startFlow(StartVO startVO) throws Exception {

        //参数检查
        checkStartVO(startVO);
        //根据流程名称查询
        PmApprovalProcessConfig approvalProcessConfig = new PmApprovalProcessConfig();
        approvalProcessConfig.setProcessName(startVO.getProcessName());
        QueryWrap<PmApprovalProcessConfig> wrap = Wraps.q(approvalProcessConfig);
        LbQueryWrap<PmApprovalProcessConfig> wrapper = wrap.lambda();
//        wrapper.eq(PmApprovalProcessConfig::getProcessName, approvalProcessConfig.getProcessName());

        List<PmApprovalProcessConfig> wkVos = pmApprovalProcessConfigService.list(wrapper);
        if(CollectionUtils.isEmpty(wkVos))
            throw new Exception("不存在的工作流:"+startVO.getProcessName());

       // PmApprovalProcessInstanceSaveVO processInstanceSaveVo = getFirstProcessInstanceSaveVO(startVO, wkVos);
        //查询该流程定义的环节配置
        QueryWrap<PmProcessPhaseConf> queryWrap;
        PmProcessPhaseConf pmProcessPhaseConf = new PmProcessPhaseConf();

        queryWrap = Wraps.q(pmProcessPhaseConf);
        pmProcessPhaseConf.setPmApprovalProcessConfigId(wkVos.get(0).getId());
        pmProcessPhaseConf.setLinkSequence(DSConstant.MIN_LINK_SEQUENCE);

        LbQueryWrap<PmProcessPhaseConf> lmWrapper = queryWrap.lambda();
//        lmWrapper.eq(PmProcessPhaseConf::getApproverId, pmProcessPhaseConf.getApproverId())
//                .eq(PmProcessPhaseConf::getLinkSequence,pmProcessPhaseConf.getLinkSequence());


        List<PmProcessPhaseConf> wkNodeVos = pmProcessPhaseConfService.list(lmWrapper);
        if(CollectionUtils.isEmpty(wkNodeVos))
            throw new Exception("流程:"+ startVO.getProcessName()+"尚未配置流程节点!");
        //插入流程实例
        PmApprovalProcessInstanceSaveVO processInstanceSaveVo = buildProcessInstanceSaveVO(startVO, wkVos.get(0)) ;
        //插入第一个环节实例
//        PmProcessPhaseInstanceSaveVO phaseInstanceSaveVo = buildPhaseInstanceSaveVO(startVO,wkNodeVos.get(0));
//        List<PmProcessPhaseInstanceSaveVO> wkNodeList = new ArrayList<>();
//        wkNodeList.add(phaseInstanceSaveVo);
//        processInstanceSaveVo.setPmProcessPhaseInstancePmApprovalProcessInstanceIdInsertList(wkNodeList);

        PmApprovalProcessInstance processInstance = pmApprovalProcessInstanceService.save(processInstanceSaveVo);
        return processInstance.getId();
    }

    /**
     * 检查启动工作流参数
     * @param startVO
     */
    private void checkStartVO(StartVO startVO) throws Exception {
        if(StringUtils.isEmpty(startVO.getTitle()))
            throw new Exception("缺少标题!");
        //
        if(StringUtils.isEmpty(startVO.getBusinessType()))
            throw  new Exception("缺少业务类型!");
        if(startVO.getBusinessId()==null||startVO.getBusinessId()==0L)
            throw new Exception("缺少业务id!");
        if(StringUtils.isEmpty(startVO.getProcessName()))
            throw new Exception("缺少流程名称!");
        if(StringUtils.isEmpty(startVO.getToDoId()))
            throw new Exception("缺少待办人!");
        if(StringUtils.isEmpty(startVO.getBusinessInfo()))
            throw new Exception("缺少业务信息");
        if(startVO.getApplicantId()==null||startVO.getApplicantId()==0L)
            throw new Exception("缺少申请人id");
        if(StringUtils.isEmpty(startVO.getApplicantName()))
            throw new Exception("缺少申请人姓名");
    }

    /**
     * 构造节点实例
     *
     * @param startVO
     * @param pmProcessPhaseConf
     * @return
     */
    private PmProcessPhaseInstanceSaveVO buildPhaseInstanceSaveVO(StartVO startVO, PmProcessPhaseConf pmProcessPhaseConf) {
        PmProcessPhaseInstanceSaveVO saveVO = new PmProcessPhaseInstanceSaveVO();

        saveVO.setMsProcessPhaseConfId(pmProcessPhaseConf.getPmApprovalProcessConfigId());
        saveVO.setApproverId(startVO.getApplicantId());
        saveVO.setApproverName(startVO.getApplicantName());
        saveVO.setApproverType(pmProcessPhaseConf.getApproverType());
        saveVO.setRoleCode(pmProcessPhaseConf.getRoleCode());
        saveVO.setIsEnd(pmProcessPhaseConf.getIsEnd());
        return saveVO;
    }

    /**
     * 构造工作流实例vo
     * @param startVO
     * @param pmApprovalProcessConfig
     * @return
     */
    private PmApprovalProcessInstanceSaveVO buildProcessInstanceSaveVO(StartVO startVO, PmApprovalProcessConfig pmApprovalProcessConfig) throws Exception {
        PmApprovalProcessInstanceSaveVO saveVO = new PmApprovalProcessInstanceSaveVO();

        saveVO.setPmApprovalProcessConfigId(pmApprovalProcessConfig.getId());
        saveVO.setBusinessType(startVO.getBusinessType());
        saveVO.setBusinessId(startVO.getBusinessId());
        saveVO.setToDoId(startVO.getToDoId());
        saveVO.setProcessName(startVO.getProcessName());
        saveVO.setRemark(pmApprovalProcessConfig.getRemark());
        saveVO.setIsEnd(DSConstant.DICTIONARY_RM_YES_NOT_0);
        saveVO.setBusinessInfo(startVO.getBusinessInfo());
        saveVO.setAttribute1(startVO.getTitle());
        saveVO.setAttribute2(String.valueOf(startVO.getApplicantId()));
        saveVO.setAttribute3(startVO.getApplicantName());
        return  saveVO;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public long auditPass(AuditVO auditVO) throws Exception {
        boolean isLock = false;
        try {
            //检查入口参数
            checkAduitVO(auditVO);
            //尝试加锁
            isLock = pessimisticLockClientService.lock(String.valueOf(auditVO.getPmApprovalProcessInstanceId()),"1");
            if(!isLock)
                throw new Exception("工作流实例已经有其他人处理!");
            //根据流程实例ID查询流程环节实例记录
            PmProcessPhaseInstance pmProcessPhaseInstance = new PmProcessPhaseInstance();
            pmProcessPhaseInstance.setPmApprovalProcessInstanceId(auditVO.getPmApprovalProcessInstanceId());
            QueryWrap<PmProcessPhaseInstance> queryWrapper = Wraps.q(pmProcessPhaseInstance);
            LbQueryWrap<PmProcessPhaseInstance> lmWrapper = queryWrapper.lambda();
            lmWrapper.orderByDesc(PmProcessPhaseInstance::getId);
            List<PmProcessPhaseInstance> wkNodeInstances = pmProcessPhaseInstanceService.list(queryWrapper);
            if (CollectionUtils.isEmpty(wkNodeInstances)) {
                //构造第一个流程环节实例vo
                List<PmProcessPhaseConf> nodeDefineVos = getPmProcessPhaseConfsByProcessInstanceId(auditVO.getPmApprovalProcessInstanceId());
                return pmProcessPhaseInstanceService.save(buildFirstPhaseInstanceSaveVO(nodeDefineVos.get(0), auditVO)).getId();
            }
            //取ID最大的，找到对应的流程环节配置，
            PmProcessPhaseInstance lastPhaseInstance = wkNodeInstances.get(0);
            PmApprovalProcessInstance processInstanceVO = pmApprovalProcessInstanceService.getById(auditVO.getPmApprovalProcessInstanceId());
            if (processInstanceVO == null)
                throw new Exception("工作流实例:" + auditVO.getPmApprovalProcessInstanceId() + "不存在!");
            //审批不通过或最后一个节点审批通过流程结束
            if (DSConstant.DICTIONARY_RM_YES_NOT_1.equals(lastPhaseInstance.getIsEnd()) || DSConstant.DICTIONARY_RM_YES_NOT_0.equals(auditVO.getAgreest())) {
                processInstanceVO.setIsEnd(DSConstant.DICTIONARY_RM_YES_NOT_1);
                processInstanceVO.setEndTime(new Date());
                PmApprovalProcessInstanceUpdateVO updateVO = BeanPlusUtil.toBean(processInstanceVO, PmApprovalProcessInstanceUpdateVO.class);
                //更新工作流实例
                pmApprovalProcessInstanceService.updateById(updateVO);
                //给用户发消息
                sendMsg(processInstanceVO,auditVO);
                return updateVO.getId();
                //如果对应流程环节是结束节点，审批流实例的是否结束填是，结束时间填当前时间
            } else {
                processInstanceVO.setToDoId(auditVO.getToDoId());
                PmProcessPhaseInstanceSaveVO pmProcessPhaseInstanceSaveVO = buildAuditPassNextPhaseInstanceSaveVO(lastPhaseInstance, auditVO);
                //插入
                return pmProcessPhaseInstanceService.save(pmProcessPhaseInstanceSaveVO).getId();
            }
        }finally {
            if(isLock){
                pessimisticLockClientService.unLock(String.valueOf(auditVO.getPmApprovalProcessInstanceId()));
            }
        }
    }

    /**
     * 发送消息给申请人
     * @param processInstanceVO  流程实例vo
     * @param auditVO 审批结果信息
     */
    private void sendMsg(PmApprovalProcessInstance processInstanceVO, AuditVO auditVO) {
        //构造消息
        String msg;
        if(DSConstant.DICTIONARY_RM_YES_NOT_1.equals(auditVO.getAgreest())){
            msg = String.format(auditPassTpl,processInstanceVO.getAttribute1(),auditVO.getDetailLink());
        }else{
            msg = String.format(auditNoPassTpl,processInstanceVO.getAttribute1(),auditVO.getDetailLink());
        }
        //指定消息接收人
        MsgSaveVO saveVo;
        SysUser sysUser = new SysUser();
        saveVo = new MsgSaveVO();
        MsgVO msgVo = new MsgVO();
        msgVo.setContent(msg);
        msgVo.setAuthor(processInstanceVO.getAttribute3());
        saveVo.setMsgVO(msgVo);

        List<Long> employeeIdList = new ArrayList<>();
        employeeIdList.add(Long.valueOf(processInstanceVO.getAttribute2()));
        saveVo.setEmployeeIdList(employeeIdList);
        //插入消息
        msgService.saveMsg(saveVo,sysUser);

    }

    /**
     * 构造第一个工作流节点实例VO
     *
     * @param processPhaseConf  当前最后一个节点
     * @param auditVO 审核信息
     * @return
     */
    private PmProcessPhaseInstanceSaveVO buildFirstPhaseInstanceSaveVO(PmProcessPhaseConf processPhaseConf, AuditVO auditVO) throws Exception {

        PmProcessPhaseInstanceSaveVO saveVO = new PmProcessPhaseInstanceSaveVO();
        saveVO.setPmApprovalProcessInstanceId(auditVO.getPmApprovalProcessInstanceId());
        saveVO.setMsProcessPhaseConfId(processPhaseConf.getId());
        saveVO.setApproverId(auditVO.getApproverId());
        saveVO.setApproverName(auditVO.getApproverName());
        saveVO.setApproverType(processPhaseConf.getApproverType());
        saveVO.setApprovalComments(auditVO.getApprovalComments());
        saveVO.setAgreest(auditVO.getAgreest());
        saveVO.setIsEnd(processPhaseConf.getIsEnd());
        return  saveVO;
    }
    /**
     * 构造审批通过下一个节点
     *
     * @param lastPhaseInstance  当前最后一个节点
     * @param auditVO 审核信息
     * @return
     */
    private PmProcessPhaseInstanceSaveVO buildAuditPassNextPhaseInstanceSaveVO(PmProcessPhaseInstance lastPhaseInstance, AuditVO auditVO) throws Exception {
        //根据流程实例ID获取流程定义ID，查询所有环节列表
        List<PmProcessPhaseConf> phaseConfVos = getPmProcessPhaseConfsByProcessInstanceId(lastPhaseInstance.getPmApprovalProcessInstanceId());
        PmProcessPhaseConf nextPmProcessPhaseConf = getPmProcessPhaseConf(lastPhaseInstance.getMsProcessPhaseConfId(), phaseConfVos);
        if(nextPmProcessPhaseConf==null)
            throw new Exception("查找下一个节点失败!");
        PmProcessPhaseInstanceSaveVO saveVO = new PmProcessPhaseInstanceSaveVO();
        saveVO.setPmApprovalProcessInstanceId(lastPhaseInstance.getPmApprovalProcessInstanceId());
        saveVO.setMsProcessPhaseConfId(nextPmProcessPhaseConf.getId());
        saveVO.setApproverId(auditVO.getApproverId());
        saveVO.setApproverName(auditVO.getApproverName());
        saveVO.setApproverType(nextPmProcessPhaseConf.getApproverType());
        saveVO.setApprovalComments(auditVO.getApprovalComments());
        saveVO.setAgreest(DSConstant.DICTIONARY_RM_YES_NOT_1);
        saveVO.setIsEnd(nextPmProcessPhaseConf.getIsEnd());
        return  saveVO;
    }

    /**
     * 根据环节定义ID搜索环节定义列表中下一个环节定义ID
     * @param phaseConfId 环节定义ID
     * @param phaseConfVos 环节定义vo列表
     * @return
     */
    private PmProcessPhaseConf getPmProcessPhaseConf(long phaseConfId, List<PmProcessPhaseConf> phaseConfVos)  {
        PmProcessPhaseConf nextPmProcessPhaseConf = null;
        for (int i = 0; i < phaseConfVos.size(); i++) {
            PmProcessPhaseConf conf = phaseConfVos.get(i);
            if (conf.getId().equals(phaseConfId)) {
                if (i < phaseConfVos.size() - 1) {
                    nextPmProcessPhaseConf = phaseConfVos.get(i + 1);
                    break;
                }
            }
        }
        return nextPmProcessPhaseConf;
    }

    /**
     * 检查审批信息
     * @param auditVO
     */
    private void checkAduitVO(AuditVO auditVO) throws Exception {
        if(auditVO==null)
            throw new Exception("审批信息为空!");
        //流程实例id不能为空
        if(auditVO.getPmApprovalProcessInstanceId()==null||auditVO.getPmApprovalProcessInstanceId()==0)
            throw new Exception("流程实例id为空!");
        //审批人id不能为空
        if(auditVO.getApproverId()==null||auditVO.getApproverId()==0)
            throw new Exception("审批人id为空!");
        //审批人姓名不能为空
        if(StringUtils.isEmpty(auditVO.getApproverName()))
            throw new Exception("审批人姓名不能为空!");
        //审批意见不能为空
        if(StringUtils.isEmpty(auditVO.getApprovalComments()))
            throw new Exception("审批意见不能为空！");
        //审核标志检查
        if(!DSConstant.DICTIONARY_RM_YES_NOT_1.equals(auditVO.getAgreest()) && !DSConstant.DICTIONARY_RM_YES_NOT_0.equals(auditVO.getAgreest()))
            throw new Exception("无效的审核通过标志:"+auditVO.getAgreest());
        //查看详情链接不能为空
        if(StringUtils.isEmpty(auditVO.getDetailLink()))
            throw new Exception("查看详情链接不能为空!");
        //如果是审批通过，则当前节点非结束节点，待办人列表不能为空
        if(DSConstant.DICTIONARY_RM_YES_NOT_1.equals(auditVO.getAgreest())) {
            PmProcessPhaseInstance pmProcessPhaseInstance = new PmProcessPhaseInstance();
            pmProcessPhaseInstance.setPmApprovalProcessInstanceId(auditVO.getPmApprovalProcessInstanceId());
            QueryWrap<PmProcessPhaseInstance> queryWrapper = Wraps.q(pmProcessPhaseInstance);
            LbQueryWrap<PmProcessPhaseInstance> lmWrapper = queryWrapper.lambda();
//            lmWrapper.eq(PmProcessPhaseInstance::getPmApprovalProcessInstanceId, pmProcessPhaseInstance.getApproverId())
            lmWrapper.orderByDesc(PmProcessPhaseInstance::getId);
            List<PmProcessPhaseInstance> wkNodeInstances = pmProcessPhaseInstanceService.list(queryWrapper);
            if (CollectionUtils.isEmpty(wkNodeInstances))
                throw new Exception("工作流节点实例列表为空！");
            if (DSConstant.DICTIONARY_RM_YES_NOT_0.equals(wkNodeInstances.get(0).getIsEnd())) {
                if (StringUtils.isEmpty(auditVO.getToDoId()))
                    throw new Exception("当前节点非结束节点，待办人列表不能为空!");
            }
        }
    }

    @Override
    @Transactional( rollbackFor=Exception.class)
    public long auditNoPass(AuditVO auditVO) throws Exception {
        //检查入口参数
        checkAduitVO(auditVO);
        //根据流程实例ID查询流程环节实例记录
        PmProcessPhaseInstance pmProcessPhaseInstance = new PmProcessPhaseInstance();
        pmProcessPhaseInstance.setPmApprovalProcessInstanceId(auditVO.getPmApprovalProcessInstanceId());
        QueryWrap<PmProcessPhaseInstance> queryWrapper = Wraps.q(pmProcessPhaseInstance);
        LbQueryWrap<PmProcessPhaseInstance> lmWrapper = queryWrapper.lambda();
//        lmWrapper.eq(PmProcessPhaseInstance::getPmApprovalProcessInstanceId, pmProcessPhaseInstance.getApproverId())
//                .orderByDesc(PmProcessPhaseInstance::getId);
        lmWrapper.orderByDesc(PmProcessPhaseInstance::getId);
        List<PmProcessPhaseInstance> wkNodeInstances = pmProcessPhaseInstanceService.list(queryWrapper);
        if(CollectionUtils.isEmpty(wkNodeInstances)) {
            //构造第一个流程环节实例vo
            List<PmProcessPhaseConf> nodeDefineVos = getPmProcessPhaseConfsByProcessInstanceId(auditVO.getPmApprovalProcessInstanceId());
            return pmProcessPhaseInstanceService.save(buildFirstPhaseInstanceSaveVO(nodeDefineVos.get(0),auditVO)).getId();
        }
        //取ID最大的，找到对应的流程环节配置，
        PmProcessPhaseInstance lastPhaseInstance = wkNodeInstances.get(0);
        PmApprovalProcessInstance processInstanceVO = pmApprovalProcessInstanceService.getById(auditVO.getPmApprovalProcessInstanceId());
        if(processInstanceVO==null)
            throw new Exception("工作流实例:"+auditVO.getPmApprovalProcessInstanceId()+"不存在!");

        //查询审批下一个节点
        PmProcessPhaseInstanceSaveVO pmProcessPhaseNextInstanceSaveVO = buildAuditNoPassNextPhaseInstanceSaveVO(lastPhaseInstance,auditVO);
        List<PmProcessPhaseConf> phaseConfVos = getPmProcessPhaseConfsByProcessInstanceId(auditVO.getPmApprovalProcessInstanceId());
        PmProcessPhaseConf nextPmProcessPhaseConf = getPmProcessPhaseConf(lastPhaseInstance.getMsProcessPhaseConfId(), phaseConfVos);
        if(nextPmProcessPhaseConf==null)
            throw new Exception("查找下一个环节配置节点失败!");
        //如果下一个环节节点配置了审批不通过退回节点，查找历史流程环节节点实例ID，取发起人id作为待办人（如果查询到多个流程节点实例ID，则取最后一个)
        if(nextPmProcessPhaseConf.getBackNodeId()==null||nextPmProcessPhaseConf.getBackNodeId()==0){
            nextPmProcessPhaseConf = phaseConfVos.get(0);
        }else{
            nextPmProcessPhaseConf = getPmProcessPhaseConf(nextPmProcessPhaseConf.getBackNodeId(),phaseConfVos);
            if(nextPmProcessPhaseConf==null)
                throw new Exception("无法查询到退回节点!");
        }
        String toDo="";

        //根据退回节点配置id查询流程节点实例表
        for(PmProcessPhaseInstance instance:wkNodeInstances){
            if(instance.getMsProcessPhaseConfId().equals(nextPmProcessPhaseConf.getId())){
                //TODO:取申请人id
                long userId = instance.getApproverId();
                String userName=  instance.getApproverName();
                //获取用户手机号
                DefUser userVo = defUserService.getById(userId);
                if(userVo==null)
                    throw new Exception("查询审批不通过退回节点的用户id没找到！");
                toDo=String.format(DSConstant.TODO_JSON_TEMPLATE,userId,userVo.getMobile(),userName);
                break;
            }
        }
        //更新工作流实例
        processInstanceVO.setToDoId(toDo);
        PmApprovalProcessInstanceUpdateVO processInstanceUpdateVO= BeanPlusUtil.toBean(processInstanceVO,  PmApprovalProcessInstanceUpdateVO.class);
        pmApprovalProcessInstanceService.updateById(processInstanceUpdateVO);
        //插入
        return pmProcessPhaseInstanceService.save(pmProcessPhaseNextInstanceSaveVO).getId();

    }

    /**
     * 构造审批不通过下一个节点
     * @param lastPhaseInstance
     * @param auditVO
     * @return
     */
    private PmProcessPhaseInstanceSaveVO buildAuditNoPassNextPhaseInstanceSaveVO(PmProcessPhaseInstance lastPhaseInstance, AuditVO auditVO) throws Exception {
        List<PmProcessPhaseConf> phaseConfVos = getPmProcessPhaseConfsByProcessInstanceId(lastPhaseInstance.getPmApprovalProcessInstanceId());
        PmProcessPhaseConf nextPmProcessPhaseConf = getPmProcessPhaseConf(lastPhaseInstance.getMsProcessPhaseConfId(), phaseConfVos);
        if(nextPmProcessPhaseConf==null)
            throw new Exception("查找下一个环节配置节点失败!");

        PmProcessPhaseInstanceSaveVO saveVO = new PmProcessPhaseInstanceSaveVO();
        saveVO.setPmApprovalProcessInstanceId(lastPhaseInstance.getPmApprovalProcessInstanceId());
        saveVO.setMsProcessPhaseConfId(nextPmProcessPhaseConf.getId());
        saveVO.setApproverId(auditVO.getApproverId());
        saveVO.setApproverName(auditVO.getApproverName());
        saveVO.setApproverType(nextPmProcessPhaseConf.getApproverType());
        saveVO.setApprovalComments(auditVO.getApprovalComments());
        saveVO.setAgreest(DSConstant.DICTIONARY_RM_YES_NOT_0);
        saveVO.setIsEnd(nextPmProcessPhaseConf.getIsEnd());
        return  saveVO;
    }

    /**
     * 根据流程实例id查询关联的流程环节列表
     * @param pmApprovalProcessInstanceId
     * @return
     * @throws Exception
     */
    private List<PmProcessPhaseConf> getPmProcessPhaseConfsByProcessInstanceId(Long pmApprovalProcessInstanceId) throws Exception {
        //根据流程实例ID获取流程定义ID，查询所有环节列表
        PmApprovalProcessInstance processInstanceVo = pmApprovalProcessInstanceService.getById(pmApprovalProcessInstanceId);
        if (processInstanceVo == null)
            throw new Exception("流程实例：" + pmApprovalProcessInstanceId + "不存在!");
        PmProcessPhaseConf pmProcessPhaseConf = new PmProcessPhaseConf();

        pmProcessPhaseConf.setPmApprovalProcessConfigId(processInstanceVo.getPmApprovalProcessConfigId());

        QueryWrap<PmProcessPhaseConf> queryWrapper = Wraps.q(pmProcessPhaseConf);
        LbQueryWrap<PmProcessPhaseConf> lmWrapper = queryWrapper.lambda();
//        lmWrapper.eq(PmProcessPhaseConf::getPmApprovalProcessConfigId, processInstanceVo.getPmApprovalProcessConfigId())
//                .eq(PmProcessPhaseConf::getIsValid, DSConstant.DICTIONARY_RM_YES_NOT_1)
//                .orderByDesc(PmProcessPhaseConf::getLinkSequence);
        lmWrapper.eq(PmProcessPhaseConf::getIsValid, DSConstant.DICTIONARY_RM_YES_NOT_1)
                .orderByDesc(PmProcessPhaseConf::getLinkSequence);
        return pmProcessPhaseConfService.list(queryWrapper);
    }
    /**
     * 根据流程id查询关联的流程环节列表
     * @param pmApprovalProcessConfigId
     * @return
     * @throws Exception
     */
    private List<PmProcessPhaseConf> getPmProcessPhaseConfsByProcessId(Long pmApprovalProcessConfigId) throws Exception {
        //根据流程实例ID获取流程定义ID，查询所有环节列表
        PmProcessPhaseConf pmProcessPhaseConf = new PmProcessPhaseConf();

        pmProcessPhaseConf.setPmApprovalProcessConfigId(pmApprovalProcessConfigId);

        QueryWrap<PmProcessPhaseConf> queryWrapper = Wraps.q(pmProcessPhaseConf);
        LbQueryWrap<PmProcessPhaseConf> lmWrapper = queryWrapper.lambda();
//        lmWrapper.eq(PmProcessPhaseConf::getPmApprovalProcessConfigId, pmApprovalProcessConfigId)
//                .eq(PmProcessPhaseConf::getIsValid, DSConstant.DICTIONARY_RM_YES_NOT_1)
//                .orderByAsc(PmProcessPhaseConf::getLinkSequence);
        lmWrapper.eq(PmProcessPhaseConf::getIsValid, DSConstant.DICTIONARY_RM_YES_NOT_1)
                .orderByAsc(PmProcessPhaseConf::getLinkSequence);
        return pmProcessPhaseConfService.list(queryWrapper);
    }
    /**
     * 根据流程实例id获取审批意见列表
     */
    @Override
    public List<PmProcessPhaseInstance> getAuditList(long approvalProcessInstallId) {
        //根据流程实例ID查询流程环节实例记录
        PmProcessPhaseInstance pmProcessPhaseInstance = new PmProcessPhaseInstance();
        pmProcessPhaseInstance.setPmApprovalProcessInstanceId(approvalProcessInstallId);
        QueryWrap<PmProcessPhaseInstance> queryWrapper = Wraps.q(pmProcessPhaseInstance);
        LbQueryWrap<PmProcessPhaseInstance> lmWrapper = queryWrapper.lambda();
//        lmWrapper.eq(PmProcessPhaseInstance::getPmApprovalProcessInstanceId, pmProcessPhaseInstance.getApproverId())
//                .orderByDesc(PmProcessPhaseInstance::getId);
        lmWrapper.orderByDesc(PmProcessPhaseInstance::getId);

        List<PmProcessPhaseInstance> wkNodeInstances = pmProcessPhaseInstanceService.list(queryWrapper);
        return wkNodeInstances;
    }

    /**
     * 获取角色对应用户
     * @param vo
     * @return 返回待办人列表JSON
     */
    @Override
    public String getToDoList(SearchToDoVO vo) throws Exception {
        //除了财务人员，其他都跟项目有关系
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        //流程实例id和流程名称不能同时为空
        if( (vo.getProcessInstanceId()==0) && StringUtils.isEmpty(vo.getProcessName()) )
            throw new Exception("流程实例id和流程名称不能同时为空!");

        //如果流程实例id为0,则根据流程名称查询流程环节节点第一个角色编码;
        String roleCode="";
        if(vo.getProcessInstanceId()==0) {
            //根据流程名称查询
            PmApprovalProcessConfig approvalProcessConfig = new PmApprovalProcessConfig();
            approvalProcessConfig.setProcessName(vo.getProcessName());
            QueryWrap<PmApprovalProcessConfig> wrap = Wraps.q(approvalProcessConfig);
            LbQueryWrap<PmApprovalProcessConfig> wrapper = wrap.lambda();
//            wrapper.eq(PmApprovalProcessConfig::getProcessName, approvalProcessConfig.getProcessName());

            List<PmApprovalProcessConfig> wkVos = pmApprovalProcessConfigService.list(wrapper);
            if(CollectionUtils.isEmpty(wkVos))
                throw new Exception("不存在的工作流:"+vo.getProcessName());
            List<PmProcessPhaseConf> nodeDefVos = getPmProcessPhaseConfsByProcessId(wkVos.get(0).getId());
            if(CollectionUtils.isEmpty(nodeDefVos))
                throw  new Exception("该流程没有有效的流程环节节点!");
            roleCode = nodeDefVos.get(0).getRoleCode();
            //否则根据流程实例id，查询流程环节列表取最后一条，然后最后一条对应的流程环节的下一个流程环节配置角色编码
        }else{
            //根据流程实例ID查询流程环节实例记录
            PmProcessPhaseInstance pmProcessPhaseInstance = new PmProcessPhaseInstance();
            pmProcessPhaseInstance.setPmApprovalProcessInstanceId(vo.getProcessInstanceId());
            QueryWrap<PmProcessPhaseInstance> queryWrapper = Wraps.q(pmProcessPhaseInstance);
            LbQueryWrap<PmProcessPhaseInstance> lmWrapper = queryWrapper.lambda();
//            lmWrapper.eq(PmProcessPhaseInstance::getPmApprovalProcessInstanceId, pmProcessPhaseInstance.getApproverId())
//                    .orderByDesc(PmProcessPhaseInstance::getId);
            lmWrapper.orderByDesc(PmProcessPhaseInstance::getId);
            List<PmProcessPhaseInstance> wkNodeInstances = pmProcessPhaseInstanceService.list(queryWrapper);
            if(CollectionUtils.isEmpty(wkNodeInstances))
               throw new Exception("没有流程节点实例，尚未启动流程！");

            //取ID最大的，找到对应的流程环节配置，
            PmProcessPhaseInstance lastPhaseInstance = wkNodeInstances.get(0);
            List<PmProcessPhaseConf> nodeDefVos = getPmProcessPhaseConfsByProcessInstanceId(vo.getProcessInstanceId());
            if(CollectionUtils.isEmpty(nodeDefVos))
                throw  new Exception("该流程没有有效的流程环节节点!");
            //查询下一个流程环节节点
            int i=0;
            for( ;i<nodeDefVos.size()-1;i++){
                if(nodeDefVos.get(i).getId().equals(lastPhaseInstance.getMsProcessPhaseConfId()) && i+1<=nodeDefVos.size()-1){
                    roleCode = nodeDefVos.get(i+1).getRoleCode();
                    break;
                }
            }
            if(i>=nodeDefVos.size()-1)
                throw  new Exception("找不到下一个流程环节节点!");
        }
        // 财务人员
        if(DSConstant.DICTIONARY_ROLE_COE_10.equals(roleCode)){
            //TODO查询公司财务表
            PmCompanyFinance pmCompanyFinance = new PmCompanyFinance();
            //查找有效的
            pmCompanyFinance.setIsValid(DSConstant.DICTIONARY_IS_VALID_1);
            QueryWrap<PmCompanyFinance> queryWrapper = Wraps.q(pmCompanyFinance);
            LbQueryWrap<PmCompanyFinance> lmWrapper = queryWrapper.lambda();
//            lmWrapper.eq(PmCompanyFinance::getIsValid, pmCompanyFinance.getIsValid());

            List<PmCompanyFinance> vos = pmCompanyFinanceService.list(queryWrapper);
            for(int i=0;i<vos.size();i++) {
                PmCompanyFinance vo1=vos.get(i);
                builder.append(String.format(DSConstant.TODO_JSON_TEMPLATE,vo1.getUserId(),vo1.getPhone(),vo1.getUserName()));
                if(i<vos.size()-1){
                    builder.append(",");
                }else{
                    builder.append("]");
                }
            }
        //查询项目干系人
        }else{
            PmProjectStakeholder pmProjectStakeholder = new PmProjectStakeholder();
            pmProjectStakeholder.setPmProjectId(vo.getBusinessId());
            pmProjectStakeholder.setProjectRole(roleCode);
            QueryWrap<PmProjectStakeholder> queryWrapper = Wraps.q(pmProjectStakeholder);
            LbQueryWrap<PmProjectStakeholder> lmWrapper = queryWrapper.lambda();
//            lmWrapper.eq(PmProjectStakeholder::getPmProjectId, pmProjectStakeholder.getPmProjectId())
//                    .eq(PmProjectStakeholder::getProjectRole,  pmProjectStakeholder.getProjectRole())
//                    .orderByAsc(PmProjectStakeholder::getProjectRole);
            lmWrapper.orderByAsc(PmProjectStakeholder::getProjectRole);
            List<PmProjectStakeholder> vos = pmProjectStakeholderService.list(queryWrapper);
            for(int i=0;i<vos.size();i++) {
                PmProjectStakeholder vo1=vos.get(i);
                builder.append(String.format(DSConstant.TODO_JSON_TEMPLATE,vo1.getUserId(),vo1.getPhone(),vo1.getName()));
                if(i<vos.size()-1){
                    builder.append(",");
                }else{
                    builder.append("]");
                }
            }
        }
        //检查是否有待办人
        if(!builder.toString().contains("{"))
            throw new Exception("没有找到角色的待办人员");
        return builder.toString();
    }
}
