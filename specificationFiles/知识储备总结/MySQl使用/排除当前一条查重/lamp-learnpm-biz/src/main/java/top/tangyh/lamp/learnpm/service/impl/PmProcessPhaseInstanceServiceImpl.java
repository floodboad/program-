package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.database.mybatis.conditions.query.QueryWrap;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;
import top.tangyh.lamp.learnpm.entity.PmWkNodeTypeConf;
import top.tangyh.lamp.learnpm.manager.PmApprovalProcessInstanceManager;
import top.tangyh.lamp.learnpm.manager.PmProcessPhaseConfManager;
import top.tangyh.lamp.learnpm.manager.PmProcessPhaseInstanceManager;
import top.tangyh.lamp.learnpm.manager.PmWkNodeTypeConfManager;
import top.tangyh.lamp.learnpm.service.PmProcessPhaseInstanceService;
import top.tangyh.lamp.learnpm.vo.query.PmProcessPhaseInstancePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProcessPhaseInstanceResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProcessPhaseInstanceUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import java.util.List;

/**
 * <p>
 * 流程环节实例业务实现类
 * 
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmProcessPhaseInstanceServiceImpl extends SuperServiceImpl<PmProcessPhaseInstanceManager, Long, PmProcessPhaseInstance, PmProcessPhaseInstanceSaveVO, PmProcessPhaseInstanceUpdateVO, PmProcessPhaseInstancePageQuery, PmProcessPhaseInstanceResultVO>
        implements PmProcessPhaseInstanceService {
    private final PmProcessPhaseConfManager pmProcessPhaseConfManager;
    private final PmWkNodeTypeConfManager pmWkNodeTypeConfManager;
    private final PmApprovalProcessInstanceManager pmApprovalProcessInstanceManager;
    @Override
    public String getNextNodePage(long pmApprovalProcessInstanceId) throws Exception {
        //查询最后一条流程环节实例
        PmProcessPhaseInstance pmProcessPhaseInstance = new PmProcessPhaseInstance();
        pmProcessPhaseInstance.setPmApprovalProcessInstanceId(pmApprovalProcessInstanceId);

        QueryWrap<PmProcessPhaseInstance> queryWrapper = Wraps.q(pmProcessPhaseInstance) ;
        LbQueryWrap<PmProcessPhaseInstance> lbQueryWrap = queryWrapper.lambda();
        lbQueryWrap.eq(PmProcessPhaseInstance::getPmApprovalProcessInstanceId,pmApprovalProcessInstanceId)
                .orderByDesc(PmProcessPhaseInstance::getId);
        List<PmProcessPhaseInstance> vos = superManager.list(queryWrapper);
        if(CollectionUtils.isEmpty(vos))
            throw new Exception("流程实例:"+pmApprovalProcessInstanceId+"没找到流程环节实例!");
        List<PmProcessPhaseConf> phaseConfVos = getPmProcessPhaseConfsByProcessInstanceId(pmApprovalProcessInstanceId);
        for(int i=0;i<phaseConfVos.size();i++){
            PmProcessPhaseConf phaseConfVo = phaseConfVos.get(i);
            if(phaseConfVo.getId().equals(vos.get(0).getMsProcessPhaseConfId())){
                //获取下一个环节
                if(i<phaseConfVos.size()-1){
                    return getNodePage(phaseConfVos.get(i+1).getNodeTypeCode());
                }
            }
        }
        throw new Exception("流程实例:"+pmApprovalProcessInstanceId+"没找到下一个节点页面!");
    }

    /**
     * 获取节点页面
     * @param nodeTypeCode
     * @return
     */
    private String getNodePage(String nodeTypeCode) throws Exception {
        PmWkNodeTypeConf pmWkNodeTypeConf = new PmWkNodeTypeConf();
        pmWkNodeTypeConf.setNodeTypeCode(nodeTypeCode);
        pmWkNodeTypeConf.setIsValid(DSConstant.DICTIONARY_IS_VALID_1);
        QueryWrap<PmWkNodeTypeConf> queryWrapper = Wraps.q(pmWkNodeTypeConf);
        LbQueryWrap<PmWkNodeTypeConf> lbQueryWrap = queryWrapper.lambda();
        lbQueryWrap.eq(PmWkNodeTypeConf::getNodeTypeCode,nodeTypeCode)
                   .eq(PmWkNodeTypeConf::getIsValid,pmWkNodeTypeConf.getIsValid());
        List<PmWkNodeTypeConf> vos = pmWkNodeTypeConfManager.list(queryWrapper);
        if(CollectionUtils.isEmpty(vos))
            throw new Exception("节点类型编码:"+nodeTypeCode+"对应页面尚未配置或者无效!");
        String viewName = vos.get(0).getViewName();
        if(StringUtils.isEmpty(viewName))
            throw new Exception("节点类型编码:"+nodeTypeCode+"对应页面尚未配置!");
        return viewName;
    }

    /**
     * 根据流程实例id查询关联的流程环节列表
     * @param pmApprovalProcessInstanceId
     * @return
     * @throws Exception
     */
    private List<PmProcessPhaseConf> getPmProcessPhaseConfsByProcessInstanceId(Long pmApprovalProcessInstanceId) throws Exception {
        //根据流程实例ID获取流程定义ID，查询所有环节列表
        PmApprovalProcessInstance processInstanceVo = pmApprovalProcessInstanceManager.getById(pmApprovalProcessInstanceId);
        if (processInstanceVo == null)
            throw new Exception("流程实例：" + pmApprovalProcessInstanceId + "不存在!");
        PmProcessPhaseConf pmProcessPhaseConf = new PmProcessPhaseConf();

        pmProcessPhaseConf.setPmApprovalProcessConfigId(processInstanceVo.getPmApprovalProcessConfigId());

        QueryWrap<PmProcessPhaseConf> queryWrapper = Wraps.q(pmProcessPhaseConf);
        LbQueryWrap<PmProcessPhaseConf> lmWrapper = queryWrapper.lambda();
        lmWrapper.eq(PmProcessPhaseConf::getPmApprovalProcessConfigId, processInstanceVo.getPmApprovalProcessConfigId())
                .eq(PmProcessPhaseConf::getIsValid, DSConstant.DICTIONARY_RM_YES_NOT_1)
                .orderByDesc(PmProcessPhaseConf::getLinkSequence);
        return pmProcessPhaseConfManager.list(queryWrapper);
    }
}
