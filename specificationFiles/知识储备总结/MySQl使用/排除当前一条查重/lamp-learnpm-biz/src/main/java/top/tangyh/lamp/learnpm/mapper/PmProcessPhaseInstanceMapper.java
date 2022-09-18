package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;

/**
 * <p>
 * 流程环节实例Mapper 接口
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmProcessPhaseInstanceMapper extends SuperMapper<PmProcessPhaseInstance> {

    // 用流程环节实例表和流程环节配置表来关联查询一条记录
    PmProcessPhaseInstance getProcessConfigInstanceById(Long ProcessConfigId,Integer flagApplyNum);
}
