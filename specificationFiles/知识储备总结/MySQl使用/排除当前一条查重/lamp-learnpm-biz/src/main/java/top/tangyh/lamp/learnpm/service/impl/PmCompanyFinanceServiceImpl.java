package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmCompanyFinance;
import top.tangyh.lamp.learnpm.manager.PmCompanyFinanceManager;
import top.tangyh.lamp.learnpm.service.PmCompanyFinanceService;
import top.tangyh.lamp.learnpm.vo.query.PmCompanyFinancePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmCompanyFinanceResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmCompanyFinanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmCompanyFinanceUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 公司财务人员业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmCompanyFinanceServiceImpl extends SuperServiceImpl<PmCompanyFinanceManager, Long, PmCompanyFinance, PmCompanyFinanceSaveVO, PmCompanyFinanceUpdateVO, PmCompanyFinancePageQuery, PmCompanyFinanceResultVO>
        implements PmCompanyFinanceService {
    
}
