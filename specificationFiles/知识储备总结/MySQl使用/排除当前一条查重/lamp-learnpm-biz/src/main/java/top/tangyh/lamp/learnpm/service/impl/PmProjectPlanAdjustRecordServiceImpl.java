package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;
import top.tangyh.lamp.learnpm.entity.PmProjectPlanAdjustRecord;
import top.tangyh.lamp.learnpm.manager.PmProjectPlanAdjustRecordManager;
import top.tangyh.lamp.learnpm.service.PmProjectPlanAdjustRecordService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectPlanAdjustRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectPlanAdjustRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectPlanAdjustRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectPlanAdjustRecordUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.workflowservice.WorkFlowService;
import top.tangyh.lamp.workflow.vo.AuditVO;

import java.util.List;

/**
 * <p>
 * 项目规划调整记录业务实现类
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
@Transactional(readOnly = true)
public class PmProjectPlanAdjustRecordServiceImpl extends SuperServiceImpl<PmProjectPlanAdjustRecordManager, Long, PmProjectPlanAdjustRecord, PmProjectPlanAdjustRecordSaveVO, PmProjectPlanAdjustRecordUpdateVO, PmProjectPlanAdjustRecordPageQuery, PmProjectPlanAdjustRecordResultVO>
        implements PmProjectPlanAdjustRecordService {
    private final WorkFlowService workFlowService;
    /**
     * 审批接口
     * @param auditVO
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
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
            //根据业务id查询调整记录
            PmProjectPlanAdjustRecord byId = getById(auditVO.getBusinessId());
            byId.setStatus(status);
            superManager.updateAllById(byId);
        }

    }
}
