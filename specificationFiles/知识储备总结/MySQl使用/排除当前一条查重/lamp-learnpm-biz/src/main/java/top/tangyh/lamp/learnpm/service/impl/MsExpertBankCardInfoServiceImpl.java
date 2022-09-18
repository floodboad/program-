package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsExpertBankCardInfo;
import top.tangyh.lamp.learnpm.manager.MsExpertBankCardInfoManager;
import top.tangyh.lamp.learnpm.service.MsExpertBankCardInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsExpertBankCardInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExpertBankCardInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExpertBankCardInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExpertBankCardInfoUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 专家银行卡信息业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsExpertBankCardInfoServiceImpl extends SuperServiceImpl<MsExpertBankCardInfoManager, Long, MsExpertBankCardInfo, MsExpertBankCardInfoSaveVO, MsExpertBankCardInfoUpdateVO, MsExpertBankCardInfoPageQuery, MsExpertBankCardInfoResultVO>
        implements MsExpertBankCardInfoService {
    
}
