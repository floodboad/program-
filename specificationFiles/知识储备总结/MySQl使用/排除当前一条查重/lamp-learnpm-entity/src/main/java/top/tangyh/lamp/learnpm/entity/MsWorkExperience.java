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

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;
import java.util.Date;


/**
 * <p>
 * 工作经历实体类
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("MS_WORK_EXPERIENCE")
@AllArgsConstructor
@Builder
public class MsWorkExperience extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 专家信息id 
     */
     @TableField(value = "MS_EXPERT_INFO_ID ", condition = LIKE)
    private Long msExpertInfoId;
    /**
     * 开始日期 
     */
     @TableField(value = "START_DATE ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.TIME_REGEX)
    private Date startDate;
    /**
     * 结束日期 
     */
     @TableField(value = "END_DATE ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.TIME_REGEX)
    private Date endDate;
    /**
     * 工作单位 
     */
     @TableField(value = "WORK_UNIT ", condition = LIKE)
    private String workUnit;
    /**
     * 部门职务 
     */
     @TableField(value = "DEPARTMENT_TITLE ", condition = LIKE)
    private String departmentTitle;
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
