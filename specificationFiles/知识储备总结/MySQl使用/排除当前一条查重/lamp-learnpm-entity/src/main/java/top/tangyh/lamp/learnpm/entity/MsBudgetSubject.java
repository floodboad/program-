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
 * 预算科目实体类
 * </p>
 *
 * @author zyq
 * @date 2022-06-16
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("MS_BUDGET_SUBJECT")
@AllArgsConstructor
@Builder
public class MsBudgetSubject extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 科目类型 
     */
     @TableField(value = "SUBJECT_TYPE ", condition = LIKE)
    private String subjectType;
    /**
     * 科目编码 
     */
     @TableField(value = "SUBJECT_CODE ", condition = LIKE)
    private String subjectCode;
    /**
     * 科目状态 
     */
     @TableField(value = "SUBJECT_STATUS ", condition = LIKE)
    private String subjectStatus;
    /**
     * 一级科目id 
     */
     @TableField(value = "MS_FIRST_LEVEL_SUBJECT_ID ", condition = LIKE)
    private Long msFirstLevelSubjectId;
    /**
     * 一级科目名称 
     */
     @TableField(value = "FIRST_SUBJECT_NAME ", condition = LIKE)
    private String firstSubjectName;
    /**
     * 二级科目id 
     */
     @TableField(value = "MS_SECONDARY_SUBJECT_ID ", condition = LIKE)
    private Long msSecondarySubjectId;
    /**
     * 二级科目名称 
     */
     @TableField(value = "SECONDARY_SUBJECT_NAME ", condition = LIKE)
    private String secondarySubjectName;
    /**
     * 对外报价 
     */
     @TableField(value = "EXTERNAL_QUOTATION ", condition = LIKE)
    private BigDecimal externalQuotation;
    /**
     * 成本价 
     */
     @TableField(value = "COST_PRICE ", condition = LIKE)
    private BigDecimal costPrice;
    /**
     * 会议方式 
     */
     @TableField(value = "MEETING_TYPE ", condition = LIKE)
    private String meetingType;
    /**
     * 科目名称 
     */
     @TableField(value = "SUBJECT_NAME ", condition = LIKE)
    private String subjectName;
    /**
     * 科目描述 
     */
     @TableField(value = "SUBJECT_DESC ", condition = LIKE)
    private String subjectDesc;
    /**
     * 单位1 
     */
     @TableField(value = "UNIT1 ", condition = LIKE)
    private String unit1;
    /**
     * 单位2 
     */
     @TableField(value = "UNIT2 ", condition = LIKE)
    private String unit2;
    /**
     * 是否执行费用 
     */
     @TableField(value = "IS_IMPLEMENT_EXPENSES ", condition = LIKE)
    private String isImplementExpenses;
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
