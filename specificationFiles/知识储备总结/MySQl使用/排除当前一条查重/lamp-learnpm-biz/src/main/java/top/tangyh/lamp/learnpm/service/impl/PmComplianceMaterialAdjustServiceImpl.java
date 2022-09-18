package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterialAdjust;
import top.tangyh.lamp.learnpm.manager.PmComplianceMaterialAdjustManager;
import top.tangyh.lamp.learnpm.service.PmComplianceMaterialAdjustService;
import top.tangyh.lamp.learnpm.vo.query.PmComplianceMaterialAdjustPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmComplianceMaterialAdjustResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmComplianceMaterialAdjustSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmComplianceMaterialAdjustUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 项目合规材料调整业务实现类
 * 
 * </p>
 *
 * @author liyy
 * @date 2022-06-28
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmComplianceMaterialAdjustServiceImpl extends SuperServiceImpl<PmComplianceMaterialAdjustManager, Long, PmComplianceMaterialAdjust, PmComplianceMaterialAdjustSaveVO, PmComplianceMaterialAdjustUpdateVO, PmComplianceMaterialAdjustPageQuery, PmComplianceMaterialAdjustResultVO>
        implements PmComplianceMaterialAdjustService {
    
}
