package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;
import top.tangyh.lamp.learnpm.vo.query.PmApprovalProcessInstancePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmApprovalProcessInstanceResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmApprovalProcessInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmApprovalProcessInstanceUpdateVO;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 审批流实例业务接口
 * 
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
public interface PmApprovalProcessInstanceService extends SuperService<Long, PmApprovalProcessInstance, PmApprovalProcessInstanceSaveVO, PmApprovalProcessInstanceUpdateVO, PmApprovalProcessInstancePageQuery, PmApprovalProcessInstanceResultVO> {

    // 查代办人列表
    List<PmApprovalProcessInstance> backlogDataVolumeList(String userId);

    // 待办json列表
    List<String> jsonToDoList(String userId,Integer flagApplyNum );

    // 判断通过查这个ProcessConfigId这一条记录，获取申请人的名字和申请时间是否为空
}

