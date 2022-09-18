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
 * 项目负责人及规划负责人调整记录实体类
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
@TableName("PM_PERSON_CHARGE_ADJUST_RECORD")
@AllArgsConstructor
@Builder
public class PmPersonChargeAdjustRecord extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目角色 
     */
     @TableField(value = "PROJECT_ROLE ", condition = LIKE)
    private String projectRole;
    /**
     * 项目id 
     */
     @TableField(value = "PM_PROJECT_ID ", condition = LIKE)
    private Long pmProjectId;
    /**
     * 会议规划id 
     */
     @TableField(value = "PM_PROJECT_MEETING_PLANNING_ID ", condition = LIKE)
    private Long pmProjectMeetingPlanningId;
    /**
     * 原负责人id 
     */
     @TableField(value = "ORIGINAL_PRINCIPAL_ID ", condition = LIKE)
    private Long originalPrincipalId;
    /**
     * 负责人手机号 
     */
     @TableField(value = "ORIGINAL_PRINCIPAL_PHONE ", condition = LIKE)
    private String originalPrincipalPhone;
    /**
     * 姓名 
     */
     @TableField(value = "NAME ", condition = LIKE)
    private String name;
    /**
     * 现在负责人id 
     */
     @TableField(value = "NOW_PRINCIPAL_ID ", condition = LIKE)
    private Long nowPrincipalId;
    /**
     * 现负责人人姓名 
     */
     @TableField(value = "NOW_PRINCIPAL_NAME ", condition = LIKE)
    private String nowPrincipalName;
    /**
     * 现负责人手机 
     */
     @TableField(value = "NOW_PRINCIPAL_PHONE ", condition = LIKE)
    private String nowPrincipalPhone;
    /**
     * 调整原因 
     */
     @TableField(value = "ADJUST_REASON ", condition = LIKE)
    private String adjustReason;
    /**
     * 状态 
     */
     @TableField(value = "STATUS ", condition = LIKE)
    private String status;


//    /**
//     * 扩展字段1
//     */
//     @TableField(value = "ATTRIBUTE1 ", condition = LIKE)
//    private String attribute1;
//    /**
//     * 扩展字段2
//     */
//     @TableField(value = "ATTRIBUTE2 ", condition = LIKE)
//    private String attribute2;
//    /**
//     * 扩展字段3
//     */
//     @TableField(value = "ATTRIBUTE3 ", condition = LIKE)
//    private String attribute3;
//    /**
//     * 扩展字段4
//     */
//     @TableField(value = "ATTRIBUTE4 ", condition = LIKE)
//    private String attribute4;
//    /**
//     * 扩展字段5
//     */
//     @TableField(value = "ATTRIBUTE5 ", condition = LIKE)
//    private String attribute5;
//    /**
//     * 扩展字段6
//     */
//     @TableField(value = "ATTRIBUTE6 ", condition = LIKE)
//    private String attribute6;
//    /**
//     * 扩展字段7
//     */
//     @TableField(value = "ATTRIBUTE7 ", condition = LIKE)
//    private String attribute7;
//    /**
//     * 扩展字段8
//     */
//     @TableField(value = "ATTRIBUTE8 ", condition = LIKE)
//    private String attribute8;
//    /**
//     * 扩展字段9
//     */
//     @TableField(value = "ATTRIBUTE9 ", condition = LIKE)
//    private String attribute9;
//    /**
//     * 扩展字段10
//     */
//     @TableField(value = "ATTRIBUTE10 ", condition = LIKE)
//    private String attribute10;

}
