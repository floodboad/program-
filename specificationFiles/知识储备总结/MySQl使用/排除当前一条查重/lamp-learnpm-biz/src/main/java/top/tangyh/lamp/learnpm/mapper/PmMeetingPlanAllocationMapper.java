package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanAllocation;

import java.util.List;

/**
 * <p>
 * 会议规划分配Mapper 接口
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmMeetingPlanAllocationMapper extends SuperMapper<PmMeetingPlanAllocation> {



    List<PmMeetingPlanAllocation> queryId( Long pmProjectMeetingPlanningId);

    

}
