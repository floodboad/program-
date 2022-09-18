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
import java.math.BigDecimal;
import java.util.Date;



/**
 * <p>
 * 物料制作实体类
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
@TableName("PM_MATERIAL_PRODUCTION")
@AllArgsConstructor
@Builder
public class PmMaterialProduction extends Entity<Long> {

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
     * 物料制作要求 
     */
     @TableField(value = "MATERIAL_FABRICATION_REQ ", condition = LIKE)
    private String materialFabricationReq;
    /**
     * 物料制作附件 
     */
     @TableField(value = "MATERIAL_MANUFACTURING_ATTACHMENT ", condition = LIKE)
    private String materialManufacturingAttachment;
    /**
     * 状态 
     */
     @TableField(value = "STATUS ", condition = LIKE)
    private String status;
    /**
     * 发起人id 
     */
     @TableField(value = "INITIATOR_ID ", condition = LIKE)
    private Long initiatorId;
    /**
     * 发起人手机号 
     */
     @TableField(value = "INITIATOR_PHONE ", condition = LIKE)
    private String initiatorPhone;
    /**
     * 发起人 
     */
     @TableField(value = "INITIATOR ", condition = LIKE)
    private String initiator;
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
     * 发起时间 
     */
     @TableField(value = "INITIATOR_TIME ", condition = LIKE)
    private Date initiatorTime;
    /**
     * 审核时间 
     */
     @TableField(value = "AUDIT_TIME ", condition = LIKE)
    private Date auditTime;
    /**
     * 制作确认时间 
     */
     @TableField(value = "PRODUCTION_CONFIRMATION_TIME ", condition = LIKE)
    private Date productionConfirmationTime;
    /**
     * 制作费用 
     */
     @TableField(value = "PRODUCTION_COST ", condition = LIKE)
    private BigDecimal productionCost;
    /**
     * 制作审批费用 
     */
     @TableField(value = "PRODUCTION_APPROVAL_FEE ", condition = LIKE)
    private BigDecimal productionApprovalFee;
    /**
     * 预算金额 
     */
     @TableField(value = "BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal budgetAmount;
    /**
     * 执行后金额 
     */
     @TableField(value = "AFTER_EXECUTION_AMOUNT ", condition = LIKE)
    private BigDecimal afterExecutionAmount;
    /**
     * 已执行金额 
     */
     @TableField(value = "EXECUTED_AMOUNT ", condition = LIKE)
    private BigDecimal executedAmount;
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
