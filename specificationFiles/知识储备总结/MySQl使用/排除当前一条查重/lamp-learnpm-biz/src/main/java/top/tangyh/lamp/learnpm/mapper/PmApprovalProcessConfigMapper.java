package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessConfig;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;

import java.util.ArrayList;

/**
 * <p>
 * 审批流配置Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmApprovalProcessConfigMapper extends SuperMapper<PmApprovalProcessConfig> {
    // 获取所有的流程名称
    ArrayList<String> getAllProcessConfigName();

    // 获取排除当前一条的其他所有流程名称
    ArrayList<String> getExcludeCurrentEntry(String processName,long processAprovalId);

    // getFirstProcessPhaseConf
    PmProcessPhaseConf getFirstProcessPhaseConf(Integer linkSequence, String processName);

    // getViewNameByNodeCode
    String getViewNameByNodeCode(String nodeCoding);
}
