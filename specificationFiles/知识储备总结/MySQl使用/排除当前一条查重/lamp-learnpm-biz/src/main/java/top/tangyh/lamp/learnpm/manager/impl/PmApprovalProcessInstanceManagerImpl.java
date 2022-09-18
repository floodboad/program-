package top.tangyh.lamp.learnpm.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.mapper.PmApprovalProcessInstanceMapper;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;
import top.tangyh.lamp.learnpm.manager.PmApprovalProcessInstanceManager;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 审批流实例Manager
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmApprovalProcessInstanceManagerImpl extends SuperManagerImpl<PmApprovalProcessInstanceMapper, PmApprovalProcessInstance> implements PmApprovalProcessInstanceManager {

    @Autowired
    private PmApprovalProcessInstanceMapper pmApprovalProcessInstanceMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PmApprovalProcessInstance> getListRecordByAgent(String userId) {
        QueryWrapper<PmApprovalProcessInstance> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("JSON_CONTAINS(TO_DO_ID,JSON_OBJECT('userId',{0}))", userId)
                    .eq("IS_END", "0");
        return pmApprovalProcessInstanceMapper.selectList(queryWrapper);
    }

    @Override
    public List<PmApprovalProcessInstance> listBacklogDataVolumeByXML(String userId) {
        return pmApprovalProcessInstanceMapper.listBacklogDataVolumeByXML(userId);
    }

    @Override
    public List<PmApprovalProcessInstance> listBacklogDataVolumePageByXML(String userId, long start, long size) {
        return pmApprovalProcessInstanceMapper.listBacklogDataVolumePageByXML(userId,start,size);
    }

}
