package top.tangyh.lamp.learnpm.vo.result;
import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.Entity;
import top.tangyh.basic.interfaces.echo.EchoVO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import top.tangyh.lamp.model.constant.EchoApi;
import top.tangyh.lamp.model.constant.EchoDictType;
import top.tangyh.basic.annotation.echo.Echo;
import java.math.BigDecimal;


/**
 * <p>
 * 会议执行费用支付录入实体类
 * </p>
 *
 * @author dz
 * @since 2022-07-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmOtherExpensesRegResultVO", description = "会议执行费用支付录入")
public class PmOtherExpensesRegResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 项目会议申请id
     */
    @ApiModelProperty(value = "项目会议申请id")
    @Excel(name = "项目会议申请id")
    private Long  pmProjectMeetingApplyId;
    /**
     * 会议申请费用id
     */
    @ApiModelProperty(value = "会议申请费用id")
    @Excel(name = "会议申请费用id")
    private Long  pmConferenceApplyFeeId;
    /**
     * 费用id
     */
    @ApiModelProperty(value = "费用id")
    @Excel(name = "费用id")
    private Long  msBudgetSubjectId;
    /**
     * 费用名称
     */
    @ApiModelProperty(value = "费用名称")
    @Excel(name = "费用名称")
    private String  feeName;
    /**
     * 公司付款金额
     */
    @ApiModelProperty(value = "公司付款金额")
    @Excel(name = "公司付款金额")
    private BigDecimal  expenseAmount;
    /**
     * 代缴劳务税费
     */
    @ApiModelProperty(value = "代缴劳务税费")
    @Excel(name = "代缴劳务税费")
    private BigDecimal  serviceTaxPaidOnBehalf;
    /**
     * 公司实际支出金额
     */
    @ApiModelProperty(value = "公司实际支出金额")
    @Excel(name = "公司实际支出金额")
    private BigDecimal  companyActualExpenditureAmount;
    /**
     * 支付类型
     */
    @ApiModelProperty(value = "支付类型")
    @Excel(name = "支付类型")
    private String  paymentType;
    /**
     * 收款人id
     */
    @ApiModelProperty(value = "收款人id")
    @Excel(name = "收款人id")
    private Long  payeeId;
    /**
     * 收款账户名称
     */
    @ApiModelProperty(value = "收款账户名称")
    @Excel(name = "收款账户名称")
    private String  collectionAccountName;
    /**
     * 开户行
     */
    @ApiModelProperty(value = "开户行")
    @Excel(name = "开户行")
    private String  openingBank;
    /**
     * 银行账号
     */
    @ApiModelProperty(value = "银行账号")
    @Excel(name = "银行账号")
    private String  bankAccount;
    /**
     * 发票类型
     */
    @ApiModelProperty(value = "发票类型")
    @Excel(name = "发票类型")
    private String  invoiceType;
    /**
     * 发票税率
     */
    @ApiModelProperty(value = "发票税率")
    @Excel(name = "发票税率")
    private BigDecimal  invoiceTaxRate;
    /**
     * 专票可抵扣税金
     */
    @ApiModelProperty(value = "专票可抵扣税金")
    @Excel(name = "专票可抵扣税金")
    private BigDecimal  deductibleTaxSpecialInvoice;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Excel(name = "状态")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.COMMIT_AUDIT_PAYMENT_STATUS)
    private String  status;
    /**
     * 银行回单附件
     */
    @ApiModelProperty(value = "银行回单附件")
    @Excel(name = "银行回单附件")
    private String  bankReceiptAttachment;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Excel(name = "说明")
    private String  illustrate;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Excel(name = "扩展字段1")
    private String  attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Excel(name = "扩展字段2")
    private String  attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Excel(name = "扩展字段3")
    private String  attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Excel(name = "扩展字段4")
    private String  attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Excel(name = "扩展字段5")
    private String  attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Excel(name = "扩展字段6")
    private String  attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Excel(name = "扩展字段7")
    private String  attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Excel(name = "扩展字段8")
    private String  attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Excel(name = "扩展字段9")
    private String  attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Excel(name = "扩展字段10")
    private String  attribute10;
}

