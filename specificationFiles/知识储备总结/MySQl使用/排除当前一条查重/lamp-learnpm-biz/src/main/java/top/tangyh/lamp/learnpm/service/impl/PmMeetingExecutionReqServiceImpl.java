package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReq;
import top.tangyh.lamp.learnpm.manager.PmMeetingExecutionReqManager;
import top.tangyh.lamp.learnpm.service.PmMeetingExecutionReqService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExecutionReqPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExecutionReqResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExecutionReqSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExecutionReqUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 会议执行要求业务实现类
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmMeetingExecutionReqServiceImpl extends SuperServiceImpl<PmMeetingExecutionReqManager, Long, PmMeetingExecutionReq, PmMeetingExecutionReqSaveVO, PmMeetingExecutionReqUpdateVO, PmMeetingExecutionReqPageQuery, PmMeetingExecutionReqResultVO>
        implements PmMeetingExecutionReqService {
    
}
