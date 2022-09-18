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
 * 定快递实体类
 * </p>
 *
 * @author dz
 * @since 2022-06-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmOrderExpressResultVO", description = "定快递")
public class PmOrderExpressResultVO extends Entity<Long> implements Serializable, EchoVO {
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
     * 快递公司
     */
    @ApiModelProperty(value = "快递公司")
    @Excel(name = "快递公司")
    private String  expressCompany;
    /**
     * 快递单号
     */
    @ApiModelProperty(value = "快递单号")
    @Excel(name = "快递单号")
    private String  expressNumber;
    /**
     * 快递费用
     */
    @ApiModelProperty(value = "快递费用")
    @Excel(name = "快递费用")
    private BigDecimal  expressFee;
    /**
     * 发出省份
     */
    @ApiModelProperty(value = "发出省份")
    @Excel(name = "发出省份")
    private String  sendingProvince;
    /**
     * 发出城市
     */
    @ApiModelProperty(value = "发出城市")
    @Excel(name = "发出城市")
    private String  sendingCity;
    /**
     * 发出详细地址
     */
    @ApiModelProperty(value = "发出详细地址")
    @Excel(name = "发出详细地址")
    private String  sendingDetailAddress;
    /**
     * 收件人省份
     */
    @ApiModelProperty(value = "收件人省份")
    @Excel(name = "收件人省份")
    private String  recipientProvince;
    /**
     * 收件人城市
     */
    @ApiModelProperty(value = "收件人城市")
    @Excel(name = "收件人城市")
    private String  recipientCity;
    /**
     * 收件人详细地址
     */
    @ApiModelProperty(value = "收件人详细地址")
    @Excel(name = "收件人详细地址")
    private String  recipientDetailedAddress;
    /**
     * 发件人姓名
     */
    @ApiModelProperty(value = "发件人姓名")
    @Excel(name = "发件人姓名")
    private String  senderName;
    /**
     * 发件人手机号
     */
    @ApiModelProperty(value = "发件人手机号")
    @Excel(name = "发件人手机号")
    private String  senderPhone;
    /**
     * 收件人姓名
     */
    @ApiModelProperty(value = "收件人姓名")
    @Excel(name = "收件人姓名")
    private String  recipientName;
    /**
     * 收件人手机号
     */
    @ApiModelProperty(value = "收件人手机号")
    @Excel(name = "收件人手机号")
    private String  recipientPhone;
    /**
     * 快递状态
     */
    @ApiModelProperty(value = "快递状态")
    @Excel(name = "快递状态")
    private String  expressStatus;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    @Excel(name = "预算金额")
    private BigDecimal  budgetAmount;
    /**
     * 快递费用剩余金额
     */
    @ApiModelProperty(value = "快递费用剩余金额")
    @Excel(name = "快递费用剩余金额")
    private BigDecimal  expressFeeRemainingAmount;
    /**
     * 本次发出后快递费用剩余金额
     */
    @ApiModelProperty(value = "本次发出后快递费用剩余金额")
    @Excel(name = "本次发出后快递费用剩余金额")
    private BigDecimal  afterThisTimeRemainingAmount;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Excel(name = "备注")
    private String  remark;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    @Excel(name = "附件")
    private String  attachment;
    /**
     * 物流快递单号
     */
    @ApiModelProperty(value = "物流快递单号")
    @Excel(name = "物流快递单号")
    private String  logisticsExpressNo;
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

