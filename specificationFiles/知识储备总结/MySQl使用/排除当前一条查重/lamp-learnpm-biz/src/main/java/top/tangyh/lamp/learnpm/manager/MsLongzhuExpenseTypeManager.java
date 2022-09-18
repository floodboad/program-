package top.tangyh.lamp.learnpm.manager;

import top.tangyh.basic.base.manager.SuperManager;
import top.tangyh.lamp.learnpm.entity.MsLongzhuExpenseType;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 七龙珠费用类型设置业务层
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
public interface MsLongzhuExpenseTypeManager extends SuperManager<MsLongzhuExpenseType> {

    // 获取所有FEE_NAME的数据
    ArrayList<String> returnFeeNameList();

}
