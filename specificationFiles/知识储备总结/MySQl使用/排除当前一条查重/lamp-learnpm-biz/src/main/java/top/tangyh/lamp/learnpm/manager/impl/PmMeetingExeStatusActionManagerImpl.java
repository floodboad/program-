package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmMeetingExeStatusActionMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingExeStatusAction;
import top.tangyh.lamp.learnpm.manager.PmMeetingExeStatusActionManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议执行状态操作表Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmMeetingExeStatusActionManagerImpl extends SuperManagerImpl<PmMeetingExeStatusActionMapper, PmMeetingExeStatusAction> implements PmMeetingExeStatusActionManager {

}
