package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmOnlineMeetingPublishMapper;
import top.tangyh.lamp.learnpm.entity.PmOnlineMeetingPublish;
import top.tangyh.lamp.learnpm.manager.PmOnlineMeetingPublishManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 线上会议发布Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmOnlineMeetingPublishManagerImpl extends SuperManagerImpl<PmOnlineMeetingPublishMapper, PmOnlineMeetingPublish> implements PmOnlineMeetingPublishManager {

}
