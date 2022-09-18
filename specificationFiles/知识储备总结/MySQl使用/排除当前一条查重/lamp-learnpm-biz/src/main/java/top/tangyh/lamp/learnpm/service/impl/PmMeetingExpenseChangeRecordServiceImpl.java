package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.PmMeetingExpenseChangeRecord;
import top.tangyh.lamp.learnpm.manager.PmMeetingExpenseChangeRecordManager;
import top.tangyh.lamp.learnpm.service.PmMeetingExpenseChangeRecordService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExpenseChangeRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExpenseChangeRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceApplyFeeSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExpenseChangeRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceApplyFeeUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExpenseChangeRecordUpdateVO;

/**
 * <p>
 * 会议费用变更记录业务实现类
 *
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmMeetingExpenseChangeRecordServiceImpl extends SuperServiceImpl<PmMeetingExpenseChangeRecordManager, Long, PmMeetingExpenseChangeRecord, PmMeetingExpenseChangeRecordSaveVO, PmMeetingExpenseChangeRecordUpdateVO, PmMeetingExpenseChangeRecordPageQuery, PmMeetingExpenseChangeRecordResultVO>
        implements PmMeetingExpenseChangeRecordService {

    //根据更新记录新增记录
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmMeetingExpenseChangeRecord saveRecord(PmConferenceApplyFeeUpdateVO u) {
        PmMeetingExpenseChangeRecord record = PmMeetingExpenseChangeRecord.builder()
                .pmProjectMeetingPlanningId(u.getPmProjectMeetingPlanningId())
                .projectMeetingPlanningName(u.getProjectMeetingPlanningName())
                .msBudgetSubjectId(u.getMsBudgetSubjectId())
                .feeName(u.getFeeName())
                .controlStandards(u.getControlStandards())
                .num(u.getNum())
                //已执行金额=商企通已执行金额+线下执行金额
                .executedAmount(u.getFeeExecutedAmount().add(u.getOtherExecutionAmount()))
                .adjustedAmount(u.getAmountMoney())
                //调整后剩余金额=调整后金额-已执行金额
                .afterAdjustRemainingAmount(u.getAmountMoney()
                        .subtract(u.getFeeExecutedAmount().add(u.getOtherExecutionAmount())))
                .status("01")
                .build();
        superManager.save(record);
        return record;
    }


}
