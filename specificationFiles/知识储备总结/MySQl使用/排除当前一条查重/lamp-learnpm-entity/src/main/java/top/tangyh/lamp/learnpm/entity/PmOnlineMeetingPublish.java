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
import java.util.Date;


/**
 * <p>
 * 线上会议发布实体类
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
@TableName("PM_ONLINE_MEETING_PUBLISH")
@AllArgsConstructor
@Builder
public class PmOnlineMeetingPublish extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 会议申请id 
     */
     @TableField(value = "PM_PROJECT_MEETING_APPLY_ID ", condition = LIKE)
    private Long pmProjectMeetingApplyId;
    /**
     * 会议实到人数 
     */
     @TableField(value = "MEETING_ACTUAL_ATTENDANCE ", condition = LIKE)
    private Integer meetingActualAttendance;
    /**
     * 会议签到记录 
     */
     @TableField(value = "MEETING_ATTENDANCE_RECORD ", condition = LIKE)
    private String meetingAttendanceRecord;
    /**
     * 会议频道号 
     */
     @TableField(value = "MEETING_CHANNEL_NUMBER ", condition = LIKE)
    private String meetingChannelNumber;
    /**
     * 邀请参会 
     */
     @TableField(value = "INVITATION_TO_ATTEND ", condition = LIKE)
    private String invitationToAttend;
    /**
     * 观看条件 
     */
     @TableField(value = "VIEW_CONDITION ", condition = LIKE)
    private String viewCondition;
    /**
     * 会议海报 
     */
     @TableField(value = "MEETING_POSTER ", condition = LIKE)
    private String meetingPoster;
    /**
     * 会议介绍 
     */
     @TableField(value = "MEETING_INTRODUCTION ", condition = LIKE)
    private String meetingIntroduction;
    /**
     * 会议名称 
     */
     @TableField(value = "MEETING_NAME ", condition = LIKE)
    private String meetingName;
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
     * 网上直播公司 
     */
     @TableField(value = "WEBCAST_COMPANY ", condition = LIKE)
    private String webcastCompany;
    /**
     * 会议开始时间 
     */
     @TableField(value = "MEETING_START_TIME ", condition = LIKE)
    private Date meetingStartTime;
    /**
     * 会议结束时间 
     */
     @TableField(value = "MEETING_END_TIME ", condition = LIKE)
    private Date meetingEndTime;
    /**
     * 会议简介 
     */
     @TableField(value = "MEETING_OVERVIEW ", condition = LIKE)
    private String meetingOverview;
    /**
     * 发布状态 
     */
     @TableField(value = "PUBLISH_STATUS ", condition = LIKE)
    private String publishStatus;
    /**
     * 是否禁言 
     */
     @TableField(value = "IS_FORBIDDEN ", condition = LIKE)
    private String isForbidden;
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
