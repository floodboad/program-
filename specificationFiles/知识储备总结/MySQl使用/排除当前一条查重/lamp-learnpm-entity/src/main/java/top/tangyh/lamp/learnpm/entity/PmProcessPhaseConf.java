package top.tangyh.lamp.learnpm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.Entity;
import top.tangyh.basic.utils.ValidatorUtil;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.EQUAL;
import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 流程环节配置实体类
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_PROCESS_PHASE_CONF")
@AllArgsConstructor
@Builder
public class PmProcessPhaseConf extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 流程id 
     */
     @TableField(value = "PM_APPROVAL_PROCESS_CONFIG_ID ", condition = EQUAL)
    private Long pmApprovalProcessConfigId;
    /**
     * 节点类型编码 
     */
     @TableField(value = "NODE_TYPE_CODE ", condition = EQUAL)
    private String nodeTypeCode;
    /**
     * 环节次序 
     */
     @TableField(value = "LINK_SEQUENCE ", condition = EQUAL)
    private Integer linkSequence;
    /**
     * 审批人类型 
     */
     @TableField(value = "APPROVER_TYPE ", condition = LIKE)
    private String approverType;
    /**
     * 审批人名称 
     */
     @TableField(value = "APPROVER_NAME ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.REGEX_CHINESE)
    private String approverName;
    /**
     * 审批人id 
     */
     @TableField(value = "APPROVER_ID ", condition = EQUAL)
    private Long approverId;
    /**
     * 是否允许转审 
     */
     @TableField(value = "IS_ALLOW_TRANSFER_APPROVAL ", condition = LIKE)
    private String isAllowTransferApproval;
    /**
     * 是否结束 
     */
     @TableField(value = "IS_END ", condition = EQUAL)
    private String isEnd;
    /**
     * 是否有效 
     */
     @TableField(value = "IS_VALID ", condition = EQUAL)
    private String isValid;
    /**
     * 角色编码 
     */
     @TableField(value = "ROLE_CODE ", condition = EQUAL)
    private String roleCode;
    /**
     * 审核不通过退回节点ID 
     */
     @TableField(value = "BACK_NODE_ID ", condition = EQUAL)
    private Long backNodeId;
    /**
     * 扩展字段1 
     */
     @TableField(value = "ATTRIBUTE1 ", condition = LIKE)
    private String attribute1;
    /**
     * 扩展字段2 
     */
     @TableField(value = "ATTRIBUTE2 ", condition = LIKE)
    private String attribute2;
    /**
     * 扩展字段3 
     */
     @TableField(value = "ATTRIBUTE3 ", condition = LIKE)
    private String attribute3;
    /**
     * 扩展字段4 
     */
     @TableField(value = "ATTRIBUTE4 ", condition = LIKE)
    private String attribute4;
    /**
     * 扩展字段5 
     */
     @TableField(value = "ATTRIBUTE5 ", condition = LIKE)
    private String attribute5;
    /**
     * 扩展字段6 
     */
     @TableField(value = "ATTRIBUTE6 ", condition = LIKE)
    private String attribute6;
    /**
     * 扩展字段7 
     */
     @TableField(value = "ATTRIBUTE7 ", condition = LIKE)
    private String attribute7;
    /**
     * 扩展字段8 
     */
     @TableField(value = "ATTRIBUTE8 ", condition = LIKE)
    private String attribute8;
    /**
     * 扩展字段9 
     */
     @TableField(value = "ATTRIBUTE9 ", condition = LIKE)
    private String attribute9;
    /**
     * 扩展字段10 
     */
     @TableField(value = "ATTRIBUTE10 ", condition = LIKE)
    private String attribute10;

}
