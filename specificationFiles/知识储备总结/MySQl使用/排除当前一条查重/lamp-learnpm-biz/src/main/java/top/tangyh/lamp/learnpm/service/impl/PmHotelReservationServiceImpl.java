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
import top.tangyh.lamp.learnpm.entity.PmHotelReservation;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.manager.PmHotelReservationManager;
import top.tangyh.lamp.learnpm.service.PmConferenceApplyFeeService;
import top.tangyh.lamp.learnpm.service.PmHotelReservationService;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingApplyService;
import top.tangyh.lamp.learnpm.vo.query.PmHotelReservationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmHotelReservationResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmHotelReservationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmHotelReservationUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 订酒店业务实现类
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
public class PmHotelReservationServiceImpl extends SuperServiceImpl<PmHotelReservationManager, Long, PmHotelReservation, PmHotelReservationSaveVO, PmHotelReservationUpdateVO, PmHotelReservationPageQuery, PmHotelReservationResultVO>
        implements PmHotelReservationService {
    private final PmConferenceApplyFeeService pmConferenceApplyFeeService;
    private final PmProjectMeetingApplyService pmProjectMeetingApplyService;

    /**
     * 订酒店接口用
     * @param id
     * @return
     */
    @Override
    public PmHotelReservationSaveVO orderHotel(Long id) {
        PmHotelReservationSaveVO pmHotelReservationSaveVO = new PmHotelReservationSaveVO();
        PmProjectMeetingApply meetingApply = pmProjectMeetingApplyService.getById(id);
        pmHotelReservationSaveVO.setPmProjectMeetingApplyId(id);
        PmConferenceApplyFee conferenceApplyFee = pmConferenceApplyFeeService.getConferenceApplyFee(id);
        //设置会议申请费用表id
        pmHotelReservationSaveVO.setPmConferenceApplyFeeId(conferenceApplyFee.getId());
        //设置项目相关信息
        pmHotelReservationSaveVO.setPmProjectId(meetingApply.getPmProjectId());
        pmHotelReservationSaveVO.setProjectName(meetingApply.getMeetingSupportProjectName());
        //设置会议名称
        pmHotelReservationSaveVO.setMeetingName(meetingApply.getMeetingSupportProjectName());
        return pmHotelReservationSaveVO;
    }
}
