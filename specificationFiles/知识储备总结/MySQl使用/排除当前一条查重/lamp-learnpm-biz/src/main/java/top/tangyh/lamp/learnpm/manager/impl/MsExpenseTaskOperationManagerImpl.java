package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsExpenseTaskOperationMapper;
import top.tangyh.lamp.learnpm.entity.MsExpenseTaskOperation;
import top.tangyh.lamp.learnpm.manager.MsExpenseTaskOperationManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 费用任务操作Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsExpenseTaskOperationManagerImpl extends SuperManagerImpl<MsExpenseTaskOperationMapper, MsExpenseTaskOperation> implements MsExpenseTaskOperationManager {

}
