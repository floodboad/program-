package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReq;

/**
 * <p>
 * 会议执行要求Mapper 接口
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmMeetingExecutionReqMapper extends SuperMapper<PmMeetingExecutionReq> {

}
