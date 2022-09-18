package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmConferenceApplyFee;
import top.tangyh.lamp.learnpm.entity.PmOrderExpress;
import top.tangyh.lamp.learnpm.entity.PmSenderReceiver;
import top.tangyh.lamp.learnpm.manager.PmOrderExpressManager;
import top.tangyh.lamp.learnpm.service.PmConferenceApplyFeeService;
import top.tangyh.lamp.learnpm.service.PmOrderExpressService;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingApplyService;
import top.tangyh.lamp.learnpm.service.PmSenderReceiverService;
import top.tangyh.lamp.learnpm.vo.query.PmOrderExpressPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOrderExpressResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOrderExpressSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOrderExpressUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.wechat.OrderExpress;

/**
 * <p>
 * 定快递业务实现类
 *
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmOrderExpressServiceImpl extends SuperServiceImpl<PmOrderExpressManager, Long, PmOrderExpress, PmOrderExpressSaveVO, PmOrderExpressUpdateVO, PmOrderExpressPageQuery, PmOrderExpressResultVO>
        implements PmOrderExpressService {
    private final PmConferenceApplyFeeService pmConferenceApplyFeeService;
    private final PmSenderReceiverService pmSenderReceiverService;
    @Override
    public PmOrderExpress insert(OrderExpress orderExpress) throws Exception {

        //查询快递预算
        PmConferenceApplyFee fee = pmConferenceApplyFeeService.getById(orderExpress.getMeetingFeeId());
        //查询发件人
        PmSenderReceiver sender = pmSenderReceiverService.getById(orderExpress.getSenderId());
        //查询收件人
        PmSenderReceiver receiver = pmSenderReceiverService.getById(orderExpress.getRecipientId());
        PmOrderExpressSaveVO saveVO = new PmOrderExpressSaveVO();
        saveVO.setPmProjectMeetingApplyId(fee.getPmProjectMeetingApplyId());
        saveVO.setPmProjectId(fee.getPmProjectId());
        saveVO.setMeetingName(orderExpress.getMeetingName());
        saveVO.setProjectName(fee.getProjectName());
        saveVO.setExpressStatus(DSConstant.DICTIONARY_ADJUST_STATUS_01);
        saveVO.setSenderName(sender.getName());
        saveVO.setSenderPhone(sender.getPhone());
        saveVO.setSendingCity(sender.getCity());
        saveVO.setSendingDetailAddress(sender.getAddress());
        saveVO.setSendingProvince(sender.getProvince());
        saveVO.setRecipientCity(sender.getCity());
        saveVO.setRecipientDetailedAddress(receiver.getAddress());
        saveVO.setRecipientName(receiver.getName());
        saveVO.setRecipientPhone(receiver.getPhone());
        saveVO.setRecipientProvince(receiver.getProvince());
        // todo 调用顺丰下单接口
       /* saveVO.setAfterThisTimeRemainingAmount();
        saveVO.setBudgetAmount();
         saveVO.setExpressCompany();
        saveVO.setExpressNumber();
        saveVO.setExpressFee();
        saveVO.setExpressFeeRemainingAmount();
        */

        return save(saveVO);
    }
}
