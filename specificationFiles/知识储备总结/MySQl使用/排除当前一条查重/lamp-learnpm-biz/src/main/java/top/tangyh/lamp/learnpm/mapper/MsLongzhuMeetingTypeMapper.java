package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsLongzhuMeetingType;

/**
 * <p>
 * 会议类型七龙珠配置Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsLongzhuMeetingTypeMapper extends SuperMapper<MsLongzhuMeetingType> {

}
