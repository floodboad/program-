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
 * 项目会议规划调整实体类
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_PROJECT_MEETING_PLAN_ADJUST")
@AllArgsConstructor
@Builder
public class PmProjectMeetingPlanAdjust extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目规划调整记录id 
     */
     @TableField(value = "PM_PROJECT_PLAN_ADJUST_RECORD_ID ", condition = LIKE)
    private Long pmProjectPlanAdjustRecordId;
    /**
     * 项目id 
     */
     @TableField(value = "PM_PROJECT_ID ", condition = LIKE)
    private Long pmProjectId;
    /**
     * 项目名称 
     */
     @TableField(value = "PROJECT_NAME ", condition = LIKE)
    private String projectName;
    /**
     * 会议规划id 
     */
     @TableField(value = "PM_PROJECT_MEETING_PLANNING_ID ", condition = LIKE)
    private Long pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称 
     */
     @TableField(value = "PROJECT_MEETING_PLANNING_NAME ", condition = LIKE)
    private String projectMeetingPlanningName;
    /**
     * 会议方式 
     */
     @TableField(value = "MEETING_MODE ", condition = LIKE)
    private String meetingMode;
    /**
     * 会议类型id 
     */
     @TableField(value = "MS_LONGZHU_MEETING_TYPE_ID ", condition = LIKE)
    private Long msLongzhuMeetingTypeId;
    /**
     * 会议类型名称 
     */
     @TableField(value = "MEETING_TYPE ", condition = LIKE)
    private String meetingType;
    /**
     * 原执行场次数量 
     */
     @TableField(value = "OLD_EXECUTION_SESSIONS_NUMBER ", condition = LIKE)
    private Integer oldExecutionSessionsNumber;
    /**
     * 调整场次数量 
     */
     @TableField(value = "ADJUST_EXECUTION_SESSIONS_NUMBER ", condition = LIKE)
    private Integer adjustExecutionSessionsNumber;
    /**
     * 现未执行场次数量 
     */
     @TableField(value = "NOW_EXECUTION_SESSIONS_NUMBER ", condition = LIKE)
    private Integer nowExecutionSessionsNumber;
    /**
     * 原单场会议费标准 
     */
     @TableField(value = "MEETING_FEE_STANDARD ", condition = LIKE)
    private BigDecimal meetingFeeStandard;
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
     @TableField(value = "CITY_CODE ", condition = LIKE)
    private Integer cityCode;
    /**
     * 会议城市名称 
     */
     @TableField(value = "MEETING_CITY ", condition = LIKE)
    private String meetingCity;
    /**
     * 会议区县编码 
     */
     @TableField(value = "MEETING_DISTRICT_COUNTY_CODE ", condition = LIKE)
    private Integer meetingDistrictCountyCode;
    /**
     * 会议区县名称 
     */
     @TableField(value = "MEETING_DISTRICT_COUNTY_NAME ", condition = LIKE)
    private String meetingDistrictCountyName;
    /**
     * 原分配预算总金额 
     */
     @TableField(value = "TOTAL_BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal totalBudgetAmount;
    /**
     * 调整预算金额 
     */
     @TableField(value = "OLD_TOTAL_BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal oldTotalBudgetAmount;
    /**
     * 调整后预算总金额 
     */
     @TableField(value = "ADJUST_TOTAL_BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal adjustTotalBudgetAmount;
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
     * 负责人手机号 
     */
     @TableField(value = "PHONE ", condition = LIKE)
    private String phone;
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
     * 说明 
     */
     @TableField(value = "ILLUSTRATE ", condition = LIKE)
    private String illustrate;
    /**
     * 附件 
     */
     @TableField(value = "ATTACHMENT ", condition = LIKE)
    private String attachment;
    /**
     * 单场会议费标准 
     */
     @TableField(value = "MEETING_FEE_STANDARD2 ", condition = LIKE)
    private BigDecimal meetingFeeStandard2;
    /**
     * 已申请场次 
     */
     @TableField(value = "OPENED_TIMES ", condition = LIKE)
    private Integer openedTimes;
    /**
     * 其中原每场专家劳务费用 
     */
     @TableField(value = "IN_LABOR_COST_OF_EACH_EXPERT ", condition = LIKE)
    private BigDecimal inLaborCostOfEachExpert;
    /**
     * 其中现每场专家劳务费用 
     */
     @TableField(value = "IN_CURRENT_EXPERT_SERVICE_FEE ", condition = LIKE)
    private BigDecimal inCurrentExpertServiceFee;
    /**
     * 其中原会议执行费用 
     */
     @TableField(value = "IN_ORIGINAL_MEETING_EXECUTION_COST ", condition = LIKE)
    private BigDecimal inOriginalMeetingExecutionCost;
    /**
     * 其中现会议执行费用 
     */
     @TableField(value = "IN_CURRENT_MEETING_EXEC_COST ", condition = LIKE)
    private BigDecimal inCurrentMeetingExecCost;
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
