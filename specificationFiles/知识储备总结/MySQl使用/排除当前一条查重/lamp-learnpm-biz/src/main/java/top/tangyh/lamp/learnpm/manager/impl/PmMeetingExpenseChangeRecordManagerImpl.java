package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmMeetingExpenseChangeRecordMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingExpenseChangeRecord;
import top.tangyh.lamp.learnpm.manager.PmMeetingExpenseChangeRecordManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议费用变更记录Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmMeetingExpenseChangeRecordManagerImpl extends SuperManagerImpl<PmMeetingExpenseChangeRecordMapper, PmMeetingExpenseChangeRecord> implements PmMeetingExpenseChangeRecordManager {

}
