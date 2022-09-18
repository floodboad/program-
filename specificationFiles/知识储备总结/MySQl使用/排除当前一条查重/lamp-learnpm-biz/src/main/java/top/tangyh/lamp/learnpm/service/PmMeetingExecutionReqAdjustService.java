package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReqAdjust;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReqAdjust;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExecutionReqAdjustPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExecutionReqAdjustResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExecutionReqAdjustSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExecutionReqAdjustUpdateVO;
/**
 * <p>
 * 会议执行要求调整记录业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmMeetingExecutionReqAdjustService extends SuperService<Long, PmMeetingExecutionReqAdjust, PmMeetingExecutionReqAdjustSaveVO, PmMeetingExecutionReqAdjustUpdateVO, PmMeetingExecutionReqAdjustPageQuery, PmMeetingExecutionReqAdjustResultVO> {

}
