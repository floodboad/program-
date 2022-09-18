package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsLongzhuMeetingTypeMapper;
import top.tangyh.lamp.learnpm.entity.MsLongzhuMeetingType;
import top.tangyh.lamp.learnpm.manager.MsLongzhuMeetingTypeManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议类型七龙珠配置Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsLongzhuMeetingTypeManagerImpl extends SuperManagerImpl<MsLongzhuMeetingTypeMapper, MsLongzhuMeetingType> implements MsLongzhuMeetingTypeManager {

}
