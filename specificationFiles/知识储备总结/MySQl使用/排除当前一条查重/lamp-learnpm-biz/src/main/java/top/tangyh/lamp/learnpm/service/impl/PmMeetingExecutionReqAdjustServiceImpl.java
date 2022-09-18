package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReqAdjust;
import top.tangyh.lamp.learnpm.manager.PmMeetingExecutionReqAdjustManager;
import top.tangyh.lamp.learnpm.service.PmMeetingExecutionReqAdjustService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExecutionReqAdjustPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExecutionReqAdjustResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExecutionReqAdjustSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExecutionReqAdjustUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 会议执行要求调整记录业务实现类
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
public class PmMeetingExecutionReqAdjustServiceImpl extends SuperServiceImpl<PmMeetingExecutionReqAdjustManager, Long, PmMeetingExecutionReqAdjust, PmMeetingExecutionReqAdjustSaveVO, PmMeetingExecutionReqAdjustUpdateVO, PmMeetingExecutionReqAdjustPageQuery, PmMeetingExecutionReqAdjustResultVO>
        implements PmMeetingExecutionReqAdjustService {
    
}
