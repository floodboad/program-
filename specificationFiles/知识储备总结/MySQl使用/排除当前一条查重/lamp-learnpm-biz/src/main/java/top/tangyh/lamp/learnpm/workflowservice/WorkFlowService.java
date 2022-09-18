package top.tangyh.lamp.learnpm.workflowservice;

import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;

import top.tangyh.lamp.learnpm.vo.result.PmProcessPhaseInstanceResultVO;

import top.tangyh.lamp.workflow.vo.AuditVO;
import top.tangyh.lamp.workflow.vo.SearchToDoVO;
import top.tangyh.lamp.workflow.vo.StartVO;

import java.util.List;

/**
 * <p>
 * 工作流服务接口
 *
 * </p>
 *
 * @author longsebo
 * @date 2022-06-21
 */
public interface WorkFlowService {
    /**
     * 根据流程定义，创建工作流实例
     * @param startVO 启动流程信息
     * @return 返回工作流实例ID
     */
    long startFlow(StartVO startVO) throws Exception;

    /**
     * 审核通过
     * @param auditVO
     * @return 当前流程环节实例ID(新创建的)，如果是最后一个节点，返回0
     */
    long auditPass(AuditVO auditVO) throws Exception;
    /**
     * 审核不通过
     * @param auditVO
     * @return 当前流程环节实例ID(新创建的)
     */
    long auditNoPass(AuditVO auditVO) throws Exception;
    /**
     * 查询审批列表接口
     * @param approvalProcessInstallId
     * @return 返回当前工作流实例的审批列表
     */
    List<PmProcessPhaseInstance> getAuditList(long approvalProcessInstallId);

    /**
     * 获取角色对应待办人列表
     * @param vo
     * @return
     */
    String getToDoList(SearchToDoVO vo) throws Exception;
}
