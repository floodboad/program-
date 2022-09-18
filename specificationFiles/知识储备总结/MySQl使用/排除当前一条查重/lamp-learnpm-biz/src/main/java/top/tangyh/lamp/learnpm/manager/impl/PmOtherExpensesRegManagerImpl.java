package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmOtherExpensesRegMapper;
import top.tangyh.lamp.learnpm.entity.PmOtherExpensesReg;
import top.tangyh.lamp.learnpm.manager.PmOtherExpensesRegManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议执行费用支付录入Manager
 * </p>
 *
 * @author dz
 * @date 2022-07-04
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmOtherExpensesRegManagerImpl extends SuperManagerImpl<PmOtherExpensesRegMapper, PmOtherExpensesReg> implements PmOtherExpensesRegManager {

}
