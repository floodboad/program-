package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmConferenceExpertServicesMapper;
import top.tangyh.lamp.learnpm.entity.PmConferenceExpertServices;
import top.tangyh.lamp.learnpm.manager.PmConferenceExpertServicesManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议专家劳务Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmConferenceExpertServicesManagerImpl extends SuperManagerImpl<PmConferenceExpertServicesMapper, PmConferenceExpertServices> implements PmConferenceExpertServicesManager {

}
