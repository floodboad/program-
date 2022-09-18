package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmMeetingPlanExeStandardsMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanExeStandards;
import top.tangyh.lamp.learnpm.manager.PmMeetingPlanExeStandardsManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议规划执行标准Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmMeetingPlanExeStandardsManagerImpl extends SuperManagerImpl<PmMeetingPlanExeStandardsMapper, PmMeetingPlanExeStandards> implements PmMeetingPlanExeStandardsManager {

}
