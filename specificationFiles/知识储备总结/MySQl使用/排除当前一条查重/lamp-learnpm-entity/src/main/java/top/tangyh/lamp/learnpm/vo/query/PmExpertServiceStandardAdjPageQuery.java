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
 * 会议规划专家劳务标准调整记录翻页查询对象
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
@ApiModel(value = "PmExpertServiceStandardAdjPageQuery", description = "会议规划专家劳务标准调整记录")
public class PmExpertServiceStandardAdjPageQuery implements Serializable {

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
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    private String  projectMeetingPlanningName;
    /**
     * 费用id
     */
    @ApiModelProperty(value = "费用id")
    private Long  msBudgetSubjectId;
    /**
     * 费用名称
     */
    @ApiModelProperty(value = "费用名称")
    private String  feeName;
    /**
     * 费用执行标准
     */
    @ApiModelProperty(value = "费用执行标准")
    private String  controlStandards;
    /**
     * 人数
     */
    @ApiModelProperty(value = "人数")
    private Long  personNumber;
    /**
     * 劳务税费
     */
    @ApiModelProperty(value = "劳务税费")
    private BigDecimal  serviceTax;
    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private BigDecimal  amountMoney;
    /**
     * 会议规划调整id
     */
    @ApiModelProperty(value = "会议规划调整id")
    private Long  pmProjectMeetingPlanAdjustId;
    /**
     * 原扣税支出
     */
    @ApiModelProperty(value = "原扣税支出")
    private BigDecimal  originalTaxDeductionExpense;
    /**
     * 原劳务税费
     */
    @ApiModelProperty(value = "原劳务税费")
    private BigDecimal  originalServiceTax;
    /**
     * 原金额
     */
    @ApiModelProperty(value = "原金额")
    private BigDecimal  originalAmountMoney;
    /**
     * 扣税支出
     */
    @ApiModelProperty(value = "扣税支出")
    private BigDecimal  taxDeductionExpense;
    /**
     * 专家类型
     */
    @ApiModelProperty(value = "专家类型")
    private String  expertType;
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

