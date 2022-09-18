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
 *  项目预算信息更新实体类
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
@ApiModel(value = "PmProjectBudgetInfoUpdateVO", description = "项目预算信息")
public class PmProjectBudgetInfoUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private  Long pmProjectId;
    /**
     * 预算科目id
     */
    @ApiModelProperty(value = "预算科目id")
    private  Long msBudgetSubjectId;
    /**
     * 预算科目名称
     */
    @ApiModelProperty(value = "预算科目名称")
    @Size(max = 300, message = "预算科目名称长度不能超过300")  
    private  String subjectName;
    /**
     * 对外报价
     */
    @ApiModelProperty(value = "对外报价")
    private  BigDecimal externalQuotation;
    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private  BigDecimal price;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private  Integer num;
    /**
     * 场次
     */
    @ApiModelProperty(value = "场次")
    private  Integer times;
    /**
     * 预算金额
     */
    @ApiModelProperty(value = "预算金额")
    private  BigDecimal budgetAmount;
    /**
     * 预算类型
     */
    @ApiModelProperty(value = "预算类型")
    @Size(max = 2, message = "预算类型长度不能超过2")  
    private  String budgetType;
    /**
     * 变更金额
     */
    @ApiModelProperty(value = "变更金额")
    private  BigDecimal changeAmount;
    /**
     * 调整后金额
     */
    @ApiModelProperty(value = "调整后金额")
    private  BigDecimal adjustedAmount;
    /**
     * 实际规划金额
     */
    @ApiModelProperty(value = "实际规划金额")
    private  BigDecimal actualPlannedAmount;
    /**
     * 实际支出金额
     */
    @ApiModelProperty(value = "实际支出金额")
    private  BigDecimal actualExpenditureAmount;
    /**
     * 剩余金额
     */
    @ApiModelProperty(value = "剩余金额")
    private  BigDecimal remainingAmount;
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
