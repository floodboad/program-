package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmOtherExpensesReg;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmOtherExpensesReg;
import top.tangyh.lamp.learnpm.vo.query.PmOtherExpensesRegPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOtherExpensesRegResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOtherExpensesRegSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOtherExpensesRegUpdateVO;
/**
 * <p>
 * 会议执行费用支付录入业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-07-04
 */
public interface PmOtherExpensesRegService extends SuperService<Long, PmOtherExpensesReg, PmOtherExpensesRegSaveVO, PmOtherExpensesRegUpdateVO, PmOtherExpensesRegPageQuery, PmOtherExpensesRegResultVO> {

}
