package top.tangyh.lamp.learnpm.vo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 线上会议发布翻页查询对象
 * </p>
 *
 * @author dz
 * @date 2022-07-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmOnlineMeetingPublishPageQuery", description = "线上会议发布")
public class PmOnlineMeetingPublishPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long  id;
    /**
     * 会议申请id
     */
    @ApiModelProperty(value = "会议申请id")
    private Long  pmProjectMeetingApplyId;
    /**
     * 会议实到人数
     */
    @ApiModelProperty(value = "会议实到人数")
    private Integer  meetingActualAttendance;
    /**
     * 会议签到记录
     */
    @ApiModelProperty(value = "会议签到记录")
    private String  meetingAttendanceRecord;
    /**
     * 会议频道号
     */
    @ApiModelProperty(value = "会议频道号")
    private String  meetingChannelNumber;
    /**
     * 邀请参会
     */
    @ApiModelProperty(value = "邀请参会")
    private String  invitationToAttend;
    /**
     * 观看条件
     */
    @ApiModelProperty(value = "观看条件")
    private String  viewCondition;
    /**
     * 会议海报
     */
    @ApiModelProperty(value = "会议海报")
    private String  meetingPoster;
    /**
     * 会议介绍
     */
    @ApiModelProperty(value = "会议介绍")
    private String  meetingIntroduction;
    /**
     * 会议名称
     */
    @ApiModelProperty(value = "会议名称")
    private String  meetingName;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long  pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String  projectName;
    /**
     * 网上直播公司
     */
    @ApiModelProperty(value = "网上直播公司")
    private String  webcastCompany;
    /**
     * 会议开始时间
     */
    @ApiModelProperty(value = "会议开始时间")
    private Date  meetingStartTime;
    /**
     * 会议结束时间
     */
    @ApiModelProperty(value = "会议结束时间")
    private Date  meetingEndTime;
    /**
     * 会议简介
     */
    @ApiModelProperty(value = "会议简介")
    private String  meetingOverview;
    /**
     * 发布状态
     */
    @ApiModelProperty(value = "发布状态")
    private String  publishStatus;
    /**
     * 是否禁言
     */
    @ApiModelProperty(value = "是否禁言")
    private String  isForbidden;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    private String  attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    private String  attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    private String  attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    private String  attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    private String  attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    private String  attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    private String  attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    private String  attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    private String  attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    private String  attribute10;
}

