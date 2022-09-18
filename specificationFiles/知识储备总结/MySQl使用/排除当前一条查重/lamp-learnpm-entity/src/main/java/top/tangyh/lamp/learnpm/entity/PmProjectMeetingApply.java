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
import java.util.Date;



/**
 * <p>
 * 项目会议申请实体类
 * </p>
 *
 * @author dz
 * @date 2022-07-05
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_PROJECT_MEETING_APPLY")
@AllArgsConstructor
@Builder
public class PmProjectMeetingApply extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 会议分配id 
     */
     @TableField(value = "MEETING_ALLOCATION_ID ", condition = LIKE)
    private Long meetingAllocationId;
    /**
     * 会议规划id 
     */
     @TableField(value = "PM_PROJECT_MEETING_PLANNING_ID ", condition = LIKE)
    private Long pmProjectMeetingPlanningId;
    /**
     * 项目id 
     */
     @TableField(value = "PM_PROJECT_ID ", condition = LIKE)
    private Long pmProjectId;
    /**
     * 会议支持项目名称 
     */
     @TableField(value = "MEETING_SUPPORT_PROJECT_NAME ", condition = LIKE)
    private String meetingSupportProjectName;
    /**
     * 会议编号名称 
     */
     @TableField(value = "MEETING_NO_NAME ", condition = LIKE)
    private String meetingNoName;
    /**
     * 支持项目计划开始时间 
     */
     @TableField(value = "SUPPORT_PROJECT_PLAN_START_TIME ", condition = LIKE)
    private Date supportProjectPlanStartTime;
    /**
     * 支持项目计划结束时间 
     */
     @TableField(value = "SUPPORT_PROJECT_PLAN_END_TIME ", condition = LIKE)
    private Date supportProjectPlanEndTime;
    /**
     * 会议方式 
     */
     @TableField(value = "MEETING_MODE ", condition = LIKE)
    private String meetingMode;
    /**
     * 会议类型名称 
     */
     @TableField(value = "MEETING_TYPE_NAME ", condition = LIKE)
    private String meetingTypeName;
    /**
     * 会议省份编码 
     */
     @TableField(value = "PROVINCE_CODE ", condition = LIKE)
    private Integer provinceCode;
    /**
     * 省份 
     */
     @TableField(value = "PROVINCE ", condition = LIKE)
    private String province;
    /**
     * 会议城市编码 
     */
     @TableField(value = "MEETING_CITY_CODE ", condition = LIKE)
    private Integer meetingCityCode;
    /**
     * 会议城市名称 
     */
     @TableField(value = "MEETING_CITY_NAME ", condition = LIKE)
    private String meetingCityName;
    /**
     * 会议召开地址 
     */
     @TableField(value = "MEETING_ADDRESS ", condition = LIKE)
    private String meetingAddress;
    /**
     * 会议详细地址 
     */
     @TableField(value = "MEETING_DETAIL_ADDRESS ", condition = LIKE)
    private String meetingDetailAddress;
    /**
     * 会议经度 
     */
     @TableField(value = "MEETING_LONGITUDE ", condition = LIKE)
    private BigDecimal meetingLongitude;
    /**
     * 会议维度 
     */
     @TableField(value = "MEETING_LATITUDE ", condition = LIKE)
    private BigDecimal meetingLatitude;
    /**
     * 参会人员数量起 
     */
     @TableField(value = "MINIMUM_PARTICIPANTS_NUMBER ", condition = LIKE)
    private Integer minimumParticipantsNumber;
    /**
     * 参会人员数量止 
     */
     @TableField(value = "MAXIMUM_PARTICIPANTS_NUMBER ", condition = LIKE)
    private Integer maximumParticipantsNumber;
    /**
     * 现场联系人姓名 
     */
     @TableField(value = "SITE_CONTACT_NAME ", condition = LIKE)
    private String siteContactName;
    /**
     * 现场联系人电话 
     */
     @TableField(value = "SITE_CONTACT_PHONE ", condition = LIKE)
    private String siteContactPhone;
    /**
     * 会议说明 
     */
     @TableField(value = "MEETING_NOTE ", condition = LIKE)
    private String meetingNote;
    /**
     * 会议总预算 
     */
     @TableField(value = "TOTAL_MEETING_BUDGET ", condition = LIKE)
    private BigDecimal totalMeetingBudget;
    /**
     * 会议支出金额 
     */
     @TableField(value = "MEETING_EXPENSES_AMOUNT ", condition = LIKE)
    private BigDecimal meetingExpensesAmount;
    /**
     * 预算剩余金额 
     */
     @TableField(value = "BUDGET_REMAINING_AMOUNT ", condition = LIKE)
    private BigDecimal budgetRemainingAmount;
    /**
     * 会议支出审定金额 
     */
     @TableField(value = "MEETING_EXPENSES_AUDIT_AMOUNT ", condition = LIKE)
    private BigDecimal meetingExpensesAuditAmount;
    /**
     * 会议预算执行返回金额 
     */
     @TableField(value = "BUDGET_EXE_RETURN_AMT ", condition = LIKE)
    private BigDecimal budgetExeReturnAmt;
    /**
     * 会议状态 
     */
     @TableField(value = "MEETING_STATUS ", condition = LIKE)
    private String meetingStatus;
    /**
     * 会议结算状态 
     */
     @TableField(value = "MEETING_FINAL_ACCOUNT_STATUS ", condition = LIKE)
    private String meetingFinalAccountStatus;
    /**
     * 会议决算说明 
     */
     @TableField(value = "MEETING_FINAL_ACCOUNT_REMARK ", condition = LIKE)
    private String meetingFinalAccountRemark;
    /**
     * 会议决算附件 
     */
     @TableField(value = "MEETING_FINAL_ACCOUNT_ATTACHMENT ", condition = LIKE)
    private String meetingFinalAccountAttachment;
    /**
     * 会议线下支出 
     */
     @TableField(value = "MEETING_OFFLINE_EXPENDITURE ", condition = LIKE)
    private BigDecimal meetingOfflineExpenditure;
    /**
     * 商企通支出 
     */
     @TableField(value = "SHANGQITONG_EXPENDITURE ", condition = LIKE)
    private BigDecimal shangqitongExpenditure;
    /**
     * 顺丰支出 
     */
     @TableField(value = "SF_EXPENDITURE ", condition = LIKE)
    private BigDecimal sfExpenditure;
    /**
     * 预付款支出 
     */
     @TableField(value = "PREPAYMENT_EXPENDITURE ", condition = LIKE)
    private BigDecimal prepaymentExpenditure;
    /**
     * 预约人数 
     */
     @TableField(value = "APPOINTMENTS_NUMBER ", condition = LIKE)
    private Integer appointmentsNumber;
    /**
     * 商企通同步状态 
     */
     @TableField(value = "SHANGQITONG_STATUS ", condition = LIKE)
    private String shangqitongStatus;
    /**
     * 发布状态 
     */
     @TableField(value = "PUBLISH_STATUS ", condition = LIKE)
    private String publishStatus;
    /**
     * 负责人id 
     */
     @TableField(value = "CHARGE_PERSON_ID ", condition = LIKE)
    private Long chargePersonId;
    /**
     * 负责人姓名 
     */
     @TableField(value = "CHARGE_PERSON_NAME ", condition = LIKE)
    private String chargePersonName;
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
