package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsExpenseTaskOperation;

/**
 * <p>
 * 费用任务操作Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-14
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsExpenseTaskOperationMapper extends SuperMapper<MsExpenseTaskOperation> {

}
