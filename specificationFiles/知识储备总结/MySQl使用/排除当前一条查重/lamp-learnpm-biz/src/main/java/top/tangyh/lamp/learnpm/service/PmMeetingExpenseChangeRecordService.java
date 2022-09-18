package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingExpenseChangeRecord;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExpenseChangeRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExpenseChangeRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceApplyFeeSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExpenseChangeRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceApplyFeeUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExpenseChangeRecordUpdateVO;

/**
 * <p>
 * 会议费用变更记录业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
public interface PmMeetingExpenseChangeRecordService extends SuperService<Long, PmMeetingExpenseChangeRecord, PmMeetingExpenseChangeRecordSaveVO, PmMeetingExpenseChangeRecordUpdateVO, PmMeetingExpenseChangeRecordPageQuery, PmMeetingExpenseChangeRecordResultVO> {
//    PmMeetingExpenseChangeRecord saveRecord(PmConferenceApplyFeeSaveVO s);
    PmMeetingExpenseChangeRecord saveRecord(PmConferenceApplyFeeUpdateVO u);

}
