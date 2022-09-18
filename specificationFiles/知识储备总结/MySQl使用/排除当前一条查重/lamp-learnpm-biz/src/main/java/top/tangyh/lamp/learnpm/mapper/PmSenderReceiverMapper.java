package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmSenderReceiver;

/**
 * <p>
 * 收发件人Mapper 接口
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-09
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmSenderReceiverMapper extends SuperMapper<PmSenderReceiver> {

}
