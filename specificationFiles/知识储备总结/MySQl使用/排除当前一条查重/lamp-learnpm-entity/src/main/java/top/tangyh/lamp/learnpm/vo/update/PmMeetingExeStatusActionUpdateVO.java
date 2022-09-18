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
 *  会议执行状态操作表更新实体类
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
@ApiModel(value = "PmMeetingExeStatusActionUpdateVO", description = "会议执行状态操作表")
public class PmMeetingExeStatusActionUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 执行类型
     */
    @ApiModelProperty(value = "执行类型")
    @Size(max = 300, message = "执行类型长度不能超过300")  
    private  String executionType;
    /**
     * 申请人id
     */
    @ApiModelProperty(value = "申请人id")
    private  Long applicantId;
    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    @Size(max = 200, message = "申请人长度不能超过200")  
    private  String applicant;
    /**
     * 申请人手机号
     */
    @ApiModelProperty(value = "申请人手机号")
    @Size(max = 11, message = "申请人手机号长度不能超过11")  
    private  String applicantPhone;
    /**
     * 审批人id
     */
    @ApiModelProperty(value = "审批人id")
    private  Long approverId;
    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
    @Size(max = 200, message = "审批人长度不能超过200")  
    private  String approver;
    /**
     * 审批人手机号
     */
    @ApiModelProperty(value = "审批人手机号")
    @Size(max = 11, message = "审批人手机号长度不能超过11")  
    private  String approverPhone;
    /**
     * 执行公司id
     */
    @ApiModelProperty(value = "执行公司id")
    private  Long executionCompanyId;
    /**
     * 执行人id
     */
    @ApiModelProperty(value = "执行人id")
    private  Long executorId;
    /**
     * 执行人手机号
     */
    @ApiModelProperty(value = "执行人手机号")
    @Size(max = 11, message = "执行人手机号长度不能超过11")  
    private  String executorPhone;
    /**
     * 执行人
     */
    @ApiModelProperty(value = "执行人")
    @Size(max = 200, message = "执行人长度不能超过200")  
    private  String executor;
    /**
     * 审批意见
     */
    @ApiModelProperty(value = "审批意见")
    @Size(max = 300, message = "审批意见长度不能超过300")  
    private  String approvalComments;
    /**
     * 审批状态
     */
    @ApiModelProperty(value = "审批状态")
    @Size(max = 2, message = "审批状态长度不能超过2")  
    private  String auditStatus;
    /**
     * 会议执行要求id
     */
    @ApiModelProperty(value = "会议执行要求id")
    private  Long pmMeetingExecutionReqId;
    /**
     * 流程环节实例ID
     */
    @ApiModelProperty(value = "流程环节实例ID")
    private  Long msProcessPhaseInstanceId;
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
