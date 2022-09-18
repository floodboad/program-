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
 * 交通预定翻页查询对象
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmTransportationReservationPageQuery", description = "交通预定")
public class PmTransportationReservationPageQuery implements Serializable {

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
     * 交通工具类型
     */
    @ApiModelProperty(value = "交通工具类型")
    private String  vehicleType;
    /**
     * 费用金额
     */
    @ApiModelProperty(value = "费用金额")
    private BigDecimal  expenseAmount;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    private BigDecimal  budgetAmount;
    /**
     * 预算剩余金额
     */
    @ApiModelProperty(value = "预算剩余金额")
    private BigDecimal  budgetRemainingAmount;
    /**
     * 预定后剩余金额
     */
    @ApiModelProperty(value = "预定后剩余金额")
    private BigDecimal  remainAmtAfterReservation;
    /**
     * 会议费用申请表id
     */
    @ApiModelProperty(value = "会议费用申请表id")
    private Long  pmConferenceApplyFeeId;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String  status;
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

