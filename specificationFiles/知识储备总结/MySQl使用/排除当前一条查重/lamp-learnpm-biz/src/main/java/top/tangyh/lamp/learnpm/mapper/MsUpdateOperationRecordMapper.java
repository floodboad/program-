package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsUpdateOperationRecord;

/**
 * <p>
 * 基础表更新操作记录Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsUpdateOperationRecordMapper extends SuperMapper<MsUpdateOperationRecord> {

}
