package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmProjectMeetingPlanAdjustMapper;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanAdjust;
import top.tangyh.lamp.learnpm.manager.PmProjectMeetingPlanAdjustManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目会议规划调整Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProjectMeetingPlanAdjustManagerImpl extends SuperManagerImpl<PmProjectMeetingPlanAdjustMapper, PmProjectMeetingPlanAdjust> implements PmProjectMeetingPlanAdjustManager {

}
