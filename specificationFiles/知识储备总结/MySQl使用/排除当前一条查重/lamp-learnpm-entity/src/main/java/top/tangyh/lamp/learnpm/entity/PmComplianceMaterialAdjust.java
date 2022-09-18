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
 * 项目合规材料调整实体类
 * </p>
 *
 * @author liyy
 * @date 2022-06-28
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_COMPLIANCE_MATERIAL_ADJUST")
@AllArgsConstructor
@Builder
public class PmComplianceMaterialAdjust extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id 
     */
     @TableField(value = "PM_PROJECT_ID ", condition = LIKE)
    private Long pmProjectId;
    /**
     * 项目会议规划id 
     */
     @TableField(value = "PM_PROJECT_MEETING_PLANNING_ID ", condition = LIKE)
    private Long pmProjectMeetingPlanningId;
    /**
     * 合规材料id 
     */
     @TableField(value = "PM_COMPLIANCE_MATERIALS_ID ", condition = LIKE)
    private Long pmComplianceMaterialsId;
    /**
     * 合规材料名称 
     */
     @TableField(value = "COMPLIANCE_MATERIALS_NAME ", condition = LIKE)
    private String complianceMaterialsName;
    /**
     * 会议规划调整id 
     */
     @TableField(value = "PM_PROJECT_MEETING_PLAN_ADJUST_ID ", condition = LIKE)
    private Long pmProjectMeetingPlanAdjustId;
    /**
     * 说明 
     */
     @TableField(value = "ILLUSTRATE ", condition = LIKE)
    private String illustrate;

}
