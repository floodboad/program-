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
import top.tangyh.lamp.learnpm.entity.PmOrderFood;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.manager.PmOrderFoodManager;
import top.tangyh.lamp.learnpm.service.PmConferenceApplyFeeService;
import top.tangyh.lamp.learnpm.service.PmOrderFoodService;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingApplyService;
import top.tangyh.lamp.learnpm.vo.query.PmOrderFoodPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOrderFoodResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOrderFoodSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOrderFoodUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import javax.validation.constraints.Size;

/**
 * <p>
 * 订餐业务实现类
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
public class PmOrderFoodServiceImpl extends SuperServiceImpl<PmOrderFoodManager, Long, PmOrderFood, PmOrderFoodSaveVO, PmOrderFoodUpdateVO, PmOrderFoodPageQuery, PmOrderFoodResultVO>
        implements PmOrderFoodService {
    private PmProjectMeetingApplyService pmProjectMeetingApplyService;
    private PmConferenceApplyFeeService pmConferenceApplyFeeService;
    /**
     * 获取会议申请费用表（商企通餐费）
     * @param applyId
     * @return 会议申请费用表实例
     */
    @Override
    public PmOrderFoodSaveVO orderFood(Long applyId) {
        PmConferenceApplyFee conferenceApplyFee = pmConferenceApplyFeeService.getConferenceApplyFee(applyId);
        PmProjectMeetingApply meetingApply = pmProjectMeetingApplyService.getById(applyId);
        PmOrderFoodSaveVO pmOrderFoodSaveVO = new PmOrderFoodSaveVO();
        pmOrderFoodSaveVO.setPmProjectMeetingApplyId(applyId);
        //设置会议申请费用表id
        pmOrderFoodSaveVO.setPmConferenceApplyFeeId(conferenceApplyFee.getId());
        //设置订单类型
        pmOrderFoodSaveVO.setOrderType(DSConstant.DICTIONARY_ORDER_TYPE_01);
        //设置费用类型
        pmOrderFoodSaveVO.setFeeType(DSConstant.DICTIONARY_FEE_TYPE_02);
        //设置项目id,name
        pmOrderFoodSaveVO.setPmProjectId(meetingApply.getPmProjectId());
        pmOrderFoodSaveVO.setProjectName(meetingApply.getMeetingSupportProjectName());
        pmOrderFoodSaveVO.setMeetingName(meetingApply.getMeetingSupportProjectName());
        return pmOrderFoodSaveVO;

    }
}
