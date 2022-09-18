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
import java.util.Date;



/**
 * <p>
 * 物料制作实体类
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
@ApiModel(value = "PmMaterialProductionResultVO", description = "物料制作")
public class PmMaterialProductionResultVO extends Entity<Long> implements Serializable, EchoVO {
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
     * 物料制作要求
     */
    @ApiModelProperty(value = "物料制作要求")
    @Excel(name = "物料制作要求")
    private String  materialFabricationReq;
    /**
     * 物料制作附件
     */
    @ApiModelProperty(value = "物料制作附件")
    @Excel(name = "物料制作附件")
    private String  materialManufacturingAttachment;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Excel(name = "状态")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.COMMIT_AUDIT_RECEIVE_PROCESS_STATUS)
    private String  status;
    /**
     * 发起人id
     */
    @ApiModelProperty(value = "发起人id")
    @Excel(name = "发起人id")
    private Long  initiatorId;
    /**
     * 发起人手机号
     */
    @ApiModelProperty(value = "发起人手机号")
    @Excel(name = "发起人手机号")
    private String  initiatorPhone;
    /**
     * 发起人
     */
    @ApiModelProperty(value = "发起人")
    @Excel(name = "发起人")
    private String  initiator;
    /**
     * 审批人id
     */
    @ApiModelProperty(value = "审批人id")
    @Excel(name = "审批人id")
    private Long  approverId;
    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
    @Excel(name = "审批人")
    private String  approver;
    /**
     * 审批人手机号
     */
    @ApiModelProperty(value = "审批人手机号")
    @Excel(name = "审批人手机号")
    private String  approverPhone;
    /**
     * 制作人id
     */
    @ApiModelProperty(value = "制作人id")
    @Excel(name = "制作人id")
    private Long  producerId;
    /**
     * 制作人手机号
     */
    @ApiModelProperty(value = "制作人手机号")
    @Excel(name = "制作人手机号")
    private String  producerPhone;
    /**
     * 制作人姓名
     */
    @ApiModelProperty(value = "制作人姓名")
    @Excel(name = "制作人姓名")
    private String  producer;
    /**
     * 发起时间
     */
    @ApiModelProperty(value = "发起时间")
    @Excel(name = "发起时间")
    private Date  initiatorTime;
    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    @Excel(name = "审核时间")
    private Date  auditTime;
    /**
     * 制作确认时间
     */
    @ApiModelProperty(value = "制作确认时间")
    @Excel(name = "制作确认时间")
    private Date  productionConfirmationTime;
    /**
     * 制作费用
     */
    @ApiModelProperty(value = "制作费用")
    @Excel(name = "制作费用")
    private BigDecimal  productionCost;
    /**
     * 制作审批费用
     */
    @ApiModelProperty(value = "制作审批费用")
    @Excel(name = "制作审批费用")
    private BigDecimal  productionApprovalFee;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    @Excel(name = "预算金额")
    private BigDecimal  budgetAmount;
    /**
     * 执行后金额
     */
    @ApiModelProperty(value = "执行后金额")
    @Excel(name = "执行后金额")
    private BigDecimal  afterExecutionAmount;
    /**
     * 已执行金额
     */
    @ApiModelProperty(value = "已执行金额")
    @Excel(name = "已执行金额")
    private BigDecimal  executedAmount;
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

