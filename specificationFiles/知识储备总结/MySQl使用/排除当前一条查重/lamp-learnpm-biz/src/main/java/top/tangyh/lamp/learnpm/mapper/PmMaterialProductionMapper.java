package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmMaterialProduction;

/**
 * <p>
 * 物料制作Mapper 接口
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmMaterialProductionMapper extends SuperMapper<PmMaterialProduction> {

}
