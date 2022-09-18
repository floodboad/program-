package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterials;

/**
 * <p>
 * 项目合规材料Mapper 接口
 * </p>
 *
 * @author liyy
 * @date 2022-06-28
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmComplianceMaterialsMapper extends SuperMapper<PmComplianceMaterials> {

}
