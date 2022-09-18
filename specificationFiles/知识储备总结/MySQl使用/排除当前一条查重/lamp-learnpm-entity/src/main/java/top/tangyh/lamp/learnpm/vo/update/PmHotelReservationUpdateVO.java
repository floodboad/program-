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
 *  订酒店更新实体类
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
@ApiModel(value = "PmHotelReservationUpdateVO", description = "订酒店")
public class PmHotelReservationUpdateVO implements Serializable {

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
     * 酒店协议附件
     */
    @ApiModelProperty(value = "酒店协议附件")
    @Size(max = 300, message = "酒店协议附件长度不能超过300")  
    private  String hotelAgreementAttachment;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 300, message = "备注长度不能超过300")  
    private  String remark;
    /**
     * 费用金额
     */
    @ApiModelProperty(value = "费用金额")
    private  BigDecimal expenseAmount;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    private  BigDecimal budgetAmount;
    /**
     * 预算剩余金额
     */
    @ApiModelProperty(value = "预算剩余金额")
    private  BigDecimal budgetRemainingAmount;
    /**
     * 会议费用申请表id
     */
    @ApiModelProperty(value = "会议费用申请表id")
    private  Long pmConferenceApplyFeeId;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Size(max = 2, message = "状态长度不能超过2")  
    private  String status;

    @ApiModelProperty(value = "实际支付金额")
    private BigDecimal actualPaymentAmount;

    @ApiModelProperty(value = "费用方式")
    private String expenseMethod;

    @ApiModelProperty(value = "账户名称")
    private String accountTitle;

    @ApiModelProperty(value = "开户行")
    private String openingBank;

    @ApiModelProperty(value = "开户账号")
    private String accountNo;
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
