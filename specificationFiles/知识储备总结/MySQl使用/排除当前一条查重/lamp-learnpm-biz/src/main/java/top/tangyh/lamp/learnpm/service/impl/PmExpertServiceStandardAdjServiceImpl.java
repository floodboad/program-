package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandardAdj;
import top.tangyh.lamp.learnpm.manager.PmExpertServiceStandardAdjManager;
import top.tangyh.lamp.learnpm.service.PmExpertServiceStandardAdjService;
import top.tangyh.lamp.learnpm.vo.query.PmExpertServiceStandardAdjPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmExpertServiceStandardAdjResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertServiceStandardAdjSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertServiceStandardAdjUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 会议规划专家劳务标准调整记录业务实现类
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
public class PmExpertServiceStandardAdjServiceImpl extends SuperServiceImpl<PmExpertServiceStandardAdjManager, Long, PmExpertServiceStandardAdj, PmExpertServiceStandardAdjSaveVO, PmExpertServiceStandardAdjUpdateVO, PmExpertServiceStandardAdjPageQuery, PmExpertServiceStandardAdjResultVO>
        implements PmExpertServiceStandardAdjService {
    
}
