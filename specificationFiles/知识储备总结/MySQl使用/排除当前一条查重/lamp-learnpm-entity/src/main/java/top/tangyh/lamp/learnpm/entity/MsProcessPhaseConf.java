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

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 流程环节配置实体类
 * </p>
 *
 * @author xucl
 * @date 2022-06-11
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("MS_PROCESS_PHASE_CONF")
@AllArgsConstructor
@Builder
public class MsProcessPhaseConf extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 流程id 
     */
     @TableField(value = "PM_APPROVAL_PROCESS_CONFIG_ID ", condition = LIKE)
    private Long pmApprovalProcessConfigId;
    /**
     * 环节次序 
     */
     @TableField(value = "LINK_SEQUENCE ", condition = LIKE)
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
    private String approverName;
    /**
     * 审批人id 
     */
     @TableField(value = "APPROVER_ID ", condition = LIKE)
    private Long approverId;
    /**
     * 是否允许转审 
     */
     @TableField(value = "IS_ALLOW_TRANSFER_APPROVAL ", condition = LIKE)
    private String isAllowTransferApproval;
    /**
     * 是否结束 
     */
     @TableField(value = "IS_END ", condition = LIKE)
    private String isEnd;
    /**
     * 是否有效 
     */
     @TableField(value = "IS_VALID ", condition = LIKE)
    private String isValid;
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
