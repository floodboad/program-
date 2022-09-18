package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsContactInfo;

/**
 * <p>
 * 联系人信息Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsContactInfoMapper extends SuperMapper<MsContactInfo> {

}
