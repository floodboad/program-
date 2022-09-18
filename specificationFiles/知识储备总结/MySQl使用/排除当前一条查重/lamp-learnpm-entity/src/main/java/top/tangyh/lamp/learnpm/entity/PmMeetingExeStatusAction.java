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
 * 会议执行状态操作表实体类
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_MEETING_EXE_STATUS_ACTION")
@AllArgsConstructor
@Builder
public class PmMeetingExeStatusAction extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 执行类型 
     */
     @TableField(value = "EXECUTION_TYPE ", condition = LIKE)
    private String executionType;
    /**
     * 申请人id 
     */
     @TableField(value = "APPLICANT_ID ", condition = LIKE)
    private Long applicantId;
    /**
     * 申请人 
     */
     @TableField(value = "APPLICANT ", condition = LIKE)
    private String applicant;
    /**
     * 申请人手机号 
     */
     @TableField(value = "APPLICANT_PHONE ", condition = LIKE)
    private String applicantPhone;
    /**
     * 审批人id 
     */
     @TableField(value = "APPROVER_ID ", condition = LIKE)
    private Long approverId;
    /**
     * 审批人 
     */
     @TableField(value = "APPROVER ", condition = LIKE)
    private String approver;
    /**
     * 审批人手机号 
     */
     @TableField(value = "APPROVER_PHONE ", condition = LIKE)
    private String approverPhone;
    /**
     * 执行公司id 
     */
     @TableField(value = "EXECUTION_COMPANY_ID ", condition = LIKE)
    private Long executionCompanyId;
    /**
     * 执行人id 
     */
     @TableField(value = "EXECUTOR_ID ", condition = LIKE)
    private Long executorId;
    /**
     * 执行人手机号 
     */
     @TableField(value = "EXECUTOR_PHONE ", condition = LIKE)
    private String executorPhone;
    /**
     * 执行人 
     */
     @TableField(value = "EXECUTOR ", condition = LIKE)
    private String executor;
    /**
     * 审批意见 
     */
     @TableField(value = "APPROVAL_COMMENTS ", condition = LIKE)
    private String approvalComments;
    /**
     * 审批状态 
     */
     @TableField(value = "AUDIT_STATUS ", condition = LIKE)
    private String auditStatus;
    /**
     * 会议执行要求id 
     */
     @TableField(value = "PM_MEETING_EXECUTION_REQ_ID ", condition = LIKE)
    private Long pmMeetingExecutionReqId;
    /**
     * 流程环节实例ID 
     */
     @TableField(value = "MS_PROCESS_PHASE_INSTANCE_ID ", condition = LIKE)
    private Long msProcessPhaseInstanceId;
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
