package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.manager.PmMeetingPlanAllocationManager;
import top.tangyh.lamp.learnpm.manager.PmPersonChargeAdjustRecordManager;
import top.tangyh.lamp.learnpm.manager.PmProjectMeetingPlanningManager;
import top.tangyh.lamp.learnpm.manager.PmProjectStakeholderManager;
import top.tangyh.lamp.learnpm.service.PmPersonChargeAdjustRecordService;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingPlanningService;
import top.tangyh.lamp.learnpm.vo.query.PmPersonChargeAdjustRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmPersonChargeAdjustRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmPersonChargeAdjustRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmPersonChargeAdjustRecordUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import top.tangyh.lamp.learnpm.wechat.PmMeetingupdateproject;
import top.tangyh.lamp.system.service.tenant.DefUserService;
import top.tangyh.lamp.workflow.vo.AuditVO;

/**
 * <p>
 * 项目负责人及规划负责人调整记录业务实现类
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
public class PmPersonChargeAdjustRecordServiceImpl extends SuperServiceImpl<PmPersonChargeAdjustRecordManager, Long, PmPersonChargeAdjustRecord, PmPersonChargeAdjustRecordSaveVO, PmPersonChargeAdjustRecordUpdateVO, PmPersonChargeAdjustRecordPageQuery, PmPersonChargeAdjustRecordResultVO>
        implements PmPersonChargeAdjustRecordService {

    // 项目绘画分配  执行人
    private final PmMeetingPlanAllocationManager pmMeetingPlanAllocationManager;

    // 项目会议规划  规划负责人
    private final PmProjectMeetingPlanningManager pmProjectMeetingPlanningManager;

    private final PmProjectStakeholderManager PmProjectStakeholder;

    private final PmProjectMeetingPlanningService o;


    private final DefUserService defUserService;

    // 修改负责人
    @Override
    public Object updatePrincipal(PmMeetingupdateproject pmProjectMeetingPlanning) {


        // 项目会议规划修改前的内容


        if (pmProjectMeetingPlanning.getPmProjectMeetingPlanningId() != null) {     // 判断是否有会议规划id


            PmProjectMeetingPlanning w = pmProjectMeetingPlanningManager.getById(pmProjectMeetingPlanning.getPmProjectMeetingPlanningId());


            // 给调整记录添加内容
            PmPersonChargeAdjustRecord pm = PmPersonChargeAdjustRecord.builder().pmProjectId(w.getPmProjectId()).pmProjectMeetingPlanningId(w.getId()).originalPrincipalId(w.getChargePersonId())
                    .originalPrincipalPhone(w.getPhone()).name(w.getChargePersonName()).nowPrincipalId(pmProjectMeetingPlanning.getNowPrincipaId()).nowPrincipalName(pmProjectMeetingPlanning.getNowPrincipalName())
                    .nowPrincipalPhone(pmProjectMeetingPlanning.getNowPrincipalPhone()).adjustReason(pmProjectMeetingPlanning.getAdjustReason()).build();


            superManager.save(pm);

            // 修改会议规划的负责人
            w.setChargePersonId(pmProjectMeetingPlanning.getNowPrincipaId());
            w.setChargePersonName(pmProjectMeetingPlanning.getNowPrincipalName());

            w.setPhone(pmProjectMeetingPlanning.getNowPrincipalPhone());
            pmProjectMeetingPlanningManager.updateById(w);


        }


        return null;
    }

    // 修改执行人
    @Override
    public Object updatePrincipal1(PmMeetingupdateproject pmProjectMeetingPlanning) {


        if (pmProjectMeetingPlanning.getPmMeetingPlanAllocationId() != null) {     // 判断是否有会议规划id

            // 会议规划分配

            PmMeetingPlanAllocation s = pmMeetingPlanAllocationManager.getById(pmProjectMeetingPlanning.getPmMeetingPlanAllocationId());


            // 给调整记录添加内容
            PmPersonChargeAdjustRecord pm = PmPersonChargeAdjustRecord.builder().pmProjectId(s.getPmProjectId()).pmProjectMeetingPlanningId(s.getPmProjectMeetingPlanningId()).originalPrincipalId(s.getChargePersonId())
                    .originalPrincipalPhone(s.getPhone()).name(s.getChargePersonName()).nowPrincipalId(pmProjectMeetingPlanning.getNowPrincipaId()).nowPrincipalName(pmProjectMeetingPlanning.getNowPrincipalName())
                    .nowPrincipalPhone(pmProjectMeetingPlanning.getNowPrincipalPhone()).adjustReason(pmProjectMeetingPlanning.getAdjustReason()).build();

            superManager.save(pm);

            // 修改会议规划的负责人

            s.setChargePersonId(pmProjectMeetingPlanning.getNowPrincipaId());
            s.setChargePersonName(pmProjectMeetingPlanning.getNowPrincipalName());
            s.setPhone(pmProjectMeetingPlanning.getNowPrincipalPhone());
            pmMeetingPlanAllocationManager.updateById(s);


        }


        return null;
    }


}
