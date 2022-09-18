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
 * 会议执行费用支付录入实体类
 * </p>
 *
 * @author dz
 * @date 2022-07-04
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_OTHER_EXPENSES_REG")
@AllArgsConstructor
@Builder
public class PmOtherExpensesReg extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议申请id 
     */
     @TableField(value = "PM_PROJECT_MEETING_APPLY_ID ", condition = LIKE)
    private Long pmProjectMeetingApplyId;
    /**
     * 会议申请费用id 
     */
     @TableField(value = "PM_CONFERENCE_APPLY_FEE_ID ", condition = LIKE)
    private Long pmConferenceApplyFeeId;
    /**
     * 费用id 
     */
     @TableField(value = "MS_BUDGET_SUBJECT_ID ", condition = LIKE)
    private Long msBudgetSubjectId;
    /**
     * 费用名称 
     */
     @TableField(value = "FEE_NAME ", condition = LIKE)
    private String feeName;
    /**
     * 公司付款金额 
     */
     @TableField(value = "EXPENSE_AMOUNT ", condition = LIKE)
    private BigDecimal expenseAmount;
    /**
     * 代缴劳务税费 
     */
     @TableField(value = "SERVICE_TAX_PAID_ON_BEHALF ", condition = LIKE)
    private BigDecimal serviceTaxPaidOnBehalf;
    /**
     * 公司实际支出金额 
     */
     @TableField(value = "COMPANY_ACTUAL_EXPENDITURE_AMOUNT ", condition = LIKE)
    private BigDecimal companyActualExpenditureAmount;
    /**
     * 支付类型 
     */
     @TableField(value = "PAYMENT_TYPE ", condition = LIKE)
    private String paymentType;
    /**
     * 收款人id 
     */
     @TableField(value = "PAYEE_ID ", condition = LIKE)
    private Long payeeId;
    /**
     * 收款账户名称 
     */
     @TableField(value = "COLLECTION_ACCOUNT_NAME ", condition = LIKE)
    private String collectionAccountName;
    /**
     * 开户行 
     */
     @TableField(value = "OPENING_BANK ", condition = LIKE)
    private String openingBank;
    /**
     * 银行账号 
     */
     @TableField(value = "BANK_ACCOUNT ", condition = LIKE)
    private String bankAccount;
    /**
     * 发票类型 
     */
     @TableField(value = "INVOICE_TYPE ", condition = LIKE)
    private String invoiceType;
    /**
     * 发票税率 
     */
     @TableField(value = "INVOICE_TAX_RATE ", condition = LIKE)
    private BigDecimal invoiceTaxRate;
    /**
     * 专票可抵扣税金 
     */
     @TableField(value = "DEDUCTIBLE_TAX_SPECIAL_INVOICE ", condition = LIKE)
    private BigDecimal deductibleTaxSpecialInvoice;
    /**
     * 状态 
     */
     @TableField(value = "STATUS ", condition = LIKE)
    private String status;
    /**
     * 银行回单附件 
     */
     @TableField(value = "BANK_RECEIPT_ATTACHMENT ", condition = LIKE)
    private String bankReceiptAttachment;
    /**
     * 说明 
     */
     @TableField(value = "ILLUSTRATE ", condition = LIKE)
    private String illustrate;
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
