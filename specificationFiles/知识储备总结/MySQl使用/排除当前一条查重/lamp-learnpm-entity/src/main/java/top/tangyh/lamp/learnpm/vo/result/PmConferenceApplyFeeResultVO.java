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
 * 会议申请费用表实体类
 * </p>
 *
 * @author dz
 * @since 2022-07-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmConferenceApplyFeeResultVO", description = "会议申请费用表")
public class PmConferenceApplyFeeResultVO extends Entity<Long> implements Serializable, EchoVO {
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
     * 费用执行标准
     */
    @ApiModelProperty(value = "费用执行标准")
    @Excel(name = "费用执行标准")
    private String  controlStandards;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    @Excel(name = "数量")
    private Integer  num;
    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    @Excel(name = "金额")
    private BigDecimal  amountMoney;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Excel(name = "说明")
    private String  illustrate;
    /**
     * 系统已执行金额
     */
    @ApiModelProperty(value = "系统已执行金额")
    @Excel(name = "系统已执行金额")
    private BigDecimal  feeExecutedAmount;
    /**
     * 线下预算金额
     */
    @ApiModelProperty(value = "线下预算金额")
    @Excel(name = "线下预算金额")
    private BigDecimal  offlineBudgetAmount;
    /**
     * 线下已执行金额
     */
    @ApiModelProperty(value = "线下已执行金额")
    @Excel(name = "线下已执行金额")
    private BigDecimal  otherExecutionAmount;
    /**
     * 预支付金额
     */
    @ApiModelProperty(value = "预支付金额")
    @Excel(name = "预支付金额")
    private BigDecimal  consumedAmount;
    /**
     * 系统预算金额
     */
    @ApiModelProperty(value = "系统预算金额")
    @Excel(name = "系统预算金额")
    private BigDecimal  systemBudgetAmount;
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

