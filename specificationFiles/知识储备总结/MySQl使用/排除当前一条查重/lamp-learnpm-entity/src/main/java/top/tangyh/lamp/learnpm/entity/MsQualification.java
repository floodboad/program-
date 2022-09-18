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
 * 资格证书实体类
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
@TableName("MS_QUALIFICATION")
@AllArgsConstructor
@Builder
public class MsQualification extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 专家信息id 
     */
     @TableField(value = "MS_EXPERT_INFO_ID ", condition = LIKE)
    private Long msExpertInfoId;
    /**
     * 证书名称 
     */
     @TableField(value = "CERTIFICATE_NAME ", condition = LIKE)
    private String certificateName;
    /**
     * 专业类别 
     */
     @TableField(value = "SPECIALTY_CATEGORY ", condition = LIKE)
    private String specialtyCategory;
    /**
     * 等级 
     */
     @TableField(value = "LEVEL ", condition = LIKE)
    private String level;
    /**
     * 发证日期 
     */
     @TableField(value = "ISSUE_DATE ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.TIME_REGEX)
    private Date issueDate;
    /**
     * 有效日期 
     */
     @TableField(value = "EFFECTIVE_DATE ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.TIME_REGEX)
    private Date effectiveDate;
    /**
     * 颁布单位 
     */
     @TableField(value = "PUBLISH_UNIT ", condition = LIKE)
    private String publishUnit;
    /**
     * 扫描件 
     */
     @TableField(value = "SCANNING_COPY ", condition = LIKE)
    private String scanningCopy;
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
