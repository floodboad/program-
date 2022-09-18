package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsExpertInfo;
import top.tangyh.lamp.learnpm.entity.PmConferenceExpertServices;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.manager.PmConferenceExpertServicesManager;
import top.tangyh.lamp.learnpm.service.MsExpertInfoService;
import top.tangyh.lamp.learnpm.service.PmConferenceExpertServicesService;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingApplyService;
import top.tangyh.lamp.learnpm.vo.query.PmConferenceExpertServicesPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmConferenceExpertServicesResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceExpertServicesSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceExpertServicesUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingApplyUpdateVO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 会议专家劳务业务实现类
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
@Transactional(readOnly = false)
public class PmConferenceExpertServicesServiceImpl extends SuperServiceImpl<PmConferenceExpertServicesManager, Long, PmConferenceExpertServices, PmConferenceExpertServicesSaveVO, PmConferenceExpertServicesUpdateVO, PmConferenceExpertServicesPageQuery, PmConferenceExpertServicesResultVO>
        implements PmConferenceExpertServicesService {

    @Override
    public PmConferenceExpertServices getOldRecord(Long id) {
        PmConferenceExpertServices oldRecord = superManager.getOne(Wraps.<PmConferenceExpertServices>lbQ().eq(PmConferenceExpertServices::getId, id));
        return oldRecord;
    }

}
