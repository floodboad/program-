package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmCompanyFinance;

/**
 * <p>
 * 公司财务人员Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmCompanyFinanceMapper extends SuperMapper<PmCompanyFinance> {

}
