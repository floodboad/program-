package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanExeStandardsAdj;
import top.tangyh.lamp.learnpm.manager.PmMeetingPlanExeStandardsAdjManager;
import top.tangyh.lamp.learnpm.service.PmMeetingPlanExeStandardsAdjService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingPlanExeStandardsAdjPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanExeStandardsAdjResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingPlanExeStandardsAdjSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanExeStandardsAdjUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 会议规划执行标准调整记录业务实现类
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
public class PmMeetingPlanExeStandardsAdjServiceImpl extends SuperServiceImpl<PmMeetingPlanExeStandardsAdjManager, Long, PmMeetingPlanExeStandardsAdj, PmMeetingPlanExeStandardsAdjSaveVO, PmMeetingPlanExeStandardsAdjUpdateVO, PmMeetingPlanExeStandardsAdjPageQuery, PmMeetingPlanExeStandardsAdjResultVO>
        implements PmMeetingPlanExeStandardsAdjService {
    
}
