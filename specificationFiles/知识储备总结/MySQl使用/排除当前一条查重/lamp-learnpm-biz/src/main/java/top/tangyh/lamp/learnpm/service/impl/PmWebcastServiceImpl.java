package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmWebcast;
import top.tangyh.lamp.learnpm.manager.PmWebcastManager;
import top.tangyh.lamp.learnpm.service.PmWebcastService;
import top.tangyh.lamp.learnpm.vo.query.PmWebcastPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmWebcastResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmWebcastSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmWebcastUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 网上直播业务实现类
 * 
 * </p>
 *
 * @author liyy
 * @date 2022-06-14
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmWebcastServiceImpl extends SuperServiceImpl<PmWebcastManager, Long, PmWebcast, PmWebcastSaveVO, PmWebcastUpdateVO, PmWebcastPageQuery, PmWebcastResultVO>
        implements PmWebcastService {
    
}
