package top.tangyh.lamp.learnpm.vo.result;
import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.Entity;
import top.tangyh.basic.interfaces.echo.EchoVO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import top.tangyh.lamp.model.constant.EchoApi;
import top.tangyh.lamp.model.constant.EchoDictType;
import top.tangyh.basic.annotation.echo.Echo;
import java.util.Date;


/**
 * <p>
 * 网上直播实体类
 * </p>
 *
 * @author liyy
 * @since 2022-06-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmWebcastResultVO", description = "网上直播")
public class PmWebcastResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 项目会议申请id
     */
    @ApiModelProperty(value = "项目会议申请id")
    @Excel(name = "项目会议申请id")
    private Long  pmProjectMeetingApplyId;
    /**
     * 会议名称
     */
    @ApiModelProperty(value = "会议名称")
    @Excel(name = "会议名称")
    private String  meetingName;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    @Excel(name = "项目id")
    private Long  pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    @Excel(name = "项目名称")
    private String  projectName;
    /**
     * 网上直播公司
     */
    @ApiModelProperty(value = "网上直播公司")
    @Excel(name = "网上直播公司")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.WEBCAST_COMPANY)
    private String  webcastCompany;
    /**
     * 会议开始时间
     */
    @ApiModelProperty(value = "会议开始时间")
    @Excel(name = "会议开始时间")
    private Date  meetingStartTime;
    /**
     * 会议结束时间
     */
    @ApiModelProperty(value = "会议结束时间")
    @Excel(name = "会议结束时间")
    private Date  meetingEndTime;
    /**
     * 会议简介
     */
    @ApiModelProperty(value = "会议简介")
    @Excel(name = "会议简介")
    private String  meetingOverview;
    /**
     * 会议频道号
     */
    @ApiModelProperty(value = "会议频道号")
    @Excel(name = "会议频道号")
    private String  meetingChannelNumber;
    /**
     * 会议海报
     */
    @ApiModelProperty(value = "会议海报")
    @Excel(name = "会议海报")
    private String  meetingPoster;
    /**
     * 申请开通状态
     */
    @ApiModelProperty(value = "申请开通状态")
    @Excel(name = "申请开通状态")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.APPLICATION_OPENING_STATUS)
    private String  applicationOpeningStatus;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Excel(name = "状态")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.COMMIT_AUDIT_RECEIVE_PROCESS_STATUS)
    private String  status;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Excel(name = "备注")
    private String  remark;
    /**
     * 邀请参会
     */
    @ApiModelProperty(value = "邀请参会")
    @Excel(name = "邀请参会")
    private String  invitationToAttend;
    /**
     * 观看条件
     */
    @ApiModelProperty(value = "观看条件")
    @Excel(name = "观看条件")
    private String  viewCondition;
    /**
     * 会议介绍
     */
    @ApiModelProperty(value = "会议介绍")
    @Excel(name = "会议介绍")
    private String  meetingIntroduction;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Excel(name = "扩展字段1")
    private String  attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Excel(name = "扩展字段2")
    private String  attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Excel(name = "扩展字段3")
    private String  attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Excel(name = "扩展字段4")
    private String  attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Excel(name = "扩展字段5")
    private String  attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Excel(name = "扩展字段6")
    private String  attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Excel(name = "扩展字段7")
    private String  attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Excel(name = "扩展字段8")
    private String  attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Excel(name = "扩展字段9")
    private String  attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Excel(name = "扩展字段10")
    private String  attribute10;
}

