package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmMeetingPlanAllocationMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanAllocation;
import top.tangyh.lamp.learnpm.manager.PmMeetingPlanAllocationManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议规划分配Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmMeetingPlanAllocationManagerImpl extends SuperManagerImpl<PmMeetingPlanAllocationMapper, PmMeetingPlanAllocation> implements PmMeetingPlanAllocationManager {

}
