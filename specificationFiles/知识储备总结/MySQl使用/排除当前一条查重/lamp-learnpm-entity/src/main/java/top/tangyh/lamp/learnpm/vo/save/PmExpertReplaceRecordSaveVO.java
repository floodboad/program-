package top.tangyh.lamp.learnpm.vo.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


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
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmExpertReplaceRecordSaveVO", description = "专家更换记录")
public class PmExpertReplaceRecordSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议申请id
     */
    @ApiModelProperty(value = "项目会议申请id")
    private Long   pmProjectMeetingApplyId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long   pmProjectId;
    /**
     * 会议支持项目名称
     */
    @ApiModelProperty(value = "会议支持项目名称")
    @Size(max = 300, message = "会议支持项目名称长度不能超过300")
    private String   meetingSupportProjectName;
    /**
     * 会议编号名称
     */
    @ApiModelProperty(value = "会议编号名称")
    @Size(max = 300, message = "会议编号名称长度不能超过300")
    private String   meetingNoName;
    /**
     * 会议专家劳务id
     */
    @ApiModelProperty(value = "会议专家劳务id")
    private Long   pmConferenceExpertServicesId;
    /**
     * 原专家id
     */
    @ApiModelProperty(value = "原专家id")
    private Long   oldMsExpertInfoId;
    /**
     * 原专家姓名
     */
    @ApiModelProperty(value = "原专家姓名")
    @Size(max = 200, message = "原专家姓名长度不能超过200")
    private String   oldExpertInfoName;
    /**
     * 现专家id
     */
    @ApiModelProperty(value = "现专家id")
    private Long   nowMsExpertInfoId;
    /**
     * 现专家姓名
     */
    @ApiModelProperty(value = "现专家姓名")
    @Size(max = 200, message = "现专家姓名长度不能超过200")
    private String   nowExpertInfoName;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Size(max = 2, message = "状态长度不能超过2")
    private String   status;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Size(max = 300, message = "说明长度不能超过300")
    private String   illustrate;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Size(max = 100, message = "扩展字段1长度不能超过100")
    private String   attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Size(max = 100, message = "扩展字段2长度不能超过100")
    private String   attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Size(max = 100, message = "扩展字段3长度不能超过100")
    private String   attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Size(max = 100, message = "扩展字段4长度不能超过100")
    private String   attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Size(max = 100, message = "扩展字段5长度不能超过100")
    private String   attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Size(max = 100, message = "扩展字段6长度不能超过100")
    private String   attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Size(max = 100, message = "扩展字段7长度不能超过100")
    private String   attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Size(max = 100, message = "扩展字段8长度不能超过100")
    private String   attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Size(max = 100, message = "扩展字段9长度不能超过100")
    private String   attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Size(max = 100, message = "扩展字段10长度不能超过100")
    private String   attribute10;
}
