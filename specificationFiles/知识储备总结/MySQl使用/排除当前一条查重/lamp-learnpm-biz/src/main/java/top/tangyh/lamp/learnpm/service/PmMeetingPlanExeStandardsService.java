package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanExeStandards;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanExeStandards;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingPlanExeStandardsPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanExeStandardsResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingPlanExeStandardsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanExeStandardsUpdateVO;

import java.util.List;

/**
 * <p>
 * 会议规划执行标准业务接口
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmMeetingPlanExeStandardsService extends SuperService<Long, PmMeetingPlanExeStandards, PmMeetingPlanExeStandardsSaveVO, PmMeetingPlanExeStandardsUpdateVO, PmMeetingPlanExeStandardsPageQuery, PmMeetingPlanExeStandardsResultVO> {
    List<PmMeetingPlanExeStandards> getMeetingPlanExeStandards(Long id);
}
