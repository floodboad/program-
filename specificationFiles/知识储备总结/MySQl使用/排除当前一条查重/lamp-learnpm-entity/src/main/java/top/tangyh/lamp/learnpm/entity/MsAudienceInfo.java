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

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;
import java.util.Date;


/**
 * <p>
 * 听众信息表实体类
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("MS_AUDIENCE_INFO")
@AllArgsConstructor
@Builder
public class MsAudienceInfo extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id 
     */
     @TableField(value = "USER_ID ", condition = LIKE)
    private Long userId;
    /**
     * 姓名 
     */
     @TableField(value = "NAME ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.REGEX_CHINESE)
     @NotEmpty(message = "用户名不为空")
    private String name;
    /**
     * 手机号 
     */
     @TableField(value = "PHONE ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.REGEX_MOBILE)
     @NotEmpty(message = "手机号不为空")
    private String phone;
    /**
     * 医院 
     */
     @TableField(value = "HOSPITAL ", condition = LIKE)
    private String hospital;
    /**
     * 科室 
     */
     @TableField(value = "DEPARTMENT ", condition = LIKE)
    private String department;
    /**
     * 医生证号 
     */
     @TableField(value = "DOCTOR_CERTIFICATE_NO ", condition = LIKE)
    private String doctorCertificateNo;
    /**
     * 证件 
     */
     @TableField(value = "CERTIFICATES ", condition = LIKE)
    private String certificates;
    /**
     * 审核状态 
     */
     @TableField(value = "AUDIT_STATUS ", condition = LIKE)
    private String auditStatus;
    /**
     * openid 
     */
     @TableField(value = "OPENID ", condition = LIKE)
    private String openid;
    /**
     * unicode 
     */
     @TableField(value = "UNICODE ", condition = LIKE)
    private String unicode;
    /**
     * 来源 
     */
     @TableField(value = "SOURCE ", condition = LIKE)
    private String source;
    /**
     * 昵称 
     */
     @TableField(value = "NICKNAME ", condition = LIKE)
    private String nickname;
    /**
     * 性别 
     */
     @TableField(value = "SEX ", condition = LIKE)
    private String sex;
    /**
     * 身份证号 
     */
     @TableField(value = "ID_NO ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.REGEX_ID_CARD)
    private String idNo;
    /**
     * 出生年月 
     */
     @TableField(value = "BIRTHDAY ", condition = LIKE)
    private Date birthday;
    /**
     * 所在省市 
     */
     @TableField(value = "PROVINCE ", condition = LIKE)
    private String province;
    /**
     * 所在城市 
     */
     @TableField(value = "CITY ", condition = LIKE)
    private String city;
    /**
     * 详细地址 
     */
     @TableField(value = "ADDRESS ", condition = LIKE)
    private String address;
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
