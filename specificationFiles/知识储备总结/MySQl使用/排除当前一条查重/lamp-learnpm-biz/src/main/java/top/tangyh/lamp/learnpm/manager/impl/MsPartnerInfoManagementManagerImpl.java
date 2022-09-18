package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsPartnerInfoManagementMapper;
import top.tangyh.lamp.learnpm.entity.MsPartnerInfoManagement;
import top.tangyh.lamp.learnpm.manager.MsPartnerInfoManagementManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 合作方信息管理Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsPartnerInfoManagementManagerImpl extends SuperManagerImpl<MsPartnerInfoManagementMapper, MsPartnerInfoManagement> implements MsPartnerInfoManagementManager {

}
