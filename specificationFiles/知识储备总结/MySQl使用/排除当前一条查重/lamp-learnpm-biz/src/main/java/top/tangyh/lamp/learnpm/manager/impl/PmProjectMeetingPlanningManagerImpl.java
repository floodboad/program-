package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmProjectMeetingPlanningMapper;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanning;
import top.tangyh.lamp.learnpm.manager.PmProjectMeetingPlanningManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目会议规划Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProjectMeetingPlanningManagerImpl extends SuperManagerImpl<PmProjectMeetingPlanningMapper, PmProjectMeetingPlanning> implements PmProjectMeetingPlanningManager {

}
