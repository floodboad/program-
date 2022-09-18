package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmConferenceApplyFee;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmConferenceApplyFee;
import top.tangyh.lamp.learnpm.vo.query.PmConferenceApplyFeePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmConferenceApplyFeeResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceApplyFeeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceApplyFeeUpdateVO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 会议申请费用表业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
public interface PmConferenceApplyFeeService extends SuperService<Long, PmConferenceApplyFee, PmConferenceApplyFeeSaveVO, PmConferenceApplyFeeUpdateVO, PmConferenceApplyFeePageQuery, PmConferenceApplyFeeResultVO> {
    PmConferenceApplyFee getOldAmount(Long id);
    PmConferenceApplyFee getConferenceApplyFee(Long meetingId);

    // designApplicationAmount
    HashMap<String, Object> designApplicationAmount(List<PmConferenceApplyFee> list,BigDecimal budgetRemainingAmount);
}
