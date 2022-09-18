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
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.entity.PmTransportationReservation;
import top.tangyh.lamp.learnpm.manager.PmTransportationReservationManager;
import top.tangyh.lamp.learnpm.service.PmConferenceApplyFeeService;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingApplyService;
import top.tangyh.lamp.learnpm.service.PmTransportationReservationService;
import top.tangyh.lamp.learnpm.vo.query.PmTransportationReservationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmTransportationReservationResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmTransportationReservationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmTransportationReservationUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 交通预定业务实现类
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
public class PmTransportationReservationServiceImpl extends SuperServiceImpl<PmTransportationReservationManager, Long, PmTransportationReservation, PmTransportationReservationSaveVO, PmTransportationReservationUpdateVO, PmTransportationReservationPageQuery, PmTransportationReservationResultVO>
        implements PmTransportationReservationService {
    private final PmConferenceApplyFeeService pmConferenceApplyFeeService;
    private final PmProjectMeetingApplyService pmProjectMeetingApplyService;

    /**
     * 美团打车接口
     * @param id
     * @return
     */
    @Override
    public PmTransportationReservationSaveVO orderCar(Long id) {
        PmProjectMeetingApply meetingApply = pmProjectMeetingApplyService.getById(id);
        PmConferenceApplyFee conferenceApplyFee = pmConferenceApplyFeeService.getConferenceApplyFee(id);
        PmTransportationReservationSaveVO pmTransportationReservationSaveVO = new PmTransportationReservationSaveVO();
        //设置费用id
        pmTransportationReservationSaveVO.setPmConferenceApplyFeeId(conferenceApplyFee.getId());
        //设置会议申请费用表id
        pmTransportationReservationSaveVO.setPmConferenceApplyFeeId(conferenceApplyFee.getId());
        //设置项目相关信息
        pmTransportationReservationSaveVO.setPmProjectId(meetingApply.getPmProjectId());
        pmTransportationReservationSaveVO.setProjectName(meetingApply.getMeetingSupportProjectName());
        //设置会议名称
        pmTransportationReservationSaveVO.setMeetingName(meetingApply.getMeetingSupportProjectName());
        return pmTransportationReservationSaveVO;
    }
}
