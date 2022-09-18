package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsLongzhuExpenseType;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 七龙珠费用类型设置Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsLongzhuExpenseTypeMapper extends SuperMapper<MsLongzhuExpenseType> {

    // 获取所有FEE_NAME的数据
    ArrayList<String> returnFeeNameList();
}
