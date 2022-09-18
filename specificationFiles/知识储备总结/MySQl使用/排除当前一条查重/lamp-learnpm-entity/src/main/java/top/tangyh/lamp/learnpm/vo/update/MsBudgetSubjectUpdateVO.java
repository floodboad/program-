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
 *  预算科目更新实体类
 * </p>
 *
 * @author zyq
 * @date 2022-06-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "MsBudgetSubjectUpdateVO", description = "预算科目")
public class MsBudgetSubjectUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 科目类型
     */
    @ApiModelProperty(value = "科目类型")
    @Size(max = 2, message = "科目类型长度不能超过2")  
    private  String subjectType;
    /**
     * 科目编码
     */
    @ApiModelProperty(value = "科目编码")
    @Size(max = 300, message = "科目编码长度不能超过300")  
    private  String subjectCode;
    /**
     * 科目状态
     */
    @ApiModelProperty(value = "科目状态")
    @Size(max = 2, message = "科目状态长度不能超过2")  
    private  String subjectStatus;
    /**
     * 一级科目id
     */
    @ApiModelProperty(value = "一级科目id")
    private  Long msFirstLevelSubjectId;
    /**
     * 一级科目名称
     */
    @ApiModelProperty(value = "一级科目名称")
    @Size(max = 300, message = "一级科目名称长度不能超过300")  
    private  String firstSubjectName;
    /**
     * 二级科目id
     */
    @ApiModelProperty(value = "二级科目id")
    private  Long msSecondarySubjectId;
    /**
     * 二级科目名称
     */
    @ApiModelProperty(value = "二级科目名称")
    @Size(max = 300, message = "二级科目名称长度不能超过300")  
    private  String secondarySubjectName;
    /**
     * 对外报价
     */
    @ApiModelProperty(value = "对外报价")
    private  BigDecimal externalQuotation;
    /**
     * 成本价
     */
    @ApiModelProperty(value = "成本价")
    private  BigDecimal costPrice;
    /**
     * 会议方式
     */
    @ApiModelProperty(value = "会议方式")
    @Size(max = 2, message = "会议方式长度不能超过2")  
    private  String meetingType;
    /**
     * 科目名称
     */
    @ApiModelProperty(value = "科目名称")
    @Size(max = 300, message = "科目名称长度不能超过300")  
    private  String subjectName;
    /**
     * 科目描述
     */
    @ApiModelProperty(value = "科目描述")
    @Size(max = 300, message = "科目描述长度不能超过300")  
    private  String subjectDesc;
    /**
     * 单位1
     */
    @ApiModelProperty(value = "单位1")
    @Size(max = 300, message = "单位1长度不能超过300")  
    private  String unit1;
    /**
     * 单位2
     */
    @ApiModelProperty(value = "单位2")
    @Size(max = 300, message = "单位2长度不能超过300")  
    private  String unit2;
    /**
     * 是否执行费用
     */
    @ApiModelProperty(value = "是否执行费用")
    @Size(max = 1, message = "是否执行费用长度不能超过1")  
    private  String isImplementExpenses;
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
