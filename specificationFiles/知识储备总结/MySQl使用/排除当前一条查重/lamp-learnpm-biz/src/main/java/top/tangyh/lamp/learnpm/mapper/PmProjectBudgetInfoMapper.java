package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmProjectBudgetInfo;

/**
 * <p>
 * 项目预算信息Mapper 接口
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmProjectBudgetInfoMapper extends SuperMapper<PmProjectBudgetInfo> {

}
