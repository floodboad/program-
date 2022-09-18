package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmExpertReplaceRecord;

/**
 * <p>
 * 专家更换记录Mapper 接口
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmExpertReplaceRecordMapper extends SuperMapper<PmExpertReplaceRecord> {

}
