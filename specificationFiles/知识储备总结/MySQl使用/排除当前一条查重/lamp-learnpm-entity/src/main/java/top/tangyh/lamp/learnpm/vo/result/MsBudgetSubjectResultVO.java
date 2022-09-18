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
 * 预算科目实体类
 * </p>
 *
 * @author zyq
 * @since 2022-06-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "MsBudgetSubjectResultVO", description = "预算科目")
public class MsBudgetSubjectResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 科目类型
     */
    @ApiModelProperty(value = "科目类型")
    @Excel(name = "科目类型")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.SUBJECT_TYPE)
    private String  subjectType;
    /**
     * 科目编码
     */
    @ApiModelProperty(value = "科目编码")
    @Excel(name = "科目编码")
    private String  subjectCode;
    /**
     * 科目状态
     */
    @ApiModelProperty(value = "科目状态")
    @Excel(name = "科目状态")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.SUBJECT_STATUS)
    private String  subjectStatus;
    /**
     * 一级科目id
     */
    @ApiModelProperty(value = "一级科目id")
    @Excel(name = "一级科目id")
    private Long  msFirstLevelSubjectId;
    /**
     * 一级科目名称
     */
    @ApiModelProperty(value = "一级科目名称")
    @Excel(name = "一级科目名称")
    private String  firstSubjectName;
    /**
     * 二级科目id
     */
    @ApiModelProperty(value = "二级科目id")
    @Excel(name = "二级科目id")
    private Long  msSecondarySubjectId;
    /**
     * 二级科目名称
     */
    @ApiModelProperty(value = "二级科目名称")
    @Excel(name = "二级科目名称")
    private String  secondarySubjectName;
    /**
     * 对外报价
     */
    @ApiModelProperty(value = "对外报价")
    @Excel(name = "对外报价")
    private BigDecimal  externalQuotation;
    /**
     * 成本价
     */
    @ApiModelProperty(value = "成本价")
    @Excel(name = "成本价")
    private BigDecimal  costPrice;
    /**
     * 会议方式
     */
    @ApiModelProperty(value = "会议方式")
    @Excel(name = "会议方式")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.MEETING_TYPE)
    private String  meetingType;
    /**
     * 科目名称
     */
    @ApiModelProperty(value = "科目名称")
    @Excel(name = "科目名称")
    private String  subjectName;
    /**
     * 科目描述
     */
    @ApiModelProperty(value = "科目描述")
    @Excel(name = "科目描述")
    private String  subjectDesc;
    /**
     * 单位1
     */
    @ApiModelProperty(value = "单位1")
    @Excel(name = "单位1")
    private String  unit1;
    /**
     * 单位2
     */
    @ApiModelProperty(value = "单位2")
    @Excel(name = "单位2")
    private String  unit2;
    /**
     * 是否执行费用
     */
    @ApiModelProperty(value = "是否执行费用")
    @Excel(name = "是否执行费用")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isImplementExpenses;
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

