package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsExpertInfoMapper;
import top.tangyh.lamp.learnpm.entity.MsExpertInfo;
import top.tangyh.lamp.learnpm.manager.MsExpertInfoManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 专家信息Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsExpertInfoManagerImpl extends SuperManagerImpl<MsExpertInfoMapper, MsExpertInfo> implements MsExpertInfoManager {

}
