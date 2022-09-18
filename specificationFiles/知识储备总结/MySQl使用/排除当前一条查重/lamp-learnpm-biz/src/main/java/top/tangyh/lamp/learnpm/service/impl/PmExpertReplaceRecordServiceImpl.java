package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmConferenceExpertServices;
import top.tangyh.lamp.learnpm.entity.PmExpertReplaceRecord;
import top.tangyh.lamp.learnpm.manager.PmExpertReplaceRecordManager;
import top.tangyh.lamp.learnpm.service.PmExpertReplaceRecordService;
import top.tangyh.lamp.learnpm.vo.query.PmExpertReplaceRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmExpertReplaceRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceExpertServicesSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertReplaceRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceExpertServicesUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertReplaceRecordUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import java.sql.Wrapper;

/**
 * <p>
 * 专家更换记录业务实现类
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
public class PmExpertReplaceRecordServiceImpl extends SuperServiceImpl<PmExpertReplaceRecordManager, Long, PmExpertReplaceRecord, PmExpertReplaceRecordSaveVO, PmExpertReplaceRecordUpdateVO, PmExpertReplaceRecordPageQuery, PmExpertReplaceRecordResultVO>
        implements PmExpertReplaceRecordService {

    /**
     * 产生更新的记录信息，用来更新专家信息时存储专家更换记录表
     * @param u
     * @return 新记录
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmExpertReplaceRecord saveRecord(PmConferenceExpertServicesUpdateVO u) {
            PmExpertReplaceRecord record = PmExpertReplaceRecord.builder()
                    .pmProjectMeetingApplyId(u.getPmProjectMeetingApplyId())
                    .pmProjectId(u.getPmProjectId())
                    .meetingSupportProjectName(u.getProjectName())
                    .meetingNoName(u.getProjectMeetingPlanningName())
                    .nowExpertInfoName(u.getExpertInfoName())
                    .nowMsExpertInfoId(u.getMsExpertInfoId())
                    .pmConferenceExpertServicesId(u.getId())
                    .status("01").illustrate("无")
                    .build();
            return record;
    }
}
