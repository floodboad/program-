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
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanExeStandards;
import top.tangyh.lamp.learnpm.manager.PmMeetingPlanExeStandardsManager;
import top.tangyh.lamp.learnpm.service.PmMeetingPlanExeStandardsService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingPlanExeStandardsPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanExeStandardsResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingPlanExeStandardsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanExeStandardsUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import java.util.List;

/**
 * <p>
 * 会议规划执行标准业务实现类
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmMeetingPlanExeStandardsServiceImpl extends SuperServiceImpl<PmMeetingPlanExeStandardsManager, Long, PmMeetingPlanExeStandards, PmMeetingPlanExeStandardsSaveVO, PmMeetingPlanExeStandardsUpdateVO, PmMeetingPlanExeStandardsPageQuery, PmMeetingPlanExeStandardsResultVO>
        implements PmMeetingPlanExeStandardsService {

    @Override
    public List<PmMeetingPlanExeStandards> getMeetingPlanExeStandards(Long id) {
        List<PmMeetingPlanExeStandards> MeetingPlanExeStandards = superManager.list(Wraps.<PmMeetingPlanExeStandards>lbQ().eq(PmMeetingPlanExeStandards::getPmProjectMeetingPlanningId, id));
        return MeetingPlanExeStandards;
    }
}
