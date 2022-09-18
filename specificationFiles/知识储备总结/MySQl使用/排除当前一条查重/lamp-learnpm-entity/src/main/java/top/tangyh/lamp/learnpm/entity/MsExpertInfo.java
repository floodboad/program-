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
 * 专家信息实体类
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
@TableName("MS_EXPERT_INFO")
@AllArgsConstructor
@Builder
public class MsExpertInfo extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名 
     */
     @TableField(value = "NAME ", condition = LIKE)
     @NotEmpty(message = "名字不为空")
     @Pattern(regexp = ValidatorUtil.REGEX_CHINESE)
    private String name;
    /**
     * 性别 
     */
     @TableField(value = "SEX ", condition = LIKE)
    private String sex;
    /**
     * 电话 
     */
    @Pattern(regexp = ValidatorUtil.REGEX_MOBILE)
    @TableField(value = "TEL ", condition = LIKE)
    private String tel;
    /**
     * 证件类型 
     */
     @TableField(value = "CERTIFICATE_TYPE ", condition = LIKE)
    private String certificateType;
    /**
     * 证件号码 
     */
     @TableField(value = "CERTIFICATE_CODE ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.REGEX_ID_CARD)
    private String certificateCode;
    /**
     * 出生日期 
     */
     @TableField(value = "BIRTHDAY ", condition = LIKE)
    private Date birthday;
    /**
     * 通讯地址 
     */
     @TableField(value = "POSTAL_ADDRESS ", condition = LIKE)
    private String postalAddress;
    /**
     * 任职医院 
     */
     @TableField(value = "WORKING_HOSPITAL ", condition = LIKE)
    private String workingHospital;
    /**
     * 任职科室 
     */
     @TableField(value = "DEPARTMENT ", condition = LIKE)
    private String department;
    /**
     * 职务 
     */
     @TableField(value = "POST ", condition = LIKE)
    private String post;
    /**
     * 开户行名称 
     */
     @TableField(value = "BANK_BRANCH_NAME ", condition = LIKE)
    private String bankBranchName;
    /**
     * 开户行账号 
     */
     @TableField(value = "ACCOUNT ", condition = LIKE)
    private String account;
    /**
     * 头像 
     */
     @TableField(value = "HEAD_PORTRAIT ", condition = LIKE)
    private String headPortrait;
    /**
     * 专家简介 
     */
     @TableField(value = "EXPERT_PROFILE ", condition = LIKE)
    private String expertProfile;
    /**
     * 最高学历 
     */
     @TableField(value = "HIGHEST_EDUCATION ", condition = LIKE)
    private String highestEducation;
    /**
     * 学位 
     */
     @TableField(value = "ACADEMIC_DEGREE ", condition = LIKE)
    private String academicDegree;
    /**
     * 参加工作时间 
     */
     @TableField(value = "WORK_DATE ", condition = LIKE)
     @Pattern(regexp = ValidatorUtil.TIME_REGEX)
    private Date workDate;
    /**
     * 毕业院校 
     */
     @TableField(value = "GRADUATE_SCHOOL ", condition = LIKE)
    private String graduateSchool;
    /**
     * 专业 
     */
     @TableField(value = "MAJOR ", condition = LIKE)
    private String major;
    /**
     * 专业特长 
     */
     @TableField(value = "SPECIALTY ", condition = LIKE)
    private String specialty;
    /**
     * 技术职称 
     */
     @TableField(value = "TECHNICAL_TITLE ", condition = LIKE)
    private String technicalTitle;
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
     * 状态 
     */
     @TableField(value = "STATUS ", condition = LIKE)
    private String status;
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
