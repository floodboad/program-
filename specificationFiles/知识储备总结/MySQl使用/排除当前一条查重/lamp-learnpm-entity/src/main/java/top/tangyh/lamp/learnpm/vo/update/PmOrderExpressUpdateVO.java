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
 *  定快递更新实体类
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
@ApiModel(value = "PmOrderExpressUpdateVO", description = "定快递")
public class PmOrderExpressUpdateVO implements Serializable {

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
     * 快递公司
     */
    @ApiModelProperty(value = "快递公司")
    @Size(max = 300, message = "快递公司长度不能超过300")  
    private  String expressCompany;
    /**
     * 快递单号
     */
    @ApiModelProperty(value = "快递单号")
    @Size(max = 300, message = "快递单号长度不能超过300")  
    private  String expressNumber;
    /**
     * 快递费用
     */
    @ApiModelProperty(value = "快递费用")
    private  BigDecimal expressFee;
    /**
     * 发出省份
     */
    @ApiModelProperty(value = "发出省份")
    @Size(max = 300, message = "发出省份长度不能超过300")  
    private  String sendingProvince;
    /**
     * 发出城市
     */
    @ApiModelProperty(value = "发出城市")
    @Size(max = 300, message = "发出城市长度不能超过300")  
    private  String sendingCity;
    /**
     * 发出详细地址
     */
    @ApiModelProperty(value = "发出详细地址")
    @Size(max = 300, message = "发出详细地址长度不能超过300")  
    private  String sendingDetailAddress;
    /**
     * 收件人省份
     */
    @ApiModelProperty(value = "收件人省份")
    @Size(max = 300, message = "收件人省份长度不能超过300")  
    private  String recipientProvince;
    /**
     * 收件人城市
     */
    @ApiModelProperty(value = "收件人城市")
    @Size(max = 300, message = "收件人城市长度不能超过300")  
    private  String recipientCity;
    /**
     * 收件人详细地址
     */
    @ApiModelProperty(value = "收件人详细地址")
    @Size(max = 300, message = "收件人详细地址长度不能超过300")  
    private  String recipientDetailedAddress;
    /**
     * 发件人姓名
     */
    @ApiModelProperty(value = "发件人姓名")
    @Size(max = 200, message = "发件人姓名长度不能超过200")  
    private  String senderName;
    /**
     * 发件人手机号
     */
    @ApiModelProperty(value = "发件人手机号")
    @Size(max = 11, message = "发件人手机号长度不能超过11")  
    private  String senderPhone;
    /**
     * 收件人姓名
     */
    @ApiModelProperty(value = "收件人姓名")
    @Size(max = 200, message = "收件人姓名长度不能超过200")  
    private  String recipientName;
    /**
     * 收件人手机号
     */
    @ApiModelProperty(value = "收件人手机号")
    @Size(max = 11, message = "收件人手机号长度不能超过11")  
    private  String recipientPhone;
    /**
     * 快递状态
     */
    @ApiModelProperty(value = "快递状态")
    @Size(max = 2, message = "快递状态长度不能超过2")  
    private  String expressStatus;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    private  BigDecimal budgetAmount;
    /**
     * 快递费用剩余金额
     */
    @ApiModelProperty(value = "快递费用剩余金额")
    private  BigDecimal expressFeeRemainingAmount;
    /**
     * 本次发出后快递费用剩余金额
     */
    @ApiModelProperty(value = "本次发出后快递费用剩余金额")
    private  BigDecimal afterThisTimeRemainingAmount;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 300, message = "备注长度不能超过300")  
    private  String remark;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    @Size(max = 300, message = "附件长度不能超过300")  
    private  String attachment;
    /**
     * 物流快递单号
     */
    @ApiModelProperty(value = "物流快递单号")
    @Size(max = 300, message = "物流快递单号长度不能超过300")  
    private  String logisticsExpressNo;
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
