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
 * 项目规划调整记录实体类
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_PROJECT_PLAN_ADJUST_RECORD")
@AllArgsConstructor
@Builder
public class PmProjectPlanAdjustRecord extends Entity<Long> {

    private static final long serialVersionUID = 1L;

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
     * 项目号 
     */
     @TableField(value = "PROJECT_CODE ", condition = LIKE)
    private String projectCode;
    /**
     * 原会议预算已占用金额 
     */
     @TableField(value = "ORIGINAL_MEETING_BUDGET_AMT ", condition = LIKE)
    private BigDecimal originalMeetingBudgetAmt;
    /**
     * 原会议计划场次 
     */
     @TableField(value = "ORIGINAL_MEETING_PLANNED_NUM ", condition = LIKE)
    private String originalMeetingPlannedNum;
    /**
     * 原剩余预算金额 
     */
     @TableField(value = "ORIGINAL_REMAIN_BUDGET_AMT ", condition = LIKE)
    private BigDecimal originalRemainBudgetAmt;
    /**
     * 调整会议占用金额 
     */
     @TableField(value = "ADJUST_MEETING_OCCUPIED_AMT ", condition = LIKE)
    private BigDecimal adjustMeetingOccupiedAmt;
    /**
     * 调整会议场次 
     */
     @TableField(value = "ADJUST_MEETING_NUMBER ", condition = LIKE)
    private String adjustMeetingNumber;
    /**
     * 调整后会议计划场次 
     */
     @TableField(value = "AFTER_ADJUSTMENT_MEETING_NUMBER ", condition = LIKE)
    private String afterAdjustmentMeetingNumber;
    /**
     * 调整后会议预算占用金额 
     */
     @TableField(value = "ADJUSTED_MEETING_OCCUPIED_AMT ", condition = LIKE)
    private String adjustedMeetingOccupiedAmt;
    /**
     * 调整后剩余预算金额 
     */
     @TableField(value = "ADJUSTED_REMAINING_BUDGET_AMT ", condition = LIKE)
    private BigDecimal adjustedRemainingBudgetAmt;
    /**
     * 状态 
     */
     @TableField(value = "STATUS ", condition = LIKE)
    private String status;
    /**
     * 备注 
     */
     @TableField(value = "REMARK ", condition = LIKE)
    private String remark;
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
