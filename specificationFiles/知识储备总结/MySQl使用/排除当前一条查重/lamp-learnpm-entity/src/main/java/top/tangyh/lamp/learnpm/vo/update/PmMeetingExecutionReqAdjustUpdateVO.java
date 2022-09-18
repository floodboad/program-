package top.tangyh.lamp.learnpm.vo.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.SuperEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>
 *  会议执行要求调整记录更新实体类
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
@ApiModel(value = "PmMeetingExecutionReqAdjustUpdateVO", description = "会议执行要求调整记录")
public class PmMeetingExecutionReqAdjustUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    private  Long pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    @Size(max = 300, message = "项目会议规划名称长度不能超过300")  
    private  String projectMeetingPlanningName;
    /**
     * 会议执行环节
     */
    @ApiModelProperty(value = "会议执行环节")
    @Size(max = 2, message = "会议执行环节长度不能超过2")  
    private  String meetingExecutionLink;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Size(max = 300, message = "说明长度不能超过300")  
    private  String illustrate;
    /**
     * 执行方式
     */
    @ApiModelProperty(value = "执行方式")
    @Size(max = 2, message = "执行方式长度不能超过2")  
    private  String executionMode;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id")
    private  Long unitId;
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    @Size(max = 300, message = "单位名称长度不能超过300")  
    private  String unitName;
    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    private  Long chargePersonId;
    /**
     * 负责人姓名
     */
    @ApiModelProperty(value = "负责人姓名")
    @Size(max = 200, message = "负责人姓名长度不能超过200")  
    private  String chargePersonName;
    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    @Size(max = 11, message = "负责人手机号长度不能超过11")  
    private  String chargePhone;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 300, message = "备注长度不能超过300")  
    private  String remark;
    /**
     * 会议规划调整id
     */
    @ApiModelProperty(value = "会议规划调整id")
    private  Long pmProjectMeetingPlanAdjustId;
    /**
     * 会议范围
     */
    @ApiModelProperty(value = "会议范围")
    @Size(max = 2, message = "会议范围长度不能超过2")  
    private  String meetingRange;
    /**
     * 是否有观看条件
     */
    @ApiModelProperty(value = "是否有观看条件")
    @Size(max = 1, message = "是否有观看条件长度不能超过1")  
    private  String isViewingConditions;
    /**
     * 填写信息内容要求
     */
    @ApiModelProperty(value = "填写信息内容要求")
    @Size(max = 2, message = "填写信息内容要求长度不能超过2")  
    private  String fillInfoContentReq;
    /**
     * 是否填写姓名
     */
    @ApiModelProperty(value = "是否填写姓名")
    @Size(max = 1, message = "是否填写姓名长度不能超过1")  
    private  String isFillName;
    /**
     * 是否填写手机号
     */
    @ApiModelProperty(value = "是否填写手机号")
    @Size(max = 1, message = "是否填写手机号长度不能超过1")  
    private  String isFillPhone;
    /**
     * 是否上传医生证明
     */
    @ApiModelProperty(value = "是否上传医生证明")
    @Size(max = 1, message = "是否上传医生证明长度不能超过1")  
    private  String doctorCertificate;
    /**
     * 是否填写医院
     */
    @ApiModelProperty(value = "是否填写医院")
    @Size(max = 1, message = "是否填写医院长度不能超过1")  
    private  String isFillHospital;
    /**
     * 是否填写科室
     */
    @ApiModelProperty(value = "是否填写科室")
    @Size(max = 1, message = "是否填写科室长度不能超过1")  
    private  String isFillDepartment;
    /**
     * 是否填写职称
     */
    @ApiModelProperty(value = "是否填写职称")
    @Size(max = 1, message = "是否填写职称长度不能超过1")  
    private  String isFillPost;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Size(max = 100, message = "扩展字段1长度不能超过100")  
    private  String attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Size(max = 100, message = "扩展字段2长度不能超过100")  
    private  String attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Size(max = 100, message = "扩展字段3长度不能超过100")  
    private  String attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Size(max = 100, message = "扩展字段4长度不能超过100")  
    private  String attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Size(max = 100, message = "扩展字段5长度不能超过100")  
    private  String attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Size(max = 100, message = "扩展字段6长度不能超过100")  
    private  String attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Size(max = 100, message = "扩展字段7长度不能超过100")  
    private  String attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Size(max = 100, message = "扩展字段8长度不能超过100")  
    private  String attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Size(max = 100, message = "扩展字段9长度不能超过100")  
    private  String attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Size(max = 100, message = "扩展字段10长度不能超过100")  
    private  String attribute10;
}
