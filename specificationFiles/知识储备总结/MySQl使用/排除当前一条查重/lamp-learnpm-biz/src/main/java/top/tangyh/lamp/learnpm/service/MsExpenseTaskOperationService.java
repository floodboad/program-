package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsExpenseTaskOperation;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsExpenseTaskOperation;
import top.tangyh.lamp.learnpm.vo.query.MsExpenseTaskOperationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExpenseTaskOperationResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExpenseTaskOperationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExpenseTaskOperationUpdateVO;
/**
 * <p>
 * 费用任务操作业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-14
 */
public interface MsExpenseTaskOperationService extends SuperService<Long, MsExpenseTaskOperation, MsExpenseTaskOperationSaveVO, MsExpenseTaskOperationUpdateVO, MsExpenseTaskOperationPageQuery, MsExpenseTaskOperationResultVO> {

}
