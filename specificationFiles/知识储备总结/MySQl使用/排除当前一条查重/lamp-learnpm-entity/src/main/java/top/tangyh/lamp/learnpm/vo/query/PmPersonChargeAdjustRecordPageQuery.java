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

/**
 * <p>
 * 项目负责人及规划负责人调整记录翻页查询对象
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmPersonChargeAdjustRecordPageQuery", description = "项目负责人及规划负责人调整记录")
public class PmPersonChargeAdjustRecordPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目角色
     */
    @ApiModelProperty(value = "项目角色")
    private String  projectRole;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long  pmProjectId;
    /**
     * 会议规划id
     */
    @ApiModelProperty(value = "会议规划id")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 原负责人id
     */
    @ApiModelProperty(value = "原负责人id")
    private Long  originalPrincipalId;
    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    private String  originalPrincipalPhone;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String  name;
    /**
     * 现在负责人id
     */
    @ApiModelProperty(value = "现在负责人id")
    private Long  nowPrincipalId;
    /**
     * 现负责人人姓名
     */
    @ApiModelProperty(value = "现负责人人姓名")
    private String  nowPrincipalName;
    /**
     * 现负责人手机
     */
    @ApiModelProperty(value = "现负责人手机")
    private String  nowPrincipalPhone;
    /**
     * 调整原因
     */
    @ApiModelProperty(value = "调整原因")
    private String  adjustReason;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String  status;
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

