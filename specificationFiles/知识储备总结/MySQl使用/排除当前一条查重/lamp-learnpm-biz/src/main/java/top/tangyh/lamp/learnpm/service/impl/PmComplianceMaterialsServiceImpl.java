package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterials;
import top.tangyh.lamp.learnpm.manager.PmComplianceMaterialsManager;
import top.tangyh.lamp.learnpm.service.PmComplianceMaterialsService;
import top.tangyh.lamp.learnpm.vo.query.PmComplianceMaterialsPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmComplianceMaterialsResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmComplianceMaterialsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmComplianceMaterialsUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 项目合规材料业务实现类
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
public class PmComplianceMaterialsServiceImpl extends SuperServiceImpl<PmComplianceMaterialsManager, Long, PmComplianceMaterials, PmComplianceMaterialsSaveVO, PmComplianceMaterialsUpdateVO, PmComplianceMaterialsPageQuery, PmComplianceMaterialsResultVO>
        implements PmComplianceMaterialsService {
    
}
