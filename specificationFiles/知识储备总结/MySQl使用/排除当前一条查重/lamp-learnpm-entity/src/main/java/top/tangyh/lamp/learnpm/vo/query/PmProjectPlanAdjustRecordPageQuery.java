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
 * 项目规划调整记录翻页查询对象
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmProjectPlanAdjustRecordPageQuery", description = "项目规划调整记录")
public class PmProjectPlanAdjustRecordPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 项目号
     */
    @ApiModelProperty(value = "项目号")
    private String  projectCode;
    /**
     * 原会议预算已占用金额
     */
    @ApiModelProperty(value = "原会议预算已占用金额")
    private BigDecimal  originalMeetingBudgetAmt;
    /**
     * 原会议计划场次
     */
    @ApiModelProperty(value = "原会议计划场次")
    private String  originalMeetingPlannedNum;
    /**
     * 原剩余预算金额
     */
    @ApiModelProperty(value = "原剩余预算金额")
    private BigDecimal  originalRemainBudgetAmt;
    /**
     * 调整会议占用金额
     */
    @ApiModelProperty(value = "调整会议占用金额")
    private BigDecimal  adjustMeetingOccupiedAmt;
    /**
     * 调整会议场次
     */
    @ApiModelProperty(value = "调整会议场次")
    private String  adjustMeetingNumber;
    /**
     * 调整后会议计划场次
     */
    @ApiModelProperty(value = "调整后会议计划场次")
    private String  afterAdjustmentMeetingNumber;
    /**
     * 调整后会议预算占用金额
     */
    @ApiModelProperty(value = "调整后会议预算占用金额")
    private String  adjustedMeetingOccupiedAmt;
    /**
     * 调整后剩余预算金额
     */
    @ApiModelProperty(value = "调整后剩余预算金额")
    private BigDecimal  adjustedRemainingBudgetAmt;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String  status;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String  remark;
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

