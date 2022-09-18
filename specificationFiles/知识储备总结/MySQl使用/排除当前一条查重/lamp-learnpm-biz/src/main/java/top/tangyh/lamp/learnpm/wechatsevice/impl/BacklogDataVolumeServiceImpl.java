package top.tangyh.lamp.learnpm.wechatsevice.impl;/**
 * @author xuchunlong
 * @create 2022-06-21-13:09
 */

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;
import top.tangyh.lamp.learnpm.manager.PmApprovalProcessInstanceManager;
import top.tangyh.lamp.learnpm.mapper.PmApprovalProcessInstanceMapper;
import top.tangyh.lamp.learnpm.wechatsevice.BacklogDataVolumeService;

import java.util.List;

/**
 * @author: xucl
 * @create: 2022/6/21
 * @Description:
 * @FileName: BacklogDataVolumeServiceImpl
 * @History:
 * @自定义内容：
 */

@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BacklogDataVolumeServiceImpl implements BacklogDataVolumeService {

    @Autowired
    private PmApprovalProcessInstanceManager pmApprovalProcessInstanceManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PmApprovalProcessInstance> listBacklogDataVolume(String userId) {
        return pmApprovalProcessInstanceManager.getListRecordByAgent(userId);
    }

    @Override
    public List<PmApprovalProcessInstance> listBacklogDataVolumeByXML(String userId) {
        return pmApprovalProcessInstanceManager.listBacklogDataVolumeByXML(userId);
    }

    @Override
    public List<PmApprovalProcessInstance> listBacklogDataVolumePageByXML(String userId, Long current, Long size) {
        long start = (current-1)*size;
        return pmApprovalProcessInstanceManager.listBacklogDataVolumePageByXML(userId,start,size);
    }

}


