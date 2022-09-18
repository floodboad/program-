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

import static com.baomidou.mybatisplus.annotation.SqlCondition.EQUAL;
import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

import java.math.BigDecimal;


/**
 * <p>
 * 订酒店实体类
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
@TableName("PM_HOTEL_RESERVATION")
@AllArgsConstructor
@Builder
public class PmHotelReservation extends Entity<Long> {

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
     * 酒店协议附件
     */
    @TableField(value = "HOTEL_AGREEMENT_ATTACHMENT ", condition = LIKE)
    private String hotelAgreementAttachment;
    /**
     * 备注
     */
    @TableField(value = "REMARK ", condition = LIKE)
    private String remark;
    /**
     * 费用金额
     */
    @TableField(value = "EXPENSE_AMOUNT ", condition = LIKE)
    private BigDecimal expenseAmount;
    /**
     * 预算金额
     */
    @TableField(value = "BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal budgetAmount;
    /**
     * 预算剩余金额
     */
    @TableField(value = "BUDGET_REMAINING_AMOUNT ", condition = LIKE)
    private BigDecimal budgetRemainingAmount;
    /**
     * 会议费用申请表id
     */
    @TableField(value = "PM_CONFERENCE_APPLY_FEE_ID ", condition = LIKE)
    private Long pmConferenceApplyFeeId;
    /**
     * 状态
     */
    @TableField(value = "STATUS ", condition = LIKE)
    private String status;
    /**
     * 实际支付金额
     */
    @TableField(value = "ACTUAL_PAYMENT_AMOUNT", condition = EQUAL)
    private BigDecimal actualPaymentAmount;
    /**
     * 费用方式
     */
    @TableField(value = "EXPENSE_METHOD", condition = LIKE)
    private String expenseMethod;
    /**
     * 账户名称
     */
    @TableField(value = "ACCOUNT_TITLE", condition = EQUAL)
    private String accountTitle;
    /**
     * 开户行
     */
    @TableField(value = "OPENING_BANK", condition = EQUAL)
    private String openingBank;
    /**
     * 开户账号
     */
    @TableField(value = "ACCOUNT_NO", condition = EQUAL)
    private String accountNo;
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
