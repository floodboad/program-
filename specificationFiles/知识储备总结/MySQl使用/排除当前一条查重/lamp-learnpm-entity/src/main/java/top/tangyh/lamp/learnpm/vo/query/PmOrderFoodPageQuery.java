package top.tangyh.lamp.learnpm.vo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * <p>
 * 订餐翻页查询对象
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmOrderFoodPageQuery", description = "订餐")
public class PmOrderFoodPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议申请id
     */
    @ApiModelProperty(value = "项目会议申请id")
    private Long  pmProjectMeetingApplyId;
    /**
     * 会议名称
     */
    @ApiModelProperty(value = "会议名称")
    private String  meetingName;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long  pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String  projectName;
    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    private String  orderType;
    /**
     * 费用类型
     */
    @ApiModelProperty(value = "费用类型")
    private String  feeType;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private String  attachment;
    /**
     * 餐费标准
     */
    @ApiModelProperty(value = "餐费标准")
    private BigDecimal  mealFeeStandard;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    private BigDecimal  budgetAmount;
    /**
     * 本次订餐人数
     */
    @ApiModelProperty(value = "本次订餐人数")
    private Integer  numberPeopleThisTime;
    /**
     * 执行后预算结余金额
     */
    @ApiModelProperty(value = "执行后预算结余金额")
    private BigDecimal  budgetBalanceAfterExe;
    /**
     * 实际消费金额
     */
    @ApiModelProperty(value = "实际消费金额")
    private BigDecimal  actualAmountShangqitong;
    /**
     * 商企通订单id
     */
    @ApiModelProperty(value = "商企通订单id")
    private Long  orderId;
    /**
     * 商企通订单信息
     */
    @ApiModelProperty(value = "商企通订单信息")
    private String  orderInfo;
    /**
     * 会议申请费用表id
     */
    @ApiModelProperty(value = "会议申请费用表id")
    private Long  pmConferenceApplyFeeId;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String  illustrate;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    private String  attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    private String  attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    private String  attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    private String  attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    private String  attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    private String  attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    private String  attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    private String  attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    private String  attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    private String  attribute10;
}

