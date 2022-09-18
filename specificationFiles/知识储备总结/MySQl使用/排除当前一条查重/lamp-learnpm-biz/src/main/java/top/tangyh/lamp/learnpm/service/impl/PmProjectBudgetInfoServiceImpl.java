package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmProjectBudgetInfo;
import top.tangyh.lamp.learnpm.manager.PmProjectBudgetInfoManager;
import top.tangyh.lamp.learnpm.service.PmProjectBudgetInfoService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectBudgetInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectBudgetInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectBudgetInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectBudgetInfoUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 项目预算信息业务实现类
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmProjectBudgetInfoServiceImpl extends SuperServiceImpl<PmProjectBudgetInfoManager, Long, PmProjectBudgetInfo, PmProjectBudgetInfoSaveVO, PmProjectBudgetInfoUpdateVO, PmProjectBudgetInfoPageQuery, PmProjectBudgetInfoResultVO>
        implements PmProjectBudgetInfoService {
    
}
