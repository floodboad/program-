package top.tangyh.lamp.learnpm.vo.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.SuperEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * <p>
 *  订餐更新实体类
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
@ApiModel(value = "PmOrderFoodUpdateVO", description = "订餐")
public class PmOrderFoodUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 项目会议申请id
     */
    @ApiModelProperty(value = "项目会议申请id")
    private  Long pmProjectMeetingApplyId;
    /**
     * 会议名称
     */
    @ApiModelProperty(value = "会议名称")
    @Size(max = 300, message = "会议名称长度不能超过300")  
    private  String meetingName;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private  Long pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    @Size(max = 300, message = "项目名称长度不能超过300")  
    private  String projectName;
    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    @Size(max = 2, message = "订单类型长度不能超过2")  
    private  String orderType;
    /**
     * 费用类型
     */
    @ApiModelProperty(value = "费用类型")
    @Size(max = 2, message = "费用类型长度不能超过2")  
    private  String feeType;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    @Size(max = 300, message = "附件长度不能超过300")  
    private  String attachment;
    /**
     * 餐费标准
     */
    @ApiModelProperty(value = "餐费标准")
    private  BigDecimal mealFeeStandard;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    private  BigDecimal budgetAmount;
    /**
     * 本次订餐人数
     */
    @ApiModelProperty(value = "本次订餐人数")
    private  Integer numberPeopleThisTime;
    /**
     * 执行后预算结余金额
     */
    @ApiModelProperty(value = "执行后预算结余金额")
    private  BigDecimal budgetBalanceAfterExe;
    /**
     * 实际消费金额
     */
    @ApiModelProperty(value = "实际消费金额")
    private  BigDecimal actualAmountShangqitong;
    /**
     * 商企通订单id
     */
    @ApiModelProperty(value = "商企通订单id")
    private  Long orderId;
    /**
     * 商企通订单信息
     */
    @ApiModelProperty(value = "商企通订单信息")
    @Size(max = 300, message = "商企通订单信息长度不能超过300")  
    private  String orderInfo;
    /**
     * 会议申请费用表id
     */
    @ApiModelProperty(value = "会议申请费用表id")
    private  Long pmConferenceApplyFeeId;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Size(max = 300, message = "说明长度不能超过300")  
    private  String illustrate;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Size(max = 100, message = "扩展字段1长度不能超过100")  
    private  String attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Size(max = 100, message = "扩展字段2长度不能超过100")  
    private  String attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Size(max = 100, message = "扩展字段3长度不能超过100")  
    private  String attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Size(max = 100, message = "扩展字段4长度不能超过100")  
    private  String attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Size(max = 100, message = "扩展字段5长度不能超过100")  
    private  String attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Size(max = 100, message = "扩展字段6长度不能超过100")  
    private  String attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Size(max = 100, message = "扩展字段7长度不能超过100")  
    private  String attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Size(max = 100, message = "扩展字段8长度不能超过100")  
    private  String attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Size(max = 100, message = "扩展字段9长度不能超过100")  
    private  String attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Size(max = 100, message = "扩展字段10长度不能超过100")  
    private  String attribute10;
}
