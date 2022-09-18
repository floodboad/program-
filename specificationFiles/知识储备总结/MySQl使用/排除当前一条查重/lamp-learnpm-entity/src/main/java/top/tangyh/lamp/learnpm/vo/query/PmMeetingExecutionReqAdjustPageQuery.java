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
 * 会议执行要求调整记录翻页查询对象
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
@ApiModel(value = "PmMeetingExecutionReqAdjustPageQuery", description = "会议执行要求调整记录")
public class PmMeetingExecutionReqAdjustPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    private String  projectMeetingPlanningName;
    /**
     * 会议执行环节
     */
    @ApiModelProperty(value = "会议执行环节")
    private String  meetingExecutionLink;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String  illustrate;
    /**
     * 执行方式
     */
    @ApiModelProperty(value = "执行方式")
    private String  executionMode;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id")
    private Long  unitId;
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String  unitName;
    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    private Long  chargePersonId;
    /**
     * 负责人姓名
     */
    @ApiModelProperty(value = "负责人姓名")
    private String  chargePersonName;
    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    private String  chargePhone;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String  remark;
    /**
     * 会议规划调整id
     */
    @ApiModelProperty(value = "会议规划调整id")
    private Long  pmProjectMeetingPlanAdjustId;
    /**
     * 会议范围
     */
    @ApiModelProperty(value = "会议范围")
    private String  meetingRange;
    /**
     * 是否有观看条件
     */
    @ApiModelProperty(value = "是否有观看条件")
    private String  isViewingConditions;
    /**
     * 填写信息内容要求
     */
    @ApiModelProperty(value = "填写信息内容要求")
    private String  fillInfoContentReq;
    /**
     * 是否填写姓名
     */
    @ApiModelProperty(value = "是否填写姓名")
    private String  isFillName;
    /**
     * 是否填写手机号
     */
    @ApiModelProperty(value = "是否填写手机号")
    private String  isFillPhone;
    /**
     * 是否上传医生证明
     */
    @ApiModelProperty(value = "是否上传医生证明")
    private String  doctorCertificate;
    /**
     * 是否填写医院
     */
    @ApiModelProperty(value = "是否填写医院")
    private String  isFillHospital;
    /**
     * 是否填写科室
     */
    @ApiModelProperty(value = "是否填写科室")
    private String  isFillDepartment;
    /**
     * 是否填写职称
     */
    @ApiModelProperty(value = "是否填写职称")
    private String  isFillPost;
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

