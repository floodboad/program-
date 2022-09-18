package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmCompanyFinance;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmCompanyFinance;
import top.tangyh.lamp.learnpm.vo.query.PmCompanyFinancePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmCompanyFinanceResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmCompanyFinanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmCompanyFinanceUpdateVO;
/**
 * <p>
 * 公司财务人员业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
public interface PmCompanyFinanceService extends SuperService<Long, PmCompanyFinance, PmCompanyFinanceSaveVO, PmCompanyFinanceUpdateVO, PmCompanyFinancePageQuery, PmCompanyFinanceResultVO> {

}
