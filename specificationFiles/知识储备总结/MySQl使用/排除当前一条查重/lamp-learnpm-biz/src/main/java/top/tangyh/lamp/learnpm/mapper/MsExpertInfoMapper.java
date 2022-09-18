package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsExpertInfo;

/**
 * <p>
 * 专家信息Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsExpertInfoMapper extends SuperMapper<MsExpertInfo> {

}
