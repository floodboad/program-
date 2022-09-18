package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmWebcastMapper;
import top.tangyh.lamp.learnpm.entity.PmWebcast;
import top.tangyh.lamp.learnpm.manager.PmWebcastManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 网上直播Manager
 * </p>
 *
 * @author liyy
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmWebcastManagerImpl extends SuperManagerImpl<PmWebcastMapper, PmWebcast> implements PmWebcastManager {

}
