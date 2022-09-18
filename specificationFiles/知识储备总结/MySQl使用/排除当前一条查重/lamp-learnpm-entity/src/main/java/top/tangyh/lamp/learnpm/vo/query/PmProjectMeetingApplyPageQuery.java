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
import java.util.Date;



/**
 * <p>
 * 项目会议申请翻页查询对象
 * </p>
 *
 * @author dz
 * @date 2022-07-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmProjectMeetingApplyPageQuery", description = "项目会议申请")
public class PmProjectMeetingApplyPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long  id;
    /**
     * 会议分配id
     */
    @ApiModelProperty(value = "会议分配id")
    private Long  meetingAllocationId;
    /**
     * 会议规划id
     */
    @ApiModelProperty(value = "会议规划id")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long  pmProjectId;
    /**
     * 会议支持项目名称
     */
    @ApiModelProperty(value = "会议支持项目名称")
    private String  meetingSupportProjectName;
    /**
     * 会议编号名称
     */
    @ApiModelProperty(value = "会议编号名称")
    private String  meetingNoName;
    /**
     * 支持项目计划开始时间
     */
    @ApiModelProperty(value = "支持项目计划开始时间")
    private Date  supportProjectPlanStartTime;
    /**
     * 支持项目计划结束时间
     */
    @ApiModelProperty(value = "支持项目计划结束时间")
    private Date  supportProjectPlanEndTime;
    /**
     * 会议方式
     */
    @ApiModelProperty(value = "会议方式")
    private String  meetingMode;
    /**
     * 会议类型名称
     */
    @ApiModelProperty(value = "会议类型名称")
    private String  meetingTypeName;
    /**
     * 会议省份编码
     */
    @ApiModelProperty(value = "会议省份编码")
    private Integer  provinceCode;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String  province;
    /**
     * 会议城市编码
     */
    @ApiModelProperty(value = "会议城市编码")
    private Integer  meetingCityCode;
    /**
     * 会议城市名称
     */
    @ApiModelProperty(value = "会议城市名称")
    private String  meetingCityName;
    /**
     * 会议召开地址
     */
    @ApiModelProperty(value = "会议召开地址")
    private String  meetingAddress;
    /**
     * 会议详细地址
     */
    @ApiModelProperty(value = "会议详细地址")
    private String  meetingDetailAddress;
    /**
     * 会议经度
     */
    @ApiModelProperty(value = "会议经度")
    private BigDecimal  meetingLongitude;
    /**
     * 会议维度
     */
    @ApiModelProperty(value = "会议维度")
    private BigDecimal  meetingLatitude;
    /**
     * 参会人员数量起
     */
    @ApiModelProperty(value = "参会人员数量起")
    private Integer  minimumParticipantsNumber;
    /**
     * 参会人员数量止
     */
    @ApiModelProperty(value = "参会人员数量止")
    private Integer  maximumParticipantsNumber;
    /**
     * 现场联系人姓名
     */
    @ApiModelProperty(value = "现场联系人姓名")
    private String  siteContactName;
    /**
     * 现场联系人电话
     */
    @ApiModelProperty(value = "现场联系人电话")
    private String  siteContactPhone;
    /**
     * 会议说明
     */
    @ApiModelProperty(value = "会议说明")
    private String  meetingNote;
    /**
     * 会议总预算
     */
    @ApiModelProperty(value = "会议总预算")
    private BigDecimal  totalMeetingBudget;
    /**
     * 会议支出金额
     */
    @ApiModelProperty(value = "会议支出金额")
    private BigDecimal  meetingExpensesAmount;
    /**
     * 预算剩余金额
     */
    @ApiModelProperty(value = "预算剩余金额")
    private BigDecimal  budgetRemainingAmount;
    /**
     * 会议支出审定金额
     */
    @ApiModelProperty(value = "会议支出审定金额")
    private BigDecimal  meetingExpensesAuditAmount;
    /**
     * 会议预算执行返回金额
     */
    @ApiModelProperty(value = "会议预算执行返回金额")
    private BigDecimal  budgetExeReturnAmt;
    /**
     * 会议状态
     */
    @ApiModelProperty(value = "会议状态")
    private String  meetingStatus;
    /**
     * 会议结算状态
     */
    @ApiModelProperty(value = "会议结算状态")
    private String  meetingFinalAccountStatus;
    /**
     * 会议决算说明
     */
    @ApiModelProperty(value = "会议决算说明")
    private String  meetingFinalAccountRemark;
    /**
     * 会议决算附件
     */
    @ApiModelProperty(value = "会议决算附件")
    private String  meetingFinalAccountAttachment;
    /**
     * 会议线下支出
     */
    @ApiModelProperty(value = "会议线下支出")
    private BigDecimal  meetingOfflineExpenditure;
    /**
     * 商企通支出
     */
    @ApiModelProperty(value = "商企通支出")
    private BigDecimal  shangqitongExpenditure;
    /**
     * 顺丰支出
     */
    @ApiModelProperty(value = "顺丰支出")
    private BigDecimal  sfExpenditure;
    /**
     * 预付款支出
     */
    @ApiModelProperty(value = "预付款支出")
    private BigDecimal  prepaymentExpenditure;
    /**
     * 预约人数
     */
    @ApiModelProperty(value = "预约人数")
    private Integer  appointmentsNumber;
    /**
     * 商企通同步状态
     */
    @ApiModelProperty(value = "商企通同步状态")
    private String  shangqitongStatus;
    /**
     * 发布状态
     */
    @ApiModelProperty(value = "发布状态")
    private String  publishStatus;
    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    private Long  chargePersonId;
    /**
     * 负责人姓名
     */
    @ApiModelProperty(value = "负责人姓名")
    private String  chargePersonName;
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

