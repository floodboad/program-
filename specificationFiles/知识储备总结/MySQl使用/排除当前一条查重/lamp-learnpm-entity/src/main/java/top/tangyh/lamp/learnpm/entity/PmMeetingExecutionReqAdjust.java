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

/**
 * <p>
 * 会议执行要求调整记录实体类
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
@TableName("PM_MEETING_EXECUTION_REQ_ADJUST")
@AllArgsConstructor
@Builder
public class PmMeetingExecutionReqAdjust extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议规划id 
     */
     @TableField(value = "PM_PROJECT_MEETING_PLANNING_ID ", condition = LIKE)
    private Long pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称 
     */
     @TableField(value = "PROJECT_MEETING_PLANNING_NAME ", condition = LIKE)
    private String projectMeetingPlanningName;
    /**
     * 会议执行环节 
     */
     @TableField(value = "MEETING_EXECUTION_LINK ", condition = LIKE)
    private String meetingExecutionLink;
    /**
     * 说明 
     */
     @TableField(value = "ILLUSTRATE ", condition = LIKE)
    private String illustrate;
    /**
     * 执行方式 
     */
     @TableField(value = "EXECUTION_MODE ", condition = LIKE)
    private String executionMode;
    /**
     * 单位id 
     */
     @TableField(value = "UNIT_ID ", condition = LIKE)
    private Long unitId;
    /**
     * 单位名称 
     */
     @TableField(value = "UNIT_NAME ", condition = LIKE)
    private String unitName;
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
     @TableField(value = "CHARGE_PHONE ", condition = LIKE)
    private String chargePhone;
    /**
     * 备注 
     */
     @TableField(value = "REMARK ", condition = LIKE)
    private String remark;
    /**
     * 会议规划调整id 
     */
     @TableField(value = "PM_PROJECT_MEETING_PLAN_ADJUST_ID ", condition = LIKE)
    private Long pmProjectMeetingPlanAdjustId;
    /**
     * 会议范围 
     */
     @TableField(value = "MEETING_RANGE ", condition = LIKE)
    private String meetingRange;
    /**
     * 是否有观看条件 
     */
     @TableField(value = "IS_VIEWING_CONDITIONS ", condition = LIKE)
    private String isViewingConditions;
    /**
     * 填写信息内容要求 
     */
     @TableField(value = "FILL_INFO_CONTENT_REQ ", condition = LIKE)
    private String fillInfoContentReq;
    /**
     * 是否填写姓名 
     */
     @TableField(value = "IS_FILL_NAME ", condition = LIKE)
    private String isFillName;
    /**
     * 是否填写手机号 
     */
     @TableField(value = "IS_FILL_PHONE ", condition = LIKE)
    private String isFillPhone;
    /**
     * 是否上传医生证明 
     */
     @TableField(value = "DOCTOR_CERTIFICATE ", condition = LIKE)
    private String doctorCertificate;
    /**
     * 是否填写医院 
     */
     @TableField(value = "IS_FILL_HOSPITAL ", condition = LIKE)
    private String isFillHospital;
    /**
     * 是否填写科室 
     */
     @TableField(value = "IS_FILL_DEPARTMENT ", condition = LIKE)
    private String isFillDepartment;
    /**
     * 是否填写职称 
     */
     @TableField(value = "IS_FILL_POST ", condition = LIKE)
    private String isFillPost;
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
