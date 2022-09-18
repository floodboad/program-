package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsContactInfoMapper;
import top.tangyh.lamp.learnpm.entity.MsContactInfo;
import top.tangyh.lamp.learnpm.manager.MsContactInfoManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 联系人信息Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsContactInfoManagerImpl extends SuperManagerImpl<MsContactInfoMapper, MsContactInfo> implements MsContactInfoManager {

}
