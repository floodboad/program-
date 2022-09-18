package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmProjectBudgetInfoMapper;
import top.tangyh.lamp.learnpm.entity.PmProjectBudgetInfo;
import top.tangyh.lamp.learnpm.manager.PmProjectBudgetInfoManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目预算信息Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProjectBudgetInfoManagerImpl extends SuperManagerImpl<PmProjectBudgetInfoMapper, PmProjectBudgetInfo> implements PmProjectBudgetInfoManager {

}
