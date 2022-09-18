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
 * 项目赞助企业实体类
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
@TableName("PM_PROJECT_SPONSOR")
@AllArgsConstructor
@Builder
public class PmProjectSponsor extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id 
     */
     @TableField(value = "PM_PROJECT_ID ", condition = LIKE)
    private Long pmProjectId;
    /**
     * 赞助企业id 
     */
     @TableField(value = "SPONSOR_ID ", condition = LIKE)
    private Long sponsorId;
    /**
     * 赞助企业名称 
     */
     @TableField(value = "SPONSOR_NAME ", condition = LIKE)
    private String sponsorName;
    /**
     * 金额 
     */
     @TableField(value = "AMOUNT_MONEY ", condition = LIKE)
    private BigDecimal amountMoney;
    /**
     * 税费 
     */
     @TableField(value = "TAXATION ", condition = LIKE)
    private BigDecimal taxation;
    /**
     * 管理费 
     */
     @TableField(value = "MANAGEMENT_EXPENSE ", condition = LIKE)
    private BigDecimal managementExpense;
    /**
     * 系统维护费 
     */
     @TableField(value = "SYSTEM_MAINTENANCE_COST ", condition = LIKE)
    private BigDecimal systemMaintenanceCost;
    /**
     * 联系人 
     */
     @TableField(value = "CONTACTS ", condition = LIKE)
    private String contacts;
    /**
     * 联系电话 
     */
     @TableField(value = "CONTACT_NUMBER ", condition = LIKE)
    private String contactNumber;
    /**
     * 附件 
     */
     @TableField(value = "ATTACHMENT ", condition = LIKE)
    private String attachment;
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
