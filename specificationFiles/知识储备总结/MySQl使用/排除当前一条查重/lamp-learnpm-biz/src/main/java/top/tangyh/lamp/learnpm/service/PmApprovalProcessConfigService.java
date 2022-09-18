package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessConfig;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessConfig;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import top.tangyh.lamp.learnpm.vo.query.PmApprovalProcessConfigPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmApprovalProcessConfigResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmApprovalProcessConfigSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmApprovalProcessConfigUpdateVO;
/**
 * <p>
 * 审批流配置业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
public interface PmApprovalProcessConfigService extends SuperService<Long, PmApprovalProcessConfig, PmApprovalProcessConfigSaveVO, PmApprovalProcessConfigUpdateVO, PmApprovalProcessConfigPageQuery, PmApprovalProcessConfigResultVO> {
    // 判断流程名称重复; true重复，false不重复.
    Boolean processNameRepeatOrNot(PmApprovalProcessConfigSaveVO pmApprovalProcessConfigSaveVO);

    // 流程名称相关（select count(*) from 流程定义表 where  process_name='xxxx' and id!='xxx';）
    Boolean processNameRepeatOrNot2(PmApprovalProcessConfigUpdateVO pmApprovalProcessConfigUpdateVO);

    // getFirstProcessPhaseConf
    String getFirstProcessPhaseConf(Integer linkSequence,String processName);
}
