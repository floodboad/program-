package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmMeetingMaterialsRegMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingMaterialsReg;
import top.tangyh.lamp.learnpm.manager.PmMeetingMaterialsRegManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议合规材料登记Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmMeetingMaterialsRegManagerImpl extends SuperManagerImpl<PmMeetingMaterialsRegMapper, PmMeetingMaterialsReg> implements PmMeetingMaterialsRegManager {

}
