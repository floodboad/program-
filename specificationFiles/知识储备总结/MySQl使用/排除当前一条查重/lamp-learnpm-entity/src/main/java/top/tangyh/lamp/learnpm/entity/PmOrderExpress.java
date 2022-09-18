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
 * 定快递实体类
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_ORDER_EXPRESS")
@AllArgsConstructor
@Builder
public class PmOrderExpress extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议申请id 
     */
     @TableField(value = "PM_PROJECT_MEETING_APPLY_ID ", condition = LIKE)
    private Long pmProjectMeetingApplyId;
    /**
     * 会议名称 
     */
     @TableField(value = "MEETING_NAME ", condition = LIKE)
    private String meetingName;
    /**
     * 项目id 
     */
     @TableField(value = "PM_PROJECT_ID ", condition = LIKE)
    private Long pmProjectId;
    /**
     * 项目名称 
     */
     @TableField(value = "PROJECT_NAME ", condition = LIKE)
    private String projectName;
    /**
     * 快递公司 
     */
     @TableField(value = "EXPRESS_COMPANY ", condition = LIKE)
    private String expressCompany;
    /**
     * 快递单号 
     */
     @TableField(value = "EXPRESS_NUMBER ", condition = LIKE)
    private String expressNumber;
    /**
     * 快递费用 
     */
     @TableField(value = "EXPRESS_FEE ", condition = LIKE)
    private BigDecimal expressFee;
    /**
     * 发出省份 
     */
     @TableField(value = "SENDING_PROVINCE ", condition = LIKE)
    private String sendingProvince;
    /**
     * 发出城市 
     */
     @TableField(value = "SENDING_CITY ", condition = LIKE)
    private String sendingCity;
    /**
     * 发出详细地址 
     */
     @TableField(value = "SENDING_DETAIL_ADDRESS ", condition = LIKE)
    private String sendingDetailAddress;
    /**
     * 收件人省份 
     */
     @TableField(value = "RECIPIENT_PROVINCE ", condition = LIKE)
    private String recipientProvince;
    /**
     * 收件人城市 
     */
     @TableField(value = "RECIPIENT_CITY ", condition = LIKE)
    private String recipientCity;
    /**
     * 收件人详细地址 
     */
     @TableField(value = "RECIPIENT_DETAILED_ADDRESS ", condition = LIKE)
    private String recipientDetailedAddress;
    /**
     * 发件人姓名 
     */
     @TableField(value = "SENDER_NAME ", condition = LIKE)
    private String senderName;
    /**
     * 发件人手机号 
     */
     @TableField(value = "SENDER_PHONE ", condition = LIKE)
    private String senderPhone;
    /**
     * 收件人姓名 
     */
     @TableField(value = "RECIPIENT_NAME ", condition = LIKE)
    private String recipientName;
    /**
     * 收件人手机号 
     */
     @TableField(value = "RECIPIENT_PHONE ", condition = LIKE)
    private String recipientPhone;
    /**
     * 快递状态 
     */
     @TableField(value = "EXPRESS_STATUS ", condition = LIKE)
    private String expressStatus;
    /**
     * 预算金额 
     */
     @TableField(value = "BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal budgetAmount;
    /**
     * 快递费用剩余金额 
     */
     @TableField(value = "EXPRESS_FEE_REMAINING_AMOUNT ", condition = LIKE)
    private BigDecimal expressFeeRemainingAmount;
    /**
     * 本次发出后快递费用剩余金额 
     */
     @TableField(value = "AFTER_THIS_TIME_REMAINING_AMOUNT ", condition = LIKE)
    private BigDecimal afterThisTimeRemainingAmount;
    /**
     * 备注 
     */
     @TableField(value = "REMARK ", condition = LIKE)
    private String remark;
    /**
     * 附件 
     */
     @TableField(value = "ATTACHMENT ", condition = LIKE)
    private String attachment;
    /**
     * 物流快递单号 
     */
     @TableField(value = "LOGISTICS_EXPRESS_NO ", condition = LIKE)
    private String logisticsExpressNo;
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
