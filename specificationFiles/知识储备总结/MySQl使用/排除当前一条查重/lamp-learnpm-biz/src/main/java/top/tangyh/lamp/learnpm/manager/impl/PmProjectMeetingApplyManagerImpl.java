package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmProjectMeetingApplyMapper;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.manager.PmProjectMeetingApplyManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目会议申请Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProjectMeetingApplyManagerImpl extends SuperManagerImpl<PmProjectMeetingApplyMapper, PmProjectMeetingApply> implements PmProjectMeetingApplyManager {

}
