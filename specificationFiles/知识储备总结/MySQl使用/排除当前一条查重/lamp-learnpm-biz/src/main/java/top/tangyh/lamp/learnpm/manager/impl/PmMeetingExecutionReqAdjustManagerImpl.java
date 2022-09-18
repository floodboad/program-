package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmMeetingExecutionReqAdjustMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReqAdjust;
import top.tangyh.lamp.learnpm.manager.PmMeetingExecutionReqAdjustManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议执行要求调整记录Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmMeetingExecutionReqAdjustManagerImpl extends SuperManagerImpl<PmMeetingExecutionReqAdjustMapper, PmMeetingExecutionReqAdjust> implements PmMeetingExecutionReqAdjustManager {

}
