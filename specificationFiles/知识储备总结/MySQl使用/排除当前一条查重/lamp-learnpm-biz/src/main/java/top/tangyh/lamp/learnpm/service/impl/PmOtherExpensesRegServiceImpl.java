package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmOtherExpensesReg;
import top.tangyh.lamp.learnpm.manager.PmOtherExpensesRegManager;
import top.tangyh.lamp.learnpm.service.PmOtherExpensesRegService;
import top.tangyh.lamp.learnpm.vo.query.PmOtherExpensesRegPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOtherExpensesRegResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOtherExpensesRegSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOtherExpensesRegUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 会议执行费用支付录入业务实现类
 * 
 * </p>
 *
 * @author dz
 * @date 2022-07-04
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmOtherExpensesRegServiceImpl extends SuperServiceImpl<PmOtherExpensesRegManager, Long, PmOtherExpensesReg, PmOtherExpensesRegSaveVO, PmOtherExpensesRegUpdateVO, PmOtherExpensesRegPageQuery, PmOtherExpensesRegResultVO>
        implements PmOtherExpensesRegService {
    
}
