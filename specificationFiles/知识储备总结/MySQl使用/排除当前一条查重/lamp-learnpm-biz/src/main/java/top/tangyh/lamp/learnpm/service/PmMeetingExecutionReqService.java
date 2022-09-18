package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReq;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReq;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExecutionReqPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExecutionReqResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExecutionReqSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExecutionReqUpdateVO;
/**
 * <p>
 * 会议执行要求业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmMeetingExecutionReqService extends SuperService<Long, PmMeetingExecutionReq, PmMeetingExecutionReqSaveVO, PmMeetingExecutionReqUpdateVO, PmMeetingExecutionReqPageQuery, PmMeetingExecutionReqResultVO> {

}
