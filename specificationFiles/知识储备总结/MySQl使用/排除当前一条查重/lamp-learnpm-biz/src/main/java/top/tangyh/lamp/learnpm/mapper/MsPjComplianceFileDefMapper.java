package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsPjComplianceFileDef;

/**
 * <p>
 * 项目合规文件定义Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-07-06
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsPjComplianceFileDefMapper extends SuperMapper<MsPjComplianceFileDef> {

}
