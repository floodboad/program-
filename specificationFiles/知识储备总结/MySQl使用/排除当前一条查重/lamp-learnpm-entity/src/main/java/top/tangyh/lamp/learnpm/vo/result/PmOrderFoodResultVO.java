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
 * 订餐实体类
 * </p>
 *
 * @author dz
 * @since 2022-06-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmOrderFoodResultVO", description = "订餐")
public class PmOrderFoodResultVO extends Entity<Long> implements Serializable, EchoVO {
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
     * 会议名称
     */
    @ApiModelProperty(value = "会议名称")
    @Excel(name = "会议名称")
    private String  meetingName;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    @Excel(name = "项目id")
    private Long  pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    @Excel(name = "项目名称")
    private String  projectName;
    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    @Excel(name = "订单类型")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.ORDER_TYPE)
    private String  orderType;
    /**
     * 费用类型
     */
    @ApiModelProperty(value = "费用类型")
    @Excel(name = "费用类型")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.FEE_TYPE)
    private String  feeType;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    @Excel(name = "附件")
    private String  attachment;
    /**
     * 餐费标准
     */
    @ApiModelProperty(value = "餐费标准")
    @Excel(name = "餐费标准")
    private BigDecimal  mealFeeStandard;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    @Excel(name = "预算金额")
    private BigDecimal  budgetAmount;
    /**
     * 本次订餐人数
     */
    @ApiModelProperty(value = "本次订餐人数")
    @Excel(name = "本次订餐人数")
    private Integer  numberPeopleThisTime;
    /**
     * 执行后预算结余金额
     */
    @ApiModelProperty(value = "执行后预算结余金额")
    @Excel(name = "执行后预算结余金额")
    private BigDecimal  budgetBalanceAfterExe;
    /**
     * 实际消费金额
     */
    @ApiModelProperty(value = "实际消费金额")
    @Excel(name = "实际消费金额")
    private BigDecimal  actualAmountShangqitong;
    /**
     * 商企通订单id
     */
    @ApiModelProperty(value = "商企通订单id")
    @Excel(name = "商企通订单id")
    private Long  orderId;
    /**
     * 商企通订单信息
     */
    @ApiModelProperty(value = "商企通订单信息")
    @Excel(name = "商企通订单信息")
    private String  orderInfo;
    /**
     * 会议申请费用表id
     */
    @ApiModelProperty(value = "会议申请费用表id")
    @Excel(name = "会议申请费用表id")
    private Long  pmConferenceApplyFeeId;
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

