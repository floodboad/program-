package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmCompanyFinanceMapper;
import top.tangyh.lamp.learnpm.entity.PmCompanyFinance;
import top.tangyh.lamp.learnpm.manager.PmCompanyFinanceManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 公司财务人员Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmCompanyFinanceManagerImpl extends SuperManagerImpl<PmCompanyFinanceMapper, PmCompanyFinance> implements PmCompanyFinanceManager {

}
