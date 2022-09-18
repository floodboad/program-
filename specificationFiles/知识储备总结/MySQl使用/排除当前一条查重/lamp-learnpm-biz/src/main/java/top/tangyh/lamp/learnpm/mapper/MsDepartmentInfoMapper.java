package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsDepartmentInfo;

/**
 * <p>
 * 科室信息Mapper 接口
 * </p>
 *
 * @author zyq
 * @date 2022-06-13
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsDepartmentInfoMapper extends SuperMapper<MsDepartmentInfo> {

}
