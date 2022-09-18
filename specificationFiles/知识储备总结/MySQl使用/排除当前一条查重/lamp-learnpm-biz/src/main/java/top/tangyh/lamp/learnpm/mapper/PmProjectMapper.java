package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmProject;

import java.util.List;

/**
 * <p>
 * 项目信息Mapper 接口
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmProjectMapper extends SuperMapper<PmProject> {

    List<PmProject> getInitiator( Long initiatorId);


}
