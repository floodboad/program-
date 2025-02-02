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
 * 会议规划分配实体类
 * </p>
 *
 * @author zhaoxl
 * @since 2022-07-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmMeetingPlanAllocationResultVO", description = "会议规划分配")
public class PmMeetingPlanAllocationResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 项目会议规划ID
     */
    @ApiModelProperty(value = "项目会议规划ID")
    @Excel(name = "项目会议规划ID")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 会议规划分配名称
     */
    @ApiModelProperty(value = "会议规划分配名称")
    @Excel(name = "会议规划分配名称")
    private String  allocationName;
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
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    @Excel(name = "项目会议规划名称")
    private String  projectMeetingPlanningName;
    /**
     * 会议方式
     */
    @ApiModelProperty(value = "会议方式")
    @Excel(name = "会议方式")
    private String  meetingMode;
    /**
     * 会议类型id
     */
    @ApiModelProperty(value = "会议类型id")
    @Excel(name = "会议类型id")
    private Long  msLongzhuMeetingTypeId;
    /**
     * 会议类型名称
     */
    @ApiModelProperty(value = "会议类型名称")
    @Excel(name = "会议类型名称")
    private String  meetingTypeName;
    /**
     * 执行场次数量
     */
    @ApiModelProperty(value = "执行场次数量")
    @Excel(name = "执行场次数量")
    private Integer  executionSessionsNumber;
    /**
     * 会议总预算
     */
    @ApiModelProperty(value = "会议总预算")
    @Excel(name = "会议总预算")
    private BigDecimal  totalMeetingBudget;
    /**
     * 会议省份编码
     */
    @ApiModelProperty(value = "会议省份编码")
    @Excel(name = "会议省份编码")
    private Integer  provinceCode;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    @Excel(name = "省份")
    private String  province;
    /**
     * 会议城市编码
     */
    @ApiModelProperty(value = "会议城市编码")
    @Excel(name = "会议城市编码")
    private Integer  cityCode;
    /**
     * 会议地址
     */
    @ApiModelProperty(value = "会议地址")
    @Excel(name = "会议地址")
    private String  meetingAddress;
    /**
     * 会议详细地址
     */
    @ApiModelProperty(value = "会议详细地址")
    @Excel(name = "会议详细地址")
    private String  meetingDetailAddress;
    /**
     * 会议经度
     */
    @ApiModelProperty(value = "会议经度")
    @Excel(name = "会议经度")
    private BigDecimal  meetingLongitude;
    /**
     * 会议维度
     */
    @ApiModelProperty(value = "会议维度")
    @Excel(name = "会议维度")
    private BigDecimal  meetingLatitude;
    /**
     * 会议城市名称
     */
    @ApiModelProperty(value = "会议城市名称")
    @Excel(name = "会议城市名称")
    private String  meetingCity;
    /**
     * 预算总金额
     */
    @ApiModelProperty(value = "预算总金额")
    @Excel(name = "预算总金额")
    private BigDecimal  totalBudgetAmount;
    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    @Excel(name = "负责人id")
    private Long  chargePersonId;
    /**
     * 负责人姓名
     */
    @ApiModelProperty(value = "负责人姓名")
    @Excel(name = "负责人姓名")
    private String  chargePersonName;
    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    @Excel(name = "负责人手机号")
    private String  phone;
    /**
     * 参会人员数量起
     */
    @ApiModelProperty(value = "参会人员数量起")
    @Excel(name = "参会人员数量起")
    private Integer  minimumParticipantsNumber;
    /**
     * 参会人员数量止
     */
    @ApiModelProperty(value = "参会人员数量止")
    @Excel(name = "参会人员数量止")
    private Integer  maximumParticipantsNumber;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Excel(name = "说明")
    private String  illustrate;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    @Excel(name = "附件")
    private String  attachment;
    /**
     * 已结算金额
     */
    @ApiModelProperty(value = "已结算金额")
    @Excel(name = "已结算金额")
    private BigDecimal  settlementAmount;
    /**
     * 已执行金额
     */
    @ApiModelProperty(value = "已执行金额")
    @Excel(name = "已执行金额")
    private BigDecimal  performAmount;
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

