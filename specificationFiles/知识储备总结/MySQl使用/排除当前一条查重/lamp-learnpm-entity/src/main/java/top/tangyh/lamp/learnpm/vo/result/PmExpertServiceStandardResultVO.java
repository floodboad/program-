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
import top.tangyh.lamp.model.constant.EchoDictType;
import top.tangyh.lamp.model.constant.EchoApi;
import top.tangyh.basic.annotation.echo.Echo;
import java.math.BigDecimal;


/**
 * <p>
 * 会议规划专家劳务标准实体类
 * </p>
 *
 * @author zhaoxl
 * @since 2022-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmExpertServiceStandardResultVO", description = "会议规划专家劳务标准")
public class PmExpertServiceStandardResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
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
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    @Excel(name = "项目会议规划id")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    @Excel(name = "项目会议规划名称")
    private String  projectMeetingPlanningName;
    /**
     * 费用id
     */
    @ApiModelProperty(value = "费用id")
    @Excel(name = "费用id")
    private Long  msBudgetSubjectId;
    /**
     * 费用名称
     */
    @ApiModelProperty(value = "费用名称")
    @Excel(name = "费用名称")
    private String  feeName;
    /**
     * 人数
     */
    @ApiModelProperty(value = "人数")
    @Excel(name = "人数")
    private Long  personNumber;
    /**
     * 劳务税费
     */
    @ApiModelProperty(value = "劳务税费")
    @Excel(name = "劳务税费")
    private BigDecimal  serviceTax;
    /**
     * 专家类型
     */
    @ApiModelProperty(value = "专家类型")
    @Excel(name = "专家类型")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.EXPERT_TYPE)
    private String  expertType;
    /**
     * 扣税支出
     */
    @ApiModelProperty(value = "扣税支出")
    @Excel(name = "扣税支出")
    private BigDecimal  actualPay;
    /**
     * 执行标准
     */
    @ApiModelProperty(value = "执行标准")
    @Excel(name = "执行标准")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.EXECUTIVE_STANDARD)
    private String  executiveStandard;
    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    @Excel(name = "金额")
    private BigDecimal  amountMoney;
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

