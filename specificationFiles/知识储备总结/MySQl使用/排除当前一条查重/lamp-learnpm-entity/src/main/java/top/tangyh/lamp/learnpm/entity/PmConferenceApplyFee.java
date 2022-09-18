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


/**
 * <p>
 * 会议申请费用表实体类
 * </p>
 *
 * @author dz
 * @date 2022-07-05
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_CONFERENCE_APPLY_FEE")
@AllArgsConstructor
@Builder
public class PmConferenceApplyFee extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议申请id 
     */
     @TableField(value = "PM_PROJECT_MEETING_APPLY_ID ", condition = LIKE)
    private Long pmProjectMeetingApplyId;
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
     * 项目会议规划id 
     */
     @TableField(value = "PM_PROJECT_MEETING_PLANNING_ID ", condition = LIKE)
    private Long pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称 
     */
     @TableField(value = "PROJECT_MEETING_PLANNING_NAME ", condition = LIKE)
    private String projectMeetingPlanningName;
    /**
     * 费用id 
     */
     @TableField(value = "MS_BUDGET_SUBJECT_ID ", condition = LIKE)
    private Long msBudgetSubjectId;
    /**
     * 费用名称 
     */
     @TableField(value = "FEE_NAME ", condition = LIKE)
    private String feeName;
    /**
     * 费用执行标准 
     */
     @TableField(value = "CONTROL_STANDARDS ", condition = LIKE)
    private String controlStandards;
    /**
     * 数量 
     */
     @TableField(value = "NUM ", condition = LIKE)
    private Integer num;
    /**
     * 金额 
     */
     @TableField(value = "AMOUNT_MONEY ", condition = LIKE)
    private BigDecimal amountMoney;
    /**
     * 说明 
     */
     @TableField(value = "ILLUSTRATE ", condition = LIKE)
    private String illustrate;
    /**
     * 系统已执行金额 
     */
     @TableField(value = "FEE_EXECUTED_AMOUNT ", condition = LIKE)
    private BigDecimal feeExecutedAmount;
    /**
     * 线下预算金额 
     */
     @TableField(value = "OFFLINE_BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal offlineBudgetAmount;
    /**
     * 线下已执行金额 
     */
     @TableField(value = "OTHER_EXECUTION_AMOUNT ", condition = LIKE)
    private BigDecimal otherExecutionAmount;
    /**
     * 预支付金额 
     */
     @TableField(value = "CONSUMED_AMOUNT ", condition = LIKE)
    private BigDecimal consumedAmount;
    /**
     * 系统预算金额 
     */
     @TableField(value = "SYSTEM_BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal systemBudgetAmount;
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
