package top.tangyh.lamp.learnpm.manager;

import top.tangyh.basic.base.manager.SuperManager;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 审批流实例业务层
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
public interface PmApprovalProcessInstanceManager extends SuperManager<PmApprovalProcessInstance> {

    // 获取指定代办人的记录
    List<PmApprovalProcessInstance> getListRecordByAgent(String userId);

    List<PmApprovalProcessInstance> listBacklogDataVolumeByXML(String userId);

    // 获取待办分页列表(使用xml）
    List<PmApprovalProcessInstance> listBacklogDataVolumePageByXML(String userId,long start,long size);

}
