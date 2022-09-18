package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsFirstLevelSubject;

/**
 * <p>
 * 一级科目维护Mapper 接口
 * </p>
 *
 * @author zyq
 * @date 2022-06-16
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsFirstLevelSubjectMapper extends SuperMapper<MsFirstLevelSubject> {

}
