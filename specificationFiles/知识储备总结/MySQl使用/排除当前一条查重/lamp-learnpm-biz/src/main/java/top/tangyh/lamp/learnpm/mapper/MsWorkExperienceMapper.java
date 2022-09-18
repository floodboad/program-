package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsWorkExperience;

/**
 * <p>
 * 工作经历Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsWorkExperienceMapper extends SuperMapper<MsWorkExperience> {

}
