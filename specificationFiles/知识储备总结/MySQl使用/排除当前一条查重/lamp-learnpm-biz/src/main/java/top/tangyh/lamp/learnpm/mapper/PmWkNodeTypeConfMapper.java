package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmWkNodeTypeConf;

/**
 * <p>
 * 工作流节点类型配置Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmWkNodeTypeConfMapper extends SuperMapper<PmWkNodeTypeConf> {

}
