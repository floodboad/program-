package top.tangyh.lamp.learnpm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import cn.hutool.core.collection.CollUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.context.ContextUtil;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.utils.ArgumentAssert;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.manager.*;
import top.tangyh.lamp.learnpm.mapper.PmProjectMapper;
import top.tangyh.lamp.learnpm.mapper.PmProjectMeetingApplyMapper;
import top.tangyh.lamp.learnpm.mapper.PmProjectPlanAdjustRecordMapper;
import top.tangyh.lamp.learnpm.service.PmProjectService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.*;
import top.tangyh.lamp.learnpm.vo.update.PmProjectUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.vo.update.PmProjectSponsorUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectStakeholderUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmComplianceMaterialsUpdateVO;
import top.tangyh.lamp.learnpm.workflowservice.WorkFlowService;
import top.tangyh.lamp.workflow.vo.AuditVO;
import top.tangyh.lamp.workflow.vo.SearchToDoVO;
import top.tangyh.lamp.workflow.vo.StartVO;

import top.tangyh.lamp.learnpm.wechat.WO;

/**
 * <p>
 * 项目信息业务实现类
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class PmProjectServiceImpl extends SuperServiceImpl<PmProjectManager, Long, PmProject, PmProjectSaveVO, PmProjectUpdateVO, PmProjectPageQuery, PmProjectResultVO>
        implements PmProjectService {
    private final PmProjectSponsorManager projectSponsorManager;
    private final PmProjectStakeholderManager projectStakeholderManager;
    private final PmComplianceMaterialsManager complianceMaterialsManager;
    private final WorkFlowService workFlowService;

    private final PmProjectPlanAdjustRecordMapper pmProjectPlanAdjustRecordMapper;

    private final PmProjectMeetingApplyMapper pmProjectMeetingApplyMapper;


    private final PmProjectMapper pmProjectMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return false;
        }

        // 循环删除 从表
        //删除项目赞助企业
        projectSponsorManager.remove(Wraps.<PmProjectSponsor>lbQ().in(PmProjectSponsor::getPmProjectId, ids));
        //删除项目干系人
        projectStakeholderManager.remove(Wraps.<PmProjectStakeholder>lbQ().in(PmProjectStakeholder::getPmProjectId, ids));
        //删除项目合规材料
        complianceMaterialsManager.remove(Wraps.<PmComplianceMaterials>lbQ().in(PmComplianceMaterials::getPmProjectId, ids));

        return super.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmProject save(PmProjectSaveVO saveVO) {
        PmProject entity = BeanPlusUtil.toBean(saveVO,  PmProject.class);
        superManager.save(entity);
		//循环保存子表
        //保存项目赞助企业
        savePmProjectSponsorPmProjectIdItem(saveVO.getPmProjectSponsorPmProjectIdInsertList(), entity);
        //保存项目干系人
        savePmProjectStakeholderPmProjectIdItem(saveVO.getPmProjectStakeholderPmProjectIdInsertList(), entity);
        //保存项目合规材料
        savePmComplianceMaterialsPmProjectIdItem(saveVO.getPmComplianceMaterialsPmProjectIdInsertList(), entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmProject updateById(PmProjectUpdateVO updateVO) {
        PmProject old = getById(updateVO.getId());

        PmProject entity = BeanPlusUtil.toBean(updateVO, PmProject.class);
        superManager.updateById(entity);
        //循环保存和更新子表
        //保存项目赞助企业
        savePmProjectSponsorPmProjectIdItem(updateVO.getPmProjectSponsorPmProjectIdInsertList(), entity);
        //更新项目赞助企业
        updatePmProjectSponsorPmProjectIdItem(updateVO.getPmProjectSponsorPmProjectIdUpdateList(), entity,old);
        //删除项目赞助企业
        removePmProjectSponsorPmProjectIdSubByIds(updateVO.getPmProjectSponsorPmProjectIdDeleteList());
		//更新项目赞助企业
		updatePmProjectSponsorPmProjectIdItem(updateVO.getPmProjectSponsorPmProjectIdUpdateList(), entity,old);
		//删除项目赞助企业
		removePmProjectSponsorPmProjectIdSubByIds(updateVO.getPmProjectSponsorPmProjectIdDeleteList());
        //保存项目干系人
        savePmProjectStakeholderPmProjectIdItem(updateVO.getPmProjectStakeholderPmProjectIdInsertList(), entity);
		//更新项目干系人
		updatePmProjectStakeholderPmProjectIdItem(updateVO.getPmProjectStakeholderPmProjectIdUpdateList(), entity,old);
		//删除项目干系人
		removePmProjectStakeholderPmProjectIdSubByIds(updateVO.getPmProjectStakeholderPmProjectIdDeleteList());
        //更新项目干系人
        updatePmProjectStakeholderPmProjectIdItem(updateVO.getPmProjectStakeholderPmProjectIdUpdateList(), entity,old);
        //删除项目干系人
        removePmProjectStakeholderPmProjectIdSubByIds(updateVO.getPmProjectStakeholderPmProjectIdDeleteList());
        //保存项目合规材料
        savePmComplianceMaterialsPmProjectIdItem(updateVO.getPmComplianceMaterialsPmProjectIdInsertList(), entity);
		//更新项目合规材料
		updatePmComplianceMaterialsPmProjectIdItem(updateVO.getPmComplianceMaterialsPmProjectIdUpdateList(), entity,old);
		//删除项目合规材料
		removePmComplianceMaterialsPmProjectIdSubByIds(updateVO.getPmComplianceMaterialsPmProjectIdDeleteList());

        //更新项目合规材料
        updatePmComplianceMaterialsPmProjectIdItem(updateVO.getPmComplianceMaterialsPmProjectIdUpdateList(), entity,old);
        //删除项目合规材料
        removePmComplianceMaterialsPmProjectIdSubByIds(updateVO.getPmComplianceMaterialsPmProjectIdDeleteList());


        return entity;
    }
    //保存项目赞助企业
    private void savePmProjectSponsorPmProjectIdItem(List<PmProjectSponsorSaveVO> insertList, PmProject entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmProjectSponsor> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmProjectSponsor item = new PmProjectSponsor();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectId(entity.getId());
            itemList.add(item);
        });
        projectSponsorManager.saveBatch(itemList);
    }
    //更新项目赞助企业
    private void updatePmProjectSponsorPmProjectIdItem(List<PmProjectSponsorUpdateVO> updateInsert, PmProject entity, PmProject old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmProjectSponsor> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmProjectSponsor item = new PmProjectSponsor();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectId(entity.getId());
            itemList.add(item);
        });
        projectSponsorManager.updateBatchById(itemList);
    }
    //删除项目赞助企业
    private boolean removePmProjectSponsorPmProjectIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return projectSponsorManager.removeByIds(idList);
    }
    //保存项目干系人
    private void savePmProjectStakeholderPmProjectIdItem(List<PmProjectStakeholderSaveVO> insertList, PmProject entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmProjectStakeholder> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmProjectStakeholder item = new PmProjectStakeholder();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectId(entity.getId());
            itemList.add(item);
        });
        projectStakeholderManager.saveBatch(itemList);
    }
    //更新项目干系人
    private void updatePmProjectStakeholderPmProjectIdItem(List<PmProjectStakeholderUpdateVO> updateInsert, PmProject entity, PmProject old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmProjectStakeholder> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmProjectStakeholder item = new PmProjectStakeholder();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectId(entity.getId());
            itemList.add(item);
        });
        projectStakeholderManager.updateBatchById(itemList);
    }
    //删除项目干系人
    private boolean removePmProjectStakeholderPmProjectIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return projectStakeholderManager.removeByIds(idList);
    }
    //保存项目合规材料
    private void savePmComplianceMaterialsPmProjectIdItem(List<PmComplianceMaterialsSaveVO> insertList, PmProject entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmComplianceMaterials> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmComplianceMaterials item = new PmComplianceMaterials();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectId(entity.getId());
            itemList.add(item);
        });
        complianceMaterialsManager.saveBatch(itemList);
    }
    //更新项目合规材料
    private void updatePmComplianceMaterialsPmProjectIdItem(List<PmComplianceMaterialsUpdateVO> updateInsert, PmProject entity, PmProject old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmComplianceMaterials> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmComplianceMaterials item = new PmComplianceMaterials();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectId(entity.getId());
            itemList.add(item);
        });
        complianceMaterialsManager.updateBatchById(itemList);
    }
    //删除项目合规材料
    private boolean removePmComplianceMaterialsPmProjectIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return complianceMaterialsManager.removeByIds(idList);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmProject copy(Long id) {
        PmProject old = getById(id);
        ArgumentAssert.notNull(old, "数据不存在��已被删除，请刷新重试");

        PmProject entity = BeanPlusUtil.toBean(old, PmProject.class);
        entity.setId(null);
        superManager.save(entity);
        //循环复制子表
        LbQueryWrap<PmProjectSponsor> pmProjectSponsorPmProjectIdwrap = Wraps.<PmProjectSponsor>lbQ().eq(PmProjectSponsor::getPmProjectId,old.getId());
        List<PmProjectSponsor> itemList0 = projectSponsorManager.list(pmProjectSponsorPmProjectIdwrap);
        itemList0.forEach(item -> {
            item.setId(null);
            item.setPmProjectId(entity.getId());
        });
        projectSponsorManager.saveBatch(itemList0);
        LbQueryWrap<PmProjectStakeholder> pmProjectStakeholderPmProjectIdwrap = Wraps.<PmProjectStakeholder>lbQ().eq(PmProjectStakeholder::getPmProjectId,old.getId());
        List<PmProjectStakeholder> itemList1 = projectStakeholderManager.list(pmProjectStakeholderPmProjectIdwrap);
        itemList1.forEach(item -> {
            item.setId(null);
            item.setPmProjectId(entity.getId());
        });
        projectStakeholderManager.saveBatch(itemList1);
        LbQueryWrap<PmComplianceMaterials> pmComplianceMaterialsPmProjectIdwrap = Wraps.<PmComplianceMaterials>lbQ().eq(PmComplianceMaterials::getPmProjectId,old.getId());
        List<PmComplianceMaterials> itemList2 = complianceMaterialsManager.list(pmComplianceMaterialsPmProjectIdwrap);
        itemList2.forEach(item -> {
            item.setId(null);
            item.setPmProjectId(entity.getId());
        });
        complianceMaterialsManager.saveBatch(itemList2);


        return entity;
    }



    /**
     * 项目新增
     * @param saveVO
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(PmProjectSaveVO saveVO) throws Exception {
        if(saveVO==null){
            throw new Exception("项目信息有误！");
        }
        PmProject save = save(saveVO);
        //如果项目状态为审批中，则提交工作流
        if(saveVO.getProjectStauts().equals(DSConstant.DICTIONARY_PROJECT_STAUTS_02)){
            commitAudit(save);
        }
    }

    /**
     * 项目修改
     * @param updateVO
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PmProjectUpdateVO updateVO) throws Exception {
        if(updateVO==null){
            throw new Exception("项目信息有误！");
        }
        //如果项目状态为审批中，则提交工作流
        if(updateVO.getProjectStauts().equals(DSConstant.DICTIONARY_PROJECT_STAUTS_02)){
            commitAudit(BeanPlusUtil.toBean(updateVO,PmProject.class));
        }
        updateById(updateVO);
    }
    /**
     *发起工作流
     * @param
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void commitAudit(PmProject pmProject) {
        //发起工作流
        try {
            SearchToDoVO searchToDoVO = new SearchToDoVO();
            searchToDoVO.setBusinessId(pmProject.getId());
            searchToDoVO.setBusinessType(DSConstant.DICTIONARY_BUSINESS_TYPE_02);
            searchToDoVO.setProcessName(DSConstant.DICTIONARY_PROCESS_NAME_PROJECT_APPROVE);
            searchToDoVO.setProcessInstanceId(0);
            StartVO startVO = StartVO.builder().businessType(DSConstant.DICTIONARY_BUSINESS_TYPE_01)
                    .businessId(pmProject.getId())
                    .toDoId(workFlowService.getToDoList(searchToDoVO))
                    .processName(DSConstant.DICTIONARY_PROCESS_NAME_PROJECT_APPROVE)
                    .businessInfo(JSONObject.toJSONString(pmProject))
                    .applicantId(ContextUtil.getApplicationId())
                    .applicantName(ContextUtil.getUserName())
                    .build();
            workFlowService.startFlow(startVO);
        }catch (Exception e){
            log.error("项目立项工作流发起失败！"+e);
        }

    }

    /**
     * 审批接口
     * @param auditVO
     * @throws Exception
     */
    @Override
    public void audit(AuditVO auditVO) throws Exception {
        //查询流程实例是否结束
        List<PmProcessPhaseInstance> auditList = workFlowService.getAuditList(auditVO.getPmApprovalProcessInstanceId());
        PmProcessPhaseInstance pmProcessPhaseInstance = auditList.get(0);
        String status = DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_04;
        if(auditVO.getAgreest().equals(DSConstant.DICTIONARY_RM_YES_NOT_1)){
            workFlowService.auditPass(auditVO);
        }else {
            status = DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_03;
            workFlowService.auditNoPass(auditVO);
        }
        //如果流程实例结束，修改业务表状态
        if(pmProcessPhaseInstance.getIsEnd().equals(DSConstant.DICTIONARY_RM_YES_NOT_1)){
            PmProject pmProject = getById(auditVO.getBusinessId());
            if(pmProject==null){
                throw new Exception("项目信息有误，刷新后重新提交！");
            }
            //判断工作流是否通过
            PmProjectUpdateVO updateVO = new PmProjectUpdateVO();
            updateVO.setId(auditVO.getBusinessId());
            updateVO.setProjectStauts(status);
            updateById(updateVO);
        }

    }

    @Override
    public Object getPmProjectList(WO wo) {
        return null;
    }

    /**
     * 项目信息调整
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void projectAdjust(PmProjectUpdateVO updateVO) throws Exception {
        if(updateVO==null){
            throw new Exception("项目信息有误！");
        }
        PmProject oldVo = getById(updateVO.getId());
        //查询当前项目是否有在调整的记录。有则更新，无则添加
        QueryWrapper<PmProjectPlanAdjustRecord> queryWrapper = new QueryWrapper();
        queryWrapper.eq("PM_PROJECT_ID",updateVO.getId()).eq("STATUS",DSConstant.DICTIONARY_ADJUST_STATUS_01);
        List<PmProjectPlanAdjustRecord> pmProjectPlanAdjustRecords = pmProjectPlanAdjustRecordMapper.selectList(queryWrapper);
        //转为调整记录信息
        PmProjectPlanAdjustRecord saveVO = BeanPlusUtil.toBean(updateVO, PmProjectPlanAdjustRecord.class);
        saveVO.setPmProjectId(updateVO.getId());
        saveVO.setOriginalMeetingBudgetAmt(oldVo.getMeetingBudgetOccupied());
        saveVO.setOriginalMeetingPlannedNum(oldVo.getEstimatedMeetingTotalNum());
        saveVO.setOriginalRemainBudgetAmt(oldVo.getRemainingBudgetAmount());
        //调整会议占用金额
        BigDecimal meetingBudgetOccupied = BigDecimal.ZERO;
        if(updateVO.getMeetingBudgetOccupied()!=null){
            meetingBudgetOccupied = updateVO.getMeetingBudgetOccupied();
        }
        BigDecimal oldMeetingBudgetOccupied = BigDecimal.ZERO;
        if(oldVo.getMeetingBudgetOccupied()!=null){
            oldMeetingBudgetOccupied = oldVo.getMeetingBudgetOccupied();
        }
        saveVO.setAdjustMeetingOccupiedAmt(meetingBudgetOccupied.subtract(oldMeetingBudgetOccupied));
        //调整会议场次
        saveVO.setAdjustMeetingNumber((new BigDecimal(oldVo.getEstimatedMeetingTotalNum()).subtract(new BigDecimal(updateVO.getEstimatedMeetingTotalNum()))).toString());
        saveVO.setAfterAdjustmentMeetingNumber(updateVO.getEstimatedMeetingTotalNum());
        saveVO.setAdjustedMeetingOccupiedAmt(meetingBudgetOccupied.toString());
        saveVO.setAdjustedRemainingBudgetAmt(updateVO.getRemainingBudgetAmount());
        saveVO.setStatus(DSConstant.DICTIONARY_ADJUST_STATUS_01);
        if(pmProjectPlanAdjustRecords.size()>0){
            saveVO.setId(pmProjectPlanAdjustRecords.get(0).getId());
            pmProjectPlanAdjustRecordMapper.updateAllById(saveVO);
        }else {
            pmProjectPlanAdjustRecordMapper.insert(saveVO);
        }

        PmProjectUpdateVO projectUpdateVO = new PmProjectUpdateVO();
        projectUpdateVO.setId(updateVO.getId());
        projectUpdateVO.setAdjustStatus(DSConstant.DICTIONARY_ADJUST_STATUS_01);
        updateById(projectUpdateVO);
    }

    @Override
    public List<PmProject> getByid(Long id) {
        return pmProjectMapper.getInitiator(id);
    }


}

