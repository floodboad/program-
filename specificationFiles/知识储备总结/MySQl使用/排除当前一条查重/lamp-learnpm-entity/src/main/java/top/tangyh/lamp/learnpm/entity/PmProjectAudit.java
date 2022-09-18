package top.tangyh.lamp.learnpm.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import top.tangyh.basic.base.entity.Entity;
import top.tangyh.lamp.learnpm.vo.save.PmComplianceMaterialsSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectSponsorSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectStakeholderSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingPlanningUpdateVO;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;



/**
 * <p>
 * 项目信息实体类
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Data
@NoArgsConstructor
public class PmProjectAudit extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    @Size(max = 300, message = "项目名称长度不能超过300")
    private String   projectName;
    /**
     * 项目号
     */
    @ApiModelProperty(value = "项目号")
    @Size(max = 300, message = "项目号长度不能超过300")
    private String   projectCode;
    /**
     * 立项单位id
     */
    @ApiModelProperty(value = "立项单位id")
    private Long   projectInitiationUnitId;
    /**
     * 立项单位名称
     */
    @ApiModelProperty(value = "立项单位名称")
    private String   projectInitiationUnitName;
    /**
     * 项目推荐人id
     */
    @ApiModelProperty(value = "项目推荐人id")
    private Long   projectRecommenderId;
    /**
     * 项目推荐人姓名
     */
    @ApiModelProperty(value = "项目推荐人姓名")
    @Size(max = 200, message = "项目推荐人姓名长度不能超过200")
    private String   projectRecommenderName;
    /**
     * 立项人id
     */
    @ApiModelProperty(value = "立项人id")
    private Long   initiatorId;
    /**
     * 立项人姓名
     */
    @ApiModelProperty(value = "立项人姓名")
    @Size(max = 200, message = "立项人姓名长度不能超过200")
    private String   initiatorName;
    /**
     * 立项部门id
     */
    @ApiModelProperty(value = "立项部门id")
    private Long   projectApprovalDepartmentId;
    /**
     * 立项部门名称
     */
    @ApiModelProperty(value = "立项部门名称")
    @Size(max = 300, message = "立项部门名称长度不能超过300")
    private String   projectApprovalDepartmentName;
    /**
     * 学术指导
     */
    @ApiModelProperty(value = "学术指导")
    @Size(max = 300, message = "学术指导长度不能超过300")
    private String   academicGuidance;
    /**
     * 项目类别id
     */
    @ApiModelProperty(value = "项目类别id")
    private Long   projectCategoryId;
    /**
     * 项目类别名称
     */
    @ApiModelProperty(value = "项目类别名称")
    @Size(max = 300, message = "项目类别名称长度不能超过300")
    private String   projectCategoryName;
    /**
     * 项目概要
     */
    @ApiModelProperty(value = "项目概要")
    @Size(max = 300, message = "项目概要长度不能超过300")
    private String   projectSummary;
    /**
     * 立项客户单位id
     */
    @ApiModelProperty(value = "立项客户单位id")
    private Long   projectInitiationCustomerUnitId;
    /**
     * 立项客户名称
     */
    @ApiModelProperty(value = "立项客户名称")
    @Size(max = 300, message = "立项客户名称长度不能超过300")
    private String   projectInitiationCustomerUnitName;
    /**
     * 立项年度
     */
    @ApiModelProperty(value = "立项年度")
    @Size(max = 300, message = "立项年度长度不能超过300")
    private String   projectInitiationYear;
    /**
     * 客户联系人
     */
    @ApiModelProperty(value = "客户联系人")
    @Size(max = 200, message = "客户联系人长度不能超过200")
    private String   customerContact;
    /**
     * 客户联系方式
     */
    @ApiModelProperty(value = "客户联系方式")
    @Size(max = 20, message = "客户联系方式长度不能超过20")
    private String   customerContactInfo;
    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    @Size(max = 300, message = "职务长度不能超过300")
    private String   post;
    /**
     * 第三方名称
     */
    @ApiModelProperty(value = "第三方名称")
    @Size(max = 300, message = "第三方名称长度不能超过300")
    private String   thirdPartyName;
    /**
     * 第四方名称
     */
    @ApiModelProperty(value = "第四方名称")
    @Size(max = 300, message = "第四方名称长度不能超过300")
    private String   fourthPartyName;
    /**
     * 项目可支配金额
     */
    @ApiModelProperty(value = "项目可支配金额")
    private BigDecimal totalProjectAmount;
    /**
     * 项目可分配预算金额
     */
    @ApiModelProperty(value = "项目可分配预算金额")
    private BigDecimal   totalBudgetAmount;
    /**
     * 会议总场次
     */
    @ApiModelProperty(value = "会议总场次")
    @Size(max = 300, message = "会议总场次长度不能超过300")
    private String   estimatedMeetingTotalNum;
    /**
     * 招商函
     */
    @ApiModelProperty(value = "招商函")
    @Size(max = 300, message = "招商函长度不能超过300")
    private String   investmentInvitationLetter;
    /**
     * 其他
     */
    @ApiModelProperty(value = "其他")
    @Size(max = 300, message = "其他长度不能超过300")
    private String   other;
    /**
     * 附言
     */
    @ApiModelProperty(value = "附言")
    @Size(max = 300, message = "附言长度不能超过300")
    private String   postscript;
    /**
     * 会议预算已占用
     */
    @ApiModelProperty(value = "会议预算已占用")
    private BigDecimal   meetingBudgetOccupied;
    /**
     * 会议规划剩余场次
     */
    @ApiModelProperty(value = "会议规划剩余场次")
    @Size(max = 300, message = "会议规划剩余场次长度不能超过300")
    private String   meetingSchedule;
    /**
     * 已完成场次
     */
    @ApiModelProperty(value = "已完成场次")
    @Size(max = 300, message = "已完成场次长度不能超过300")
    private String   completedSessions;
    /**
     * 实际已支出
     */
    @ApiModelProperty(value = "实际已支出")
    private BigDecimal   actualBudgetSpent;
    /**
     * 剩余可支配金额
     */
    @ApiModelProperty(value = "剩余可支配金额")
    private BigDecimal   remainingBudgetAmount;
    /**
     * 项目状态
     */
    @ApiModelProperty(value = "项目状态")
    @Size(max = 2, message = "项目状态长度不能超过2")
    private String   projectStauts;
    /**
     * 会议规化状态
     */
    @ApiModelProperty(value = "会议规化状态")
    @Size(max = 2, message = "会议规化状态长度不能超过2")
    private String   meetingPlanningStatus;
    /**
     * 项目来源
     */
    @ApiModelProperty(value = "项目来源")
    @Size(max = 2, message = "项目来源长度不能超过2")
    private String   projectSource;
    /**
     * 合并计税金额
     */
    @ApiModelProperty(value = "合并计税金额")
    private BigDecimal   consolidatedTaxAmount;
    /**
     * 预算占用返还金额
     */
    @ApiModelProperty(value = "预算占用返还金额")
    private BigDecimal   budgetOccupationReturnAmount;
    /**
     * 调整状态
     */
    private String   adjustStatus;

    //项目赞助企业列表
    private List<PmProjectSponsorSaveVO> pmProjectSponsorPmProjectIdInsertList;
    //项目干系人列表
    private List<PmProjectStakeholderSaveVO> pmProjectStakeholderPmProjectIdInsertList;
    //项目合规材料列表
    private List<PmComplianceMaterialsSaveVO> pmComplianceMaterialsPmProjectIdInsertList;
    //规划信息
    private List<PmProjectMeetingPlanningUpdateVO> PlanningVOS;

}
