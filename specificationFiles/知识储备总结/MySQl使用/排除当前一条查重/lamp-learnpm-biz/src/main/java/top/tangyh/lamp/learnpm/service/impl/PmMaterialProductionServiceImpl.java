package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmMaterialProduction;
import top.tangyh.lamp.learnpm.manager.PmMaterialProductionManager;
import top.tangyh.lamp.learnpm.service.PmMaterialProductionService;
import top.tangyh.lamp.learnpm.vo.query.PmMaterialProductionPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMaterialProductionResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMaterialProductionSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMaterialProductionUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 物料制作业务实现类
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
public class PmMaterialProductionServiceImpl extends SuperServiceImpl<PmMaterialProductionManager, Long, PmMaterialProduction, PmMaterialProductionSaveVO, PmMaterialProductionUpdateVO, PmMaterialProductionPageQuery, PmMaterialProductionResultVO>
        implements PmMaterialProductionService {
    
}
