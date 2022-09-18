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

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 七龙珠费用类型设置实体类
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("MS_LONGZHU_EXPENSE_TYPE")
@AllArgsConstructor
@Builder
public class MsLongzhuExpenseType extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 费用名称 
     */
     @TableField(value = "FEE_NAME ", condition = LIKE)
     @NotEmpty(message = "费用名称不为空")
    private String feeName;
    /**
     * 控制标准 
     */
    @NotEmpty(message = "控制标准不为空")
    @TableField(value = "CONTROL_STANDARDS ", condition = LIKE)
    private String controlStandards;
    /**
     * 会议执行环节 
     */
    @NotEmpty(message = "会议执行环节")
    @TableField(value = "MEETING_EXECUTION_LINK ", condition = LIKE)
    private String meetingExecutionLink;
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
