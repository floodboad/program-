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
 * 项目预算信息实体类
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_PROJECT_BUDGET_INFO")
@AllArgsConstructor
@Builder
public class PmProjectBudgetInfo extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id 
     */
     @TableField(value = "PM_PROJECT_ID ", condition = LIKE)
    private Long pmProjectId;
    /**
     * 预算科目id 
     */
     @TableField(value = "MS_BUDGET_SUBJECT_ID ", condition = LIKE)
    private Long msBudgetSubjectId;
    /**
     * 预算科目名称 
     */
     @TableField(value = "SUBJECT_NAME ", condition = LIKE)
    private String subjectName;
    /**
     * 对外报价 
     */
     @TableField(value = "EXTERNAL_QUOTATION ", condition = LIKE)
    private BigDecimal externalQuotation;
    /**
     * 单价 
     */
     @TableField(value = "PRICE ", condition = LIKE)
    private BigDecimal price;
    /**
     * 数量 
     */
     @TableField(value = "NUM ", condition = LIKE)
    private Integer num;
    /**
     * 场次 
     */
     @TableField(value = "TIMES ", condition = LIKE)
    private Integer times;
    /**
     * 预算金额 
     */
     @TableField(value = "BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal budgetAmount;
    /**
     * 预算类型 
     */
     @TableField(value = "BUDGET_TYPE ", condition = LIKE)
    private String budgetType;
    /**
     * 变更金额 
     */
     @TableField(value = "CHANGE_AMOUNT ", condition = LIKE)
    private BigDecimal changeAmount;
    /**
     * 调整后金额 
     */
     @TableField(value = "ADJUSTED_AMOUNT ", condition = LIKE)
    private BigDecimal adjustedAmount;
    /**
     * 实际规划金额 
     */
     @TableField(value = "ACTUAL_PLANNED_AMOUNT ", condition = LIKE)
    private BigDecimal actualPlannedAmount;
    /**
     * 实际支出金额 
     */
     @TableField(value = "ACTUAL_EXPENDITURE_AMOUNT ", condition = LIKE)
    private BigDecimal actualExpenditureAmount;
    /**
     * 剩余金额 
     */
     @TableField(value = "REMAINING_AMOUNT ", condition = LIKE)
    private BigDecimal remainingAmount;
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
