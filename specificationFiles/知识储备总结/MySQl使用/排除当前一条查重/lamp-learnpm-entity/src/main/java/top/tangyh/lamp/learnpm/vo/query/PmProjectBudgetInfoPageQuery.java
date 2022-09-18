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
 * 项目预算信息翻页查询对象
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmProjectBudgetInfoPageQuery", description = "项目预算信息")
public class PmProjectBudgetInfoPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long  id;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long  pmProjectId;
    /**
     * 预算科目id
     */
    @ApiModelProperty(value = "预算科目id")
    private Long  msBudgetSubjectId;
    /**
     * 预算科目名称
     */
    @ApiModelProperty(value = "预算科目名称")
    private String  subjectName;
    /**
     * 对外报价
     */
    @ApiModelProperty(value = "对外报价")
    private BigDecimal  externalQuotation;
    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private BigDecimal  price;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer  num;
    /**
     * 场次
     */
    @ApiModelProperty(value = "场次")
    private Integer  times;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    private BigDecimal  budgetAmount;
    /**
     * 预算类型
     */
    @ApiModelProperty(value = "预算类型")
    private String  budgetType;
    /**
     * 变更金额
     */
    @ApiModelProperty(value = "变更金额")
    private BigDecimal  changeAmount;
    /**
     * 调整后金额
     */
    @ApiModelProperty(value = "调整后金额")
    private BigDecimal  adjustedAmount;
    /**
     * 实际规划金额
     */
    @ApiModelProperty(value = "实际规划金额")
    private BigDecimal  actualPlannedAmount;
    /**
     * 实际支出金额
     */
    @ApiModelProperty(value = "实际支出金额")
    private BigDecimal  actualExpenditureAmount;
    /**
     * 剩余金额
     */
    @ApiModelProperty(value = "剩余金额")
    private BigDecimal  remainingAmount;
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

