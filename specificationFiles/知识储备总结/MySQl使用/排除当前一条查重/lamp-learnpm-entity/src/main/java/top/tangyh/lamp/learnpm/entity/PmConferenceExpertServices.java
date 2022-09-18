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
 * 会议专家劳务实体类
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
@TableName("PM_CONFERENCE_EXPERT_SERVICES")
@AllArgsConstructor
@Builder
public class PmConferenceExpertServices extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议申请id 
     */
     @TableField(value = "PM_PROJECT_MEETING_APPLY_ID ", condition = LIKE)
    private Long pmProjectMeetingApplyId;
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
     * 费用id 
     */
     @TableField(value = "MS_BUDGET_SUBJECT_ID ", condition = LIKE)
    private Long msBudgetSubjectId;
    /**
     * 费用名称 
     */
     @TableField(value = "FEE_NAME ", condition = LIKE)
    private String feeName;
    /**
     * 费用执行标准 
     */
     @TableField(value = "CONTROL_STANDARDS ", condition = LIKE)
    private String controlStandards;
    /**
     * 人数 
     */
     @TableField(value = "PERSON_NUMBER ", condition = LIKE)
    private Long personNumber;
    /**
     * 劳务税费id 
     */
     @TableField(value = "SERVICE_TAX_ID ", condition = LIKE)
    private BigDecimal serviceTaxId;
    /**
     * 劳务税费 
     */
     @TableField(value = "SERVICE_TAX ", condition = LIKE)
    private BigDecimal serviceTax;
    /**
     * 金额 
     */
     @TableField(value = "AMOUNT_MONEY ", condition = LIKE)
    private BigDecimal amountMoney;
    /**
     * 专家id 
     */
     @TableField(value = "MS_EXPERT_INFO_ID ", condition = LIKE)
    private Long msExpertInfoId;
    /**
     * 专家姓名 
     */
     @TableField(value = "EXPERT_INFO_NAME ", condition = LIKE)
    private String expertInfoName;
    /**
     * 所属医院id 
     */
     @TableField(value = "MS_HOSPITAL_INFO_ID ", condition = LIKE)
    private Long msHospitalInfoId;
    /**
     * 所属医院 
     */
     @TableField(value = "HOSPITAL_NAME ", condition = LIKE)
    private String hospitalName;
    /**
     * 所属科室id 
     */
     @TableField(value = "MS_DEPARTMENT_INFO_ID ", condition = LIKE)
    private Long msDepartmentInfoId;
    /**
     * 所属科室名称 
     */
     @TableField(value = "DEPARTMENT_INFO_NAME ", condition = LIKE)
    private String departmentInfoName;
    /**
     * 专家类别 
     */
     @TableField(value = "EXPERTS_CATEGORY ", condition = LIKE)
    private String expertsCategory;
    /**
     * 劳务协议附件 
     */
     @TableField(value = "SERVICE_AGREEMENT_ATTACHMENT ", condition = LIKE)
    private String serviceAgreementAttachment;
    /**
     * 状态 
     */
     @TableField(value = "STATUS ", condition = LIKE)
    private String status;
    /**
     * 合同编号 
     */
     @TableField(value = "CONTRACT_NO ", condition = LIKE)
    private String contractNo;
    /**
     * 专家身份证号 
     */
     @TableField(value = "ATTRIBUTE1 ", condition = LIKE)
    private String attribute1;
    /**
     * 专家银行账号 
     */
     @TableField(value = "ATTRIBUTE2 ", condition = LIKE)
    private String attribute2;
    /**
     * 专家银行卡号 
     */
     @TableField(value = "ATTRIBUTE3 ", condition = LIKE)
    private String attribute3;
    /**
     * 专家手机号 
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
