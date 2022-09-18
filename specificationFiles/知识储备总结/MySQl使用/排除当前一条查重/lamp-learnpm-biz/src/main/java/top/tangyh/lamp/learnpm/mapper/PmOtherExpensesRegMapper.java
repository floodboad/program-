package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmOtherExpensesReg;

/**
 * <p>
 * 会议执行费用支付录入Mapper 接口
 * </p>
 *
 * @author dz
 * @date 2022-07-04
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmOtherExpensesRegMapper extends SuperMapper<PmOtherExpensesReg> {

}
