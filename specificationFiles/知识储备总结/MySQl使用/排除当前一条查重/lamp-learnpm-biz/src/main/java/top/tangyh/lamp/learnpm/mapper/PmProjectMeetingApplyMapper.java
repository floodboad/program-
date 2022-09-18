package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;

/**
 * <p>
 * 项目会议申请Mapper 接口
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmProjectMeetingApplyMapper extends SuperMapper<PmProjectMeetingApply> {

    Integer getPmProjctId(@Param(value = "id") Long id, @Param(value =" phone") String phone);

    Integer getByPmProjectMeetingPlanningid(Long id);
}
