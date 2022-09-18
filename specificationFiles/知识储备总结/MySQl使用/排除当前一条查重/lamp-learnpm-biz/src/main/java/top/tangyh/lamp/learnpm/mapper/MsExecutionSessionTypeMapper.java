package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsExecutionSessionType;

/**
 * <p>
 * 执行场次类型Mapper 接口
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsExecutionSessionTypeMapper extends SuperMapper<MsExecutionSessionType> {

}
