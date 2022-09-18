package top.tangyh.lamp.workflow.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询待办人列表
 */
@Data
@NoArgsConstructor
public class SearchToDoVO {
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 业务ID
     */
    private Long businessId;
    /**
     * 流程名称
     */
    private String processName;
    /**
     * 审批流实例ID
     */
    private long processInstanceId;
//    /**
//     * 角色编码
//     */
//    private String roleCode;
//    /**
//     * 节点类型编码
//     */
//    private String nodeTypeCode;
}
