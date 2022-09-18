package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsProjectTypeSettings;

/**
 * <p>
 * 项目类型设置Mapper 接口
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsProjectTypeSettingsMapper extends SuperMapper<MsProjectTypeSettings> {

}
