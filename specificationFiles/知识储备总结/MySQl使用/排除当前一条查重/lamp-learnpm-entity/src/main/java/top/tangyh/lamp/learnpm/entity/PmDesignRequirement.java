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
import java.util.Date;
import java.math.BigDecimal;



/**
 * <p>
 * 设计要求实体类
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
@TableName("PM_DESIGN_REQUIREMENT")
@AllArgsConstructor
@Builder
public class PmDesignRequirement extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议申请id 
     */
     @TableField(value = "PM_PROJECT_MEETING_APPLY_ID ", condition = LIKE)
    private Long pmProjectMeetingApplyId;
    /**
     * 会议名称 
     */
     @TableField(value = "MEETING_NAME ", condition = LIKE)
    private String meetingName;
    /**
     * 项目id 
     */
     @TableField(value = "PM_PROJECT_ID ", condition = LIKE)
    private Long pmProjectId;
    /**
     * 项目名称 
     */
     @TableField(value = "PROJECT_NAME ", condition = LIKE)
    private String projectName;
    /**
     * 设计要求说明 
     */
     @TableField(value = "DESIGN_REQ_DESCRIPTION ", condition = LIKE)
    private String designReqDescription;
    /**
     * 设计资料附件 
     */
     @TableField(value = "DESIGN_DATA_ATTACHMENT ", condition = LIKE)
    private String designDataAttachment;
    /**
     * 设计成果附件 
     */
     @TableField(value = "DESIGN_RESULT_ATTACHMENT ", condition = LIKE)
    private String designResultAttachment;
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
     * 实际设计费用 
     */
     @TableField(value = "ACTUAL_DESIGN_COST ", condition = LIKE)
    private BigDecimal actualDesignCost;
    /**
     * 设计费用结余 
     */
     @TableField(value = "DESIGN_COST_BALANCE ", condition = LIKE)
    private BigDecimal designCostBalance;
    /**
     * 执行前预算金额 
     */
     @TableField(value = "BEFORE_EXE_BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal beforeExeBudgetAmount;
    /**
     * 预算金额 
     */
     @TableField(value = "BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal budgetAmount;
    /**
     * 状态 
     */
     @TableField(value = "STATUS ", condition = LIKE)
    private String status;
    /**
     * 申请金额 
     */
     @TableField(value = "APPLICATION_AMOUNT ", condition = LIKE)
    private BigDecimal applicationAmount;
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
     * 制作人id 
     */
     @TableField(value = "PRODUCER_ID ", condition = LIKE)
    private Long producerId;
    /**
     * 制作人手机号 
     */
     @TableField(value = "PRODUCER_PHONE ", condition = LIKE)
    private String producerPhone;
    /**
     * 制作人姓名 
     */
     @TableField(value = "PRODUCER ", condition = LIKE)
    private String producer;
    /**
     * 申请时间 
     */
     @TableField(value = "APPLICATION_TIME ", condition = LIKE)
    private Date applicationTime;
    /**
     * 审核时间 
     */
     @TableField(value = "AUDIT_TIME ", condition = LIKE)
    private Date auditTime;
    /**
     * 制作时间 
     */
     @TableField(value = "PRODUCER_TIME ", condition = LIKE)
    private Date producerTime;
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
