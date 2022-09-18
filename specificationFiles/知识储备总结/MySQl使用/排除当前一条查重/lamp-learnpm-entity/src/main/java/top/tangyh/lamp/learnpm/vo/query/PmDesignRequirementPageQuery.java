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
import java.util.Date;
import java.math.BigDecimal;



/**
 * <p>
 * 设计要求翻页查询对象
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
@ApiModel(value = "PmDesignRequirementPageQuery", description = "设计要求")
public class PmDesignRequirementPageQuery implements Serializable {

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
     * 设计要求说明
     */
    @ApiModelProperty(value = "设计要求说明")
    private String  designReqDescription;
    /**
     * 设计资料附件
     */
    @ApiModelProperty(value = "设计资料附件")
    private String  designDataAttachment;
    /**
     * 设计成果附件
     */
    @ApiModelProperty(value = "设计成果附件")
    private String  designResultAttachment;
    /**
     * 申请人id
     */
    @ApiModelProperty(value = "申请人id")
    private Long  applicantId;
    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    private String  applicant;
    /**
     * 申请人手机号
     */
    @ApiModelProperty(value = "申请人手机号")
    private String  applicantPhone;
    /**
     * 实际设计费用
     */
    @ApiModelProperty(value = "实际设计费用")
    private BigDecimal  actualDesignCost;
    /**
     * 设计费用结余
     */
    @ApiModelProperty(value = "设计费用结余")
    private BigDecimal  designCostBalance;
    /**
     * 执行前预算金额
     */
    @ApiModelProperty(value = "执行前预算金额")
    private BigDecimal  beforeExeBudgetAmount;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    private BigDecimal  budgetAmount;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String  status;
    /**
     * 申请金额
     */
    @ApiModelProperty(value = "申请金额")
    private BigDecimal  applicationAmount;
    /**
     * 审批人id
     */
    @ApiModelProperty(value = "审批人id")
    private Long  approverId;
    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
    private String  approver;
    /**
     * 审批人手机号
     */
    @ApiModelProperty(value = "审批人手机号")
    private String  approverPhone;
    /**
     * 制作人id
     */
    @ApiModelProperty(value = "制作人id")
    private Long  producerId;
    /**
     * 制作人手机号
     */
    @ApiModelProperty(value = "制作人手机号")
    private String  producerPhone;
    /**
     * 制作人姓名
     */
    @ApiModelProperty(value = "制作人姓名")
    private String  producer;
    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    private Date  applicationTime;
    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private Date  auditTime;
    /**
     * 制作时间
     */
    @ApiModelProperty(value = "制作时间")
    private Date  producerTime;
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

