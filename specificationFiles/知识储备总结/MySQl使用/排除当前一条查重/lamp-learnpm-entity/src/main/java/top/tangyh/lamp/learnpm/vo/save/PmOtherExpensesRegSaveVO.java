package top.tangyh.lamp.learnpm.vo.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
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
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmOtherExpensesRegSaveVO", description = "会议执行费用支付录入")
public class PmOtherExpensesRegSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议申请id
     */
    @ApiModelProperty(value = "项目会议申请id")
    private Long   pmProjectMeetingApplyId;
    /**
     * 会议申请费用id
     */
    @ApiModelProperty(value = "会议申请费用id")
    private Long   pmConferenceApplyFeeId;
    /**
     * 费用id
     */
    @ApiModelProperty(value = "费用id")
    private Long   msBudgetSubjectId;
    /**
     * 费用名称
     */
    @ApiModelProperty(value = "费用名称")
    @Size(max = 300, message = "费用名称长度不能超过300")
    private String   feeName;
    /**
     * 公司付款金额
     */
    @ApiModelProperty(value = "公司付款金额")
    private BigDecimal   expenseAmount;
    /**
     * 代缴劳务税费
     */
    @ApiModelProperty(value = "代缴劳务税费")
    private BigDecimal   serviceTaxPaidOnBehalf;
    /**
     * 公司实际支出金额
     */
    @ApiModelProperty(value = "公司实际支出金额")
    private BigDecimal   companyActualExpenditureAmount;
    /**
     * 支付类型
     */
    @ApiModelProperty(value = "支付类型")
    @Size(max = 2, message = "支付类型长度不能超过2")
    private String   paymentType;
    /**
     * 收款人id
     */
    @ApiModelProperty(value = "收款人id")
    private Long   payeeId;
    /**
     * 收款账户名称
     */
    @ApiModelProperty(value = "收款账户名称")
    @Size(max = 300, message = "收款账户名称长度不能超过300")
    private String   collectionAccountName;
    /**
     * 开户行
     */
    @ApiModelProperty(value = "开户行")
    @Size(max = 300, message = "开户行长度不能超过300")
    private String   openingBank;
    /**
     * 银行账号
     */
    @ApiModelProperty(value = "银行账号")
    @Size(max = 300, message = "银行账号长度不能超过300")
    private String   bankAccount;
    /**
     * 发票类型
     */
    @ApiModelProperty(value = "发票类型")
    @Size(max = 300, message = "发票类型长度不能超过300")
    private String   invoiceType;
    /**
     * 发票税率
     */
    @ApiModelProperty(value = "发票税率")
    private BigDecimal   invoiceTaxRate;
    /**
     * 专票可抵扣税金
     */
    @ApiModelProperty(value = "专票可抵扣税金")
    private BigDecimal   deductibleTaxSpecialInvoice;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Size(max = 2, message = "状态长度不能超过2")
    private String   status;
    /**
     * 银行回单附件
     */
    @ApiModelProperty(value = "银行回单附件")
    @Size(max = 300, message = "银行回单附件长度不能超过300")
    private String   bankReceiptAttachment;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Size(max = 300, message = "说明长度不能超过300")
    private String   illustrate;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Size(max = 100, message = "扩展字段1长度不能超过100")
    private String   attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Size(max = 100, message = "扩展字段2长度不能超过100")
    private String   attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Size(max = 100, message = "扩展字段3长度不能超过100")
    private String   attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Size(max = 100, message = "扩展字段4长度不能超过100")
    private String   attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Size(max = 100, message = "扩展字段5长度不能超过100")
    private String   attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Size(max = 100, message = "扩展字段6长度不能超过100")
    private String   attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Size(max = 100, message = "扩展字段7长度不能超过100")
    private String   attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Size(max = 100, message = "扩展字段8长度不能超过100")
    private String   attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Size(max = 100, message = "扩展字段9长度不能超过100")
    private String   attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Size(max = 100, message = "扩展字段10长度不能超过100")
    private String   attribute10;
}
