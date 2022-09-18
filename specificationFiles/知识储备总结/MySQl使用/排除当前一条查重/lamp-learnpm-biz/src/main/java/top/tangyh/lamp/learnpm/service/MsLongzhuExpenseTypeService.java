package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsLongzhuExpenseType;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsLongzhuExpenseType;
import top.tangyh.lamp.learnpm.vo.query.MsLongzhuExpenseTypePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsLongzhuExpenseTypeResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsLongzhuExpenseTypeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsLongzhuExpenseTypeUpdateVO;
/**
 * <p>
 * 七龙珠费用类型设置业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
public interface MsLongzhuExpenseTypeService extends SuperService<Long, MsLongzhuExpenseType, MsLongzhuExpenseTypeSaveVO, MsLongzhuExpenseTypeUpdateVO, MsLongzhuExpenseTypePageQuery, MsLongzhuExpenseTypeResultVO> {

}
