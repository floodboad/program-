package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmOnlineMeetingPublish;
import top.tangyh.lamp.learnpm.manager.PmOnlineMeetingPublishManager;
import top.tangyh.lamp.learnpm.service.PmOnlineMeetingPublishService;
import top.tangyh.lamp.learnpm.vo.query.PmOnlineMeetingPublishPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOnlineMeetingPublishResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOnlineMeetingPublishSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOnlineMeetingPublishUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 线上会议发布业务实现类
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmOnlineMeetingPublishServiceImpl extends SuperServiceImpl<PmOnlineMeetingPublishManager, Long, PmOnlineMeetingPublish, PmOnlineMeetingPublishSaveVO, PmOnlineMeetingPublishUpdateVO, PmOnlineMeetingPublishPageQuery, PmOnlineMeetingPublishResultVO>
        implements PmOnlineMeetingPublishService {
    
}
