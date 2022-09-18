package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsExpenseTaskOperation;
import top.tangyh.lamp.learnpm.manager.MsExpenseTaskOperationManager;
import top.tangyh.lamp.learnpm.service.MsExpenseTaskOperationService;
import top.tangyh.lamp.learnpm.vo.query.MsExpenseTaskOperationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExpenseTaskOperationResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExpenseTaskOperationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExpenseTaskOperationUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 费用任务操作业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-14
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsExpenseTaskOperationServiceImpl extends SuperServiceImpl<MsExpenseTaskOperationManager, Long, MsExpenseTaskOperation, MsExpenseTaskOperationSaveVO, MsExpenseTaskOperationUpdateVO, MsExpenseTaskOperationPageQuery, MsExpenseTaskOperationResultVO>
        implements MsExpenseTaskOperationService {
    
}
