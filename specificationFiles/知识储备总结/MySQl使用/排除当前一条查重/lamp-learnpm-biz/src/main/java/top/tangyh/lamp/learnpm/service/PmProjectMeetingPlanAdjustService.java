package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanAdjust;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanAdjust;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingPlanAdjustPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingPlanAdjustResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectMeetingPlanAdjustSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingPlanAdjustUpdateVO;
/**
 * <p>
 * 项目会议规划调整业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmProjectMeetingPlanAdjustService extends SuperService<Long, PmProjectMeetingPlanAdjust, PmProjectMeetingPlanAdjustSaveVO, PmProjectMeetingPlanAdjustUpdateVO, PmProjectMeetingPlanAdjustPageQuery, PmProjectMeetingPlanAdjustResultVO> {

}
