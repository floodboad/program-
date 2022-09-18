package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanAdjust;
import top.tangyh.lamp.learnpm.manager.PmProjectMeetingPlanAdjustManager;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingPlanAdjustService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingPlanAdjustPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingPlanAdjustResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectMeetingPlanAdjustSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingPlanAdjustUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 项目会议规划调整业务实现类
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
public class PmProjectMeetingPlanAdjustServiceImpl extends SuperServiceImpl<PmProjectMeetingPlanAdjustManager, Long, PmProjectMeetingPlanAdjust, PmProjectMeetingPlanAdjustSaveVO, PmProjectMeetingPlanAdjustUpdateVO, PmProjectMeetingPlanAdjustPageQuery, PmProjectMeetingPlanAdjustResultVO>
        implements PmProjectMeetingPlanAdjustService {
    
}
