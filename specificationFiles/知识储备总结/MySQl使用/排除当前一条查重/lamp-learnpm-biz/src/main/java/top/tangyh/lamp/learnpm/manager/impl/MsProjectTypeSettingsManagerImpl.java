package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsProjectTypeSettingsMapper;
import top.tangyh.lamp.learnpm.entity.MsProjectTypeSettings;
import top.tangyh.lamp.learnpm.manager.MsProjectTypeSettingsManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目类型设置Manager
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsProjectTypeSettingsManagerImpl extends SuperManagerImpl<MsProjectTypeSettingsMapper, MsProjectTypeSettings> implements MsProjectTypeSettingsManager {

}
