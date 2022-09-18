package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import top.tangyh.lamp.learnpm.mapper.PmApprovalProcessConfigMapper;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessConfig;
import top.tangyh.lamp.learnpm.manager.PmApprovalProcessConfigManager;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * <p>
 * 审批流配置Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmApprovalProcessConfigManagerImpl extends SuperManagerImpl<PmApprovalProcessConfigMapper, PmApprovalProcessConfig> implements PmApprovalProcessConfigManager {
    @Autowired
    private PmApprovalProcessConfigMapper processConfigMapper;

    @Override
    public ArrayList<String> getAllProcessConfigName() {
        return processConfigMapper.getAllProcessConfigName();
    }

    @Override
    public ArrayList<String> getExcludeCurrentEntry(String processName, long processAprovalId) {
        return processConfigMapper.getExcludeCurrentEntry(processName,processAprovalId);
    }

    @Override
    public PmProcessPhaseConf getFirstProcessPhaseConf(Integer linkSequence, String processName) {
        return processConfigMapper.getFirstProcessPhaseConf(linkSequence,processName);
    }

    @Override
    public String getViewNameByNodeCode(String nodeCoding) {
        return processConfigMapper.getViewNameByNodeCode(nodeCoding);
    }


}
