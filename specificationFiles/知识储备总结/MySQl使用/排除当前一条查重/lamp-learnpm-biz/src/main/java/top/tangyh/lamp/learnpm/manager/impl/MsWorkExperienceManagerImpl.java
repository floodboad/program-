package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsWorkExperienceMapper;
import top.tangyh.lamp.learnpm.entity.MsWorkExperience;
import top.tangyh.lamp.learnpm.manager.MsWorkExperienceManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 工作经历Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsWorkExperienceManagerImpl extends SuperManagerImpl<MsWorkExperienceMapper, MsWorkExperience> implements MsWorkExperienceManager {

}
