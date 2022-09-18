package top.tangyh.lamp.learnpm.manager;

import top.tangyh.basic.base.manager.SuperManager;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessConfig;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;

import java.util.ArrayList;

/**
 * <p>
 * 审批流配置业务层
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
public interface PmApprovalProcessConfigManager extends SuperManager<PmApprovalProcessConfig> {
    // 获取Mysql库中的所有流程名称
    ArrayList<String> getAllProcessConfigName();

    // 获取排除当前一条的其他所有流程名称
    ArrayList<String> getExcludeCurrentEntry(String processName,long processAprovalId);

    // getFirstProcessPhaseConf
    PmProcessPhaseConf getFirstProcessPhaseConf(Integer linkSequence, String processName);

    // getViewNameByNodeCode
    String getViewNameByNodeCode(String nodeCoding);
}
