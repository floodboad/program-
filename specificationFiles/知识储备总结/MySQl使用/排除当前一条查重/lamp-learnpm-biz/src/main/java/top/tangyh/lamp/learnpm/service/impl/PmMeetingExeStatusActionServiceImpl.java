package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmMeetingExeStatusAction;
import top.tangyh.lamp.learnpm.manager.PmMeetingExeStatusActionManager;
import top.tangyh.lamp.learnpm.service.PmMeetingExeStatusActionService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExeStatusActionPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExeStatusActionResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExeStatusActionSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExeStatusActionUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 会议执行状态操作表业务实现类
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmMeetingExeStatusActionServiceImpl extends SuperServiceImpl<PmMeetingExeStatusActionManager, Long, PmMeetingExeStatusAction, PmMeetingExeStatusActionSaveVO, PmMeetingExeStatusActionUpdateVO, PmMeetingExeStatusActionPageQuery, PmMeetingExeStatusActionResultVO>
        implements PmMeetingExeStatusActionService {
    
}
