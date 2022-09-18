package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 审批流实例Mapper 接口
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmApprovalProcessInstanceMapper extends SuperMapper<PmApprovalProcessInstance> {

    // 写xml获取待办列表
    List<PmApprovalProcessInstance> listBacklogDataVolumeByXML(String userId);

    // 获取待办分页列表(使用xml）
    List<PmApprovalProcessInstance> listBacklogDataVolumePageByXML(String userId,long start,long size);
}
