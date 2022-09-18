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
 * 项目信息翻页查询对象
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmProjectPageQuery", description = "项目信息")
public class PmProjectPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 立项单位id
     */
    @ApiModelProperty(value = "立项单位id")
    private Long  projectInitiationUnitId;
    /**
     * 立项单位名称
     */
    @ApiModelProperty(value = "立项单位名称")
    private String  projectInitiationUnitName;
    /**
     * 项目推荐人id
     */
    @ApiModelProperty(value = "项目推荐人id")
    private Long  projectRecommenderId;
    /**
     * 项目推荐人姓名
     */
    @ApiModelProperty(value = "项目推荐人姓名")
    private String  projectRecommenderName;
    /**
     * 立项人id
     */
    @ApiModelProperty(value = "立项人id")
    private Long  initiatorId;
    /**
     * 立项人姓名
     */
    @ApiModelProperty(value = "立项人姓名")
    private String  initiatorName;
    /**
     * 立项部门id
     */
    @ApiModelProperty(value = "立项部门id")
    private Long  projectApprovalDepartmentId;
    /**
     * 立项部门名称
     */
    @ApiModelProperty(value = "立项部门名称")
    private String  projectApprovalDepartmentName;
    /**
     * 学术指导
     */
    @ApiModelProperty(value = "学术指导")
    private String  academicGuidance;
    /**
     * 项目类别id
     */
    @ApiModelProperty(value = "项目类别id")
    private Long  projectCategoryId;
    /**
     * 项目类别名称
     */
    @ApiModelProperty(value = "项目类别名称")
    private String  projectCategoryName;
    /**
     * 项目概要
     */
    @ApiModelProperty(value = "项目概要")
    private String  projectSummary;
    /**
     * 立项客户单位id
     */
    @ApiModelProperty(value = "立项客户单位id")
    private Long  projectInitiationCustomerUnitId;
    /**
     * 立项客户名称
     */
    @ApiModelProperty(value = "立项客户名称")
    private String  projectInitiationCustomerUnitName;
    /**
     * 立项年度
     */
    @ApiModelProperty(value = "立项年度")
    private String  projectInitiationYear;
    /**
     * 客户联系人
     */
    @ApiModelProperty(value = "客户联系人")
    private String  customerContact;
    /**
     * 客户联系方式
     */
    @ApiModelProperty(value = "客户联系方式")
    private String  customerContactInfo;
    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    private String  post;
    /**
     * 第三方名称
     */
    @ApiModelProperty(value = "第三方名称")
    private String  thirdPartyName;
    /**
     * 第四方名称
     */
    @ApiModelProperty(value = "第四方名称")
    private String  fourthPartyName;
    /**
     * 项目可支配金额
     */
    @ApiModelProperty(value = "项目可支配金额")
    private BigDecimal  totalProjectAmount;
    /**
     * 项目可分配预算金额
     */
    @ApiModelProperty(value = "项目可分配预算金额")
    private BigDecimal  totalBudgetAmount;
    /**
     * 会议总场次
     */
    @ApiModelProperty(value = "会议总场次")
    private String  estimatedMeetingTotalNum;
    /**
     * 招商函
     */
    @ApiModelProperty(value = "招商函")
    private String  investmentInvitationLetter;
    /**
     * 其他
     */
    @ApiModelProperty(value = "其他")
    private String  other;
    /**
     * 附言
     */
    @ApiModelProperty(value = "附言")
    private String  postscript;
    /**
     * 会议预算已占用
     */
    @ApiModelProperty(value = "会议预算已占用")
    private BigDecimal  meetingBudgetOccupied;
    /**
     * 会议规划剩余场次
     */
    @ApiModelProperty(value = "会议规划剩余场次")
    private String  meetingSchedule;
    /**
     * 已完成场次
     */
    @ApiModelProperty(value = "已完成场次")
    private String  completedSessions;
    /**
     * 实际已支出
     */
    @ApiModelProperty(value = "实际已支出")
    private BigDecimal  actualBudgetSpent;
    /**
     * 剩余可支配金额
     */
    @ApiModelProperty(value = "剩余可支配金额")
    private BigDecimal  remainingBudgetAmount;
    /**
     * 项目状态
     */
    @ApiModelProperty(value = "项目状态")
    private String  projectStauts;
    /**
     * 会议规化状态
     */
    @ApiModelProperty(value = "会议规化状态")
    private String  meetingPlanningStatus;
    /**
     * 项目来源
     */
    @ApiModelProperty(value = "项目来源")
    private String  projectSource;
    /**
     * 合并计税金额
     */
    @ApiModelProperty(value = "合并计税金额")
    private BigDecimal  consolidatedTaxAmount;
    /**
     * 预算占用返还金额
     */
    @ApiModelProperty(value = "预算占用返还金额")
    private BigDecimal  budgetOccupationReturnAmount;
    /**
     * 调整状态
     */
    @ApiModelProperty(value = "调整状态")
    private String  adjustStatus;
    /**
     * 已规划场次
     */
    @ApiModelProperty(value = "已规划场次")
    private Integer  meetingPlanNum;
    /**
     * 已申请场次
     */
    @ApiModelProperty(value = "已申请场次")
    private Integer  appliedNum;
    /**
     * 已申请金额
     */
    @ApiModelProperty(value = "已申请金额")
    private BigDecimal  appliedAmount;
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

