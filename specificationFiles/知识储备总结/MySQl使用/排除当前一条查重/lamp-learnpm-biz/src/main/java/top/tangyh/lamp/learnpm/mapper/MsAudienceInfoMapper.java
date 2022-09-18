package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;

/**
 * <p>
 * 听众信息表Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsAudienceInfoMapper extends SuperMapper<MsAudienceInfo> {

    //数据库校验手机号
    MsAudienceInfo selectPhone(String phone);
}
