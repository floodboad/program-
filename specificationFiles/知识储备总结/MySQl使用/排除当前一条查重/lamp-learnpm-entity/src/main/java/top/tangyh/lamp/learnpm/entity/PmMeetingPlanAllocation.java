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
 * 会议规划分配实体类
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
@TableName("PM_MEETING_PLAN_ALLOCATION")
@AllArgsConstructor
@Builder
public class PmMeetingPlanAllocation extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议规划ID 
     */
     @TableField(value = "PM_PROJECT_MEETING_PLANNING_ID ", condition = LIKE)
    private Long pmProjectMeetingPlanningId;
    /**
     * 会议规划分配名称 
     */
     @TableField(value = "ALLOCATION_NAME ", condition = LIKE)
    private String allocationName;
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
     @TableField(value = "MEETING_TYPE_NAME ", condition = LIKE)
    private String meetingTypeName;
    /**
     * 执行场次数量 
     */
     @TableField(value = "EXECUTION_SESSIONS_NUMBER ", condition = LIKE)
    private Integer executionSessionsNumber;
    /**
     * 会议总预算 
     */
     @TableField(value = "TOTAL_MEETING_BUDGET ", condition = LIKE)
    private BigDecimal totalMeetingBudget;
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
     * 会议地址 
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
     * 会议城市名称 
     */
     @TableField(value = "MEETING_CITY ", condition = LIKE)
    private String meetingCity;
    /**
     * 预算总金额 
     */
     @TableField(value = "TOTAL_BUDGET_AMOUNT ", condition = LIKE)
    private BigDecimal totalBudgetAmount;
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
     * 已结算金额 
     */
     @TableField(value = "SETTLEMENT_AMOUNT ", condition = LIKE)
    private BigDecimal settlementAmount;
    /**
     * 已执行金额 
     */
     @TableField(value = "PERFORM_AMOUNT ", condition = LIKE)
    private BigDecimal performAmount;
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
