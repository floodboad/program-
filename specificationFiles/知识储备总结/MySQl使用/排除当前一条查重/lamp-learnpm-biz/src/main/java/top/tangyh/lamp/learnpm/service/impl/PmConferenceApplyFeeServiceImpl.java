package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmConferenceApplyFee;
import top.tangyh.lamp.learnpm.manager.PmConferenceApplyFeeManager;
import top.tangyh.lamp.learnpm.service.PmConferenceApplyFeeService;
import top.tangyh.lamp.learnpm.vo.query.PmConferenceApplyFeePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmConferenceApplyFeeResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceApplyFeeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceApplyFeeUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 会议申请费用表业务实现类
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmConferenceApplyFeeServiceImpl extends SuperServiceImpl<PmConferenceApplyFeeManager, Long, PmConferenceApplyFee, PmConferenceApplyFeeSaveVO, PmConferenceApplyFeeUpdateVO, PmConferenceApplyFeePageQuery, PmConferenceApplyFeeResultVO>
        implements PmConferenceApplyFeeService {


    @Override
    public PmConferenceApplyFee getOldAmount(Long id) {
        PmConferenceApplyFee oldRecord = superManager.getOne(Wraps.<PmConferenceApplyFee>lbQ().eq(PmConferenceApplyFee::getId, id));
        return oldRecord;
    }

    @Override
    public PmConferenceApplyFee getConferenceApplyFee(Long meetingId) {
        PmConferenceApplyFee applyFee = superManager.getOne(Wraps.<PmConferenceApplyFee>lbQ()
                .eq(PmConferenceApplyFee::getPmProjectMeetingApplyId, meetingId)
                .eq(PmConferenceApplyFee::getFeeName, "餐费"));
        return applyFee;
    }

    @Override
    public HashMap<String, Object> designApplicationAmount(List<PmConferenceApplyFee> list,BigDecimal budgetRemainingAmount) {
        BigDecimal designBugdet = new BigDecimal(0);
        BigDecimal disposableAmount = budgetRemainingAmount;
        for (PmConferenceApplyFee item : list) {
            // 设计预算
            designBugdet = designBugdet.add(item.getAmountMoney());
        }
        // 可支配金额
        if (disposableAmount.compareTo(designBugdet)<1){   // 剩余金额小于等于预算
        }else {
            disposableAmount = designBugdet;
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("设计预算",designBugdet);
        map.put("可支配金额",disposableAmount);
        return map;
    }
}
