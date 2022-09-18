package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsExpertBankCardInfoMapper;
import top.tangyh.lamp.learnpm.entity.MsExpertBankCardInfo;
import top.tangyh.lamp.learnpm.manager.MsExpertBankCardInfoManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 专家银行卡信息Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsExpertBankCardInfoManagerImpl extends SuperManagerImpl<MsExpertBankCardInfoMapper, MsExpertBankCardInfo> implements MsExpertBankCardInfoManager {

}
