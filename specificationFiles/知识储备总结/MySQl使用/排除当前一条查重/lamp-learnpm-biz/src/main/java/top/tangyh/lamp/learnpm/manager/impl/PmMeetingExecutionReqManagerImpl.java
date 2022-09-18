package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmMeetingExecutionReqMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReq;
import top.tangyh.lamp.learnpm.manager.PmMeetingExecutionReqManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议执行要求Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmMeetingExecutionReqManagerImpl extends SuperManagerImpl<PmMeetingExecutionReqMapper, PmMeetingExecutionReq> implements PmMeetingExecutionReqManager {

}
