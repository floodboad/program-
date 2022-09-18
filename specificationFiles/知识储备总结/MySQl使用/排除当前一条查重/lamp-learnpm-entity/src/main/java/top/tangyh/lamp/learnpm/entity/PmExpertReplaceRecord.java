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
 * 专家更换记录实体类
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_EXPERT_REPLACE_RECORD")
@AllArgsConstructor
@Builder
public class PmExpertReplaceRecord extends Entity<Long> {

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
     * 会议专家劳务id 
     */
     @TableField(value = "PM_CONFERENCE_EXPERT_SERVICES_ID ", condition = LIKE)
    private Long pmConferenceExpertServicesId;
    /**
     * 原专家id 
     */
     @TableField(value = "OLD_MS_EXPERT_INFO_ID ", condition = LIKE)
    private Long oldMsExpertInfoId;
    /**
     * 原专家姓名 
     */
     @TableField(value = "OLD_EXPERT_INFO_NAME ", condition = LIKE)
    private String oldExpertInfoName;
    /**
     * 现专家id 
     */
     @TableField(value = "NOW_MS_EXPERT_INFO_ID ", condition = LIKE)
    private Long nowMsExpertInfoId;
    /**
     * 现专家姓名 
     */
     @TableField(value = "NOW_EXPERT_INFO_NAME ", condition = LIKE)
    private String nowExpertInfoName;
    /**
     * 状态 
     */
     @TableField(value = "STATUS ", condition = LIKE)
    private String status;
    /**
     * 说明 
     */
     @TableField(value = "ILLUSTRATE ", condition = LIKE)
    private String illustrate;
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
