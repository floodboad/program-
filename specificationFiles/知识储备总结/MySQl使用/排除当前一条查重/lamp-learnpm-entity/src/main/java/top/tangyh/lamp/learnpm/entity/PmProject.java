package top.tangyh.lamp.learnpm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.Entity;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;
import java.math.BigDecimal;


/**
 * <p>
 * 项目信息实体类
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-07
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_PROJECT")
@AllArgsConstructor
@Builder
public class PmProject extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目名称 
     */
     @TableField(value = "PROJECT_NAME ", condition = LIKE)
    private String projectName;
    /**
     * 项目号 
     */
     @TableField(value = "PROJECT_CODE ", condition = LIKE)
    private String projectCode;
    /**
     * 立项单位id 
     */
     @TableField(value = "PROJECT_INITIATION_UNIT_ID ", condition = LIKE)
    private Long projectInitiationUnitId;
    /**
     * 立项单位名称 
     */
     @TableField(value = "PROJECT_INITIATION_UNIT_NAME ", condition = LIKE)
    private String projectInitiationUnitName;
    /**
     * 项目推荐人id 
     */
     @TableField(value = "PROJECT_RECOMMENDER_ID ", condition = LIKE)
    private Long projectRecommenderId;
    /**
     * 项目推荐人姓名 
     */
     @TableField(value = "PROJECT_RECOMMENDER_NAME ", condition = LIKE)
    private String projectRecommenderName;
    /**
     * 立项人id 
     */
     @TableField(value = "INITIATOR_ID ", condition = LIKE)
    private Long initiatorId;
    /**
     * 立项人姓名 
     */
     @TableField(value = "INITIATOR_NAME ", condition = LIKE)
    private String initiatorName;
    /**
     * 立项部门id 
     */
     @TableField(value = "PROJECT_APPROVAL_DEPARTMENT_ID ", condition = LIKE)
    private Long projectApprovalDepartmentId;
    /**
     * 立项部门名称 
     */
     @TableField(value = "PROJECT_APPROVAL_DEPARTMENT_NAME ", condition = LIKE)
    private String projectApprovalDepartmentName;
    /**
     * 学术指导 
     */
     @TableField(value = "ACADEMIC_GUIDANCE ", condition = LIKE)
    private String academicGuidance;
    /**
     * 项目类别id 
     */
     @TableField(value = "PROJECT_CATEGORY_ID ", condition = LIKE)
    private Long projectCategoryId;
    /**
     * 项目类别名称 
     */
     @TableField(value = "PROJECT_CATEGORY_NAME ", condition = LIKE)
    private String projectCategoryName;
    /**
     * 项目概要 
     */
     @TableField(value = "PROJECT_SUMMARY ", condition = LIKE)
    private String projectSummary;
    /**
     * 立项客户单位id 
     */
     @TableField(value = "PROJECT_INITIATION_CUSTOMER_UNIT_ID ", condition = LIKE)
    private Long projectInitiationCustomerUnitId;
    /**
     * 立项客户名称 
     */
     @TableField(value = "PROJECT_INITIATION_CUSTOMER_UNIT_NAME ", condition = LIKE)
    private String projectInitiationCustomerUnitName;
    /**
     * 立项年度 
     */
     @TableField(value = "PROJECT_INITIATION_YEAR ", condition = LIKE)
    private String projectInitiationYear;
    /**
     * 客户联系人 
     */
     @TableField(value = "CUSTOMER_CONTACT ", condition = LIKE)
    private String customerContact;
    /**
     * 客户联系方式 
     */
     @TableField(value = "CUSTOMER_CONTACT_INFO ", condition = LIKE)
    private String customerContactInfo;
    /**
     * 职务 
     */
     @TableField(value = "POST ", condition = LIKE)
    private String post;
    /**
     * 第三方名称 
     */
     @TableField(value = "THIRD_PARTY_NAME ", condition = LIKE)
    private String thirdPartyName;
    /**
     * 第四方名称 
     */
     @TableField(value = "FOURTH_PARTY_NAME ", condition = LIKE)
    private String fourthPartyName;
    /**
     * 项目可支配金额 
     */
     @TableField(value = "TOTAL_PROJECT_AMOUNT ", condition = LIKE)
    private BigDecimal totalProjectAmount;
    /**
     * 项目可分配预算金额 
     */
     @TableField(value = "TOTAL_BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal totalBudgetAmount;
    /**
     * 会议总场次 
     */
     @TableField(value = "ESTIMATED_MEETING_TOTAL_NUM ", condition = LIKE)
    private String estimatedMeetingTotalNum;
    /**
     * 招商函 
     */
     @TableField(value = "INVESTMENT_INVITATION_LETTER ", condition = LIKE)
    private String investmentInvitationLetter;
    /**
     * 其他 
     */
     @TableField(value = "OTHER ", condition = LIKE)
    private String other;
    /**
     * 附言 
     */
     @TableField(value = "POSTSCRIPT ", condition = LIKE)
    private String postscript;
    /**
     * 会议预算已占用 
     */
     @TableField(value = "MEETING_BUDGET_OCCUPIED ", condition = LIKE)
    private BigDecimal meetingBudgetOccupied;
    /**
     * 会议规划剩余场次 
     */
     @TableField(value = "MEETING_SCHEDULE ", condition = LIKE)
    private String meetingSchedule;
    /**
     * 已完成场次 
     */
     @TableField(value = "COMPLETED_SESSIONS ", condition = LIKE)
    private String completedSessions;
    /**
     * 实际已支出 
     */
     @TableField(value = "ACTUAL_BUDGET_SPENT ", condition = LIKE)
    private BigDecimal actualBudgetSpent;
    /**
     * 剩余可支配金额 
     */
     @TableField(value = "REMAINING_BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal remainingBudgetAmount;
    /**
     * 项目状态 
     */
     @TableField(value = "PROJECT_STAUTS ", condition = LIKE)
    private String projectStauts;
    /**
     * 会议规化状态 
     */
     @TableField(value = "MEETING_PLANNING_STATUS ", condition = LIKE)
    private String meetingPlanningStatus;
    /**
     * 项目来源 
     */
     @TableField(value = "PROJECT_SOURCE ", condition = LIKE)
    private String projectSource;
    /**
     * 合并计税金额 
     */
     @TableField(value = "CONSOLIDATED_TAX_AMOUNT ", condition = LIKE)
    private BigDecimal consolidatedTaxAmount;
    /**
     * 预算占用返还金额 
     */
     @TableField(value = "BUDGET_OCCUPATION_RETURN_AMOUNT ", condition = LIKE)
    private BigDecimal budgetOccupationReturnAmount;
    /**
     * 调整状态 
     */
     @TableField(value = "ADJUST_STATUS ", condition = LIKE)
    private String adjustStatus;
    /**
     * 已规划场次 
     */
     @TableField(value = "MEETING_PLAN_NUM ", condition = LIKE)
    private Integer meetingPlanNum;
    /**
     * 已申请场次 
     */
     @TableField(value = "APPLIED_NUM ", condition = LIKE)
    private Integer appliedNum;
    /**
     * 已申请金额 
     */
     @TableField(value = "APPLIED_AMOUNT ", condition = LIKE)
    private BigDecimal appliedAmount;
    /**
     * 扩展字段1 
     */
     @TableField(value = "ATTRIBUTE1 ", condition = LIKE)
    private String attribute1;
    /**
     * 扩展字段2 
     */
     @TableField(value = "ATTRIBUTE2 ", condition = LIKE)
    private String attribute2;
    /**
     * 扩展字段3 
     */
     @TableField(value = "ATTRIBUTE3 ", condition = LIKE)
    private String attribute3;
    /**
     * 扩展字段4 
     */
     @TableField(value = "ATTRIBUTE4 ", condition = LIKE)
    private String attribute4;
    /**
     * 扩展字段5 
     */
     @TableField(value = "ATTRIBUTE5 ", condition = LIKE)
    private String attribute5;
    /**
     * 扩展字段6 
     */
     @TableField(value = "ATTRIBUTE6 ", condition = LIKE)
    private String attribute6;
    /**
     * 扩展字段7 
     */
     @TableField(value = "ATTRIBUTE7 ", condition = LIKE)
    private String attribute7;
    /**
     * 扩展字段8 
     */
     @TableField(value = "ATTRIBUTE8 ", condition = LIKE)
    private String attribute8;
    /**
     * 扩展字段9 
     */
     @TableField(value = "ATTRIBUTE9 ", condition = LIKE)
    private String attribute9;
    /**
     * 扩展字段10 
     */
     @TableField(value = "ATTRIBUTE10 ", condition = LIKE)
    private String attribute10;

}
