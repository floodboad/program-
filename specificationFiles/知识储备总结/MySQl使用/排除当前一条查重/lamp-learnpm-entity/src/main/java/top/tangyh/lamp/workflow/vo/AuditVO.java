package top.tangyh.lamp.workflow.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 审核vo(含通过，不通过)
 *
 **/
@Data
@NoArgsConstructor
public class AuditVO {
    /**
     * 审批流实例ID
     */
    private Long   pmApprovalProcessInstanceId;
    /**
     * 审批人id
     */
    private Long   approverId;
    /**
     * 审批人名称
     */
    private String   approverName;
    /**
     * 审批意见
     */
    private String   approvalComments;
    /**
     * 是否同意
     */
    private String   agreest;
    /**
     * 待办人列表，JSON格式
     */
    private String toDoId;
    /**
     * 业务ID
     */
    private Long businessId;
    /**
     * 查看详情链接
     */
    private String detailLink;
}
