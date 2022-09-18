package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanExeStandardsAdj;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanExeStandardsAdj;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingPlanExeStandardsAdjPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanExeStandardsAdjResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingPlanExeStandardsAdjSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanExeStandardsAdjUpdateVO;
/**
 * <p>
 * 会议规划执行标准调整记录业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmMeetingPlanExeStandardsAdjService extends SuperService<Long, PmMeetingPlanExeStandardsAdj, PmMeetingPlanExeStandardsAdjSaveVO, PmMeetingPlanExeStandardsAdjUpdateVO, PmMeetingPlanExeStandardsAdjPageQuery, PmMeetingPlanExeStandardsAdjResultVO> {

}
