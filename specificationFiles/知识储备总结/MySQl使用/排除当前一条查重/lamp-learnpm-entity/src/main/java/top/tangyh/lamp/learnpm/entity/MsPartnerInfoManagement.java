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

/**
 * <p>
 * 合作方信息管理实体类
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
@TableName("MS_PARTNER_INFO_MANAGEMENT")
@AllArgsConstructor
@Builder
public class MsPartnerInfoManagement extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 单位名称 
     */
     @TableField(value = "UNIT_NAME ", condition = LIKE)
    private String unitName;
    /**
     * 合作方编号 
     */
     @TableField(value = "PARTNER_CODE ", condition = LIKE)
    private String partnerCode;
    /**
     * 合作单位性质 
     */
     @TableField(value = "PARTNER_NATURE ", condition = LIKE)
    private String partnerNature;
    /**
     * 合作来源 
     */
     @TableField(value = "COOPERATION_SOURCES ", condition = LIKE)
    private String cooperationSources;
    /**
     * 合作方类别 
     */
     @TableField(value = "PARTNER_CATEGORY ", condition = LIKE)
    private String partnerCategory;
    /**
     * 本单位业务员 
     */
     @TableField(value = "BUSINESS_MANAGER ", condition = LIKE)
    private String businessManager;
    /**
     * 营业执照 
     */
     @TableField(value = "BUSINESS_LICENSE ", condition = LIKE)
    private String businessLicense;
    /**
     * 联系人姓名 
     */
     @TableField(value = "CONTACT_NAME ", condition = LIKE)
    private String contactName;
    /**
     * 所属部门 
     */
     @TableField(value = "DEPARTMENT ", condition = LIKE)
    private String department;
    /**
     * 职务 
     */
     @TableField(value = "POST ", condition = LIKE)
    private String post;
    /**
     * 负责产品 
     */
     @TableField(value = "RESPONSIBLE_PRODUCTS ", condition = LIKE)
    private String responsibleProducts;
    /**
     * 手机号 
     */
     @TableField(value = "PHONE ", condition = LIKE)
    private String phone;
    /**
     * 公司邮箱 
     */
     @TableField(value = "COMPANY_MAILBOX ", condition = LIKE)
    private String companyMailbox;
    /**
     * 私人邮箱 
     */
     @TableField(value = "PRIVATE_MAILBOX ", condition = LIKE)
    private String privateMailbox;
    /**
     * 开票单位名称 
     */
     @TableField(value = "INVOICING_UNIT_NAME ", condition = LIKE)
    private String invoicingUnitName;
    /**
     * 税号 
     */
     @TableField(value = "DUTY_PARAGRAPH ", condition = LIKE)
    private String dutyParagraph;
    /**
     * 地址 
     */
     @TableField(value = "ADDRESS ", condition = LIKE)
    private String address;
    /**
     * 开户行名称 
     */
     @TableField(value = "BANK_BRANCH_NAME ", condition = LIKE)
    private String bankBranchName;
    /**
     * 备注 
     */
     @TableField(value = "REMARK ", condition = LIKE)
    private String remark;
    /**
     * 是否有效 
     */
     @TableField(value = "IS_VALID ", condition = LIKE)
    private String isValid;
    /**
     * 电话 
     */
     @TableField(value = "TEL ", condition = LIKE)
    private String tel;
    /**
     * 开户行账号 
     */
     @TableField(value = "ACCOUNT ", condition = LIKE)
    private String account;
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
