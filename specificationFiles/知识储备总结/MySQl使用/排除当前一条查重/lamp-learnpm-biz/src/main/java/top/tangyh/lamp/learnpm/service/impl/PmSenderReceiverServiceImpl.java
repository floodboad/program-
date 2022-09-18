package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmSenderReceiver;
import top.tangyh.lamp.learnpm.manager.PmSenderReceiverManager;
import top.tangyh.lamp.learnpm.service.PmSenderReceiverService;
import top.tangyh.lamp.learnpm.vo.query.PmSenderReceiverPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmSenderReceiverResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmSenderReceiverSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmSenderReceiverUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 收发件人业务实现类
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-09
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmSenderReceiverServiceImpl extends SuperServiceImpl<PmSenderReceiverManager, Long, PmSenderReceiver, PmSenderReceiverSaveVO, PmSenderReceiverUpdateVO, PmSenderReceiverPageQuery, PmSenderReceiverResultVO>
        implements PmSenderReceiverService {
    
}
