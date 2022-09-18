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
 * 联系人信息实体类
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
@TableName("MS_CONTACT_INFO")
@AllArgsConstructor
@Builder
public class MsContactInfo extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 合作单位ID 
     */
     @TableField(value = "MS_PARTNER_INFO_MANAGEMENT_ID ", condition = LIKE)
    private Long msPartnerInfoManagementId;
    /**
     * 姓名 
     */
     @TableField(value = "NAME ", condition = LIKE)
    private String name;
    /**
     * 部门 
     */
     @TableField(value = "DEPARTMENT ", condition = LIKE)
    private String department;
    /**
     * 手机号 
     */
     @TableField(value = "PHONE ", condition = LIKE)
    private String phone;
    /**
     * 电子邮箱 
     */
     @TableField(value = "EMAIL ", condition = LIKE)
    private String email;
    /**
     * 职位 
     */
     @TableField(value = "POST ", condition = LIKE)
    private String post;
    /**
     * 负责产品 
     */
     @TableField(value = "RESPONSIBLE_PRODUCTS ", condition = LIKE)
    private String responsibleProducts;
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
