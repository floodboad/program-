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

/**
 * <p>
 * 会议执行状态操作表实体类
 * </p>
 *
 * @author dz
 * @since 2022-06-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmMeetingExeStatusActionResultVO", description = "会议执行状态操作表")
public class PmMeetingExeStatusActionResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 执行类型
     */
    @ApiModelProperty(value = "执行类型")
    @Excel(name = "执行类型")
    private String  executionType;
    /**
     * 申请人id
     */
    @ApiModelProperty(value = "申请人id")
    @Excel(name = "申请人id")
    private Long  applicantId;
    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    @Excel(name = "申请人")
    private String  applicant;
    /**
     * 申请人手机号
     */
    @ApiModelProperty(value = "申请人手机号")
    @Excel(name = "申请人手机号")
    private String  applicantPhone;
    /**
     * 审批人id
     */
    @ApiModelProperty(value = "审批人id")
    @Excel(name = "审批人id")
    private Long  approverId;
    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
    @Excel(name = "审批人")
    private String  approver;
    /**
     * 审批人手机号
     */
    @ApiModelProperty(value = "审批人手机号")
    @Excel(name = "审批人手机号")
    private String  approverPhone;
    /**
     * 执行公司id
     */
    @ApiModelProperty(value = "执行公司id")
    @Excel(name = "执行公司id")
    private Long  executionCompanyId;
    /**
     * 执行人id
     */
    @ApiModelProperty(value = "执行人id")
    @Excel(name = "执行人id")
    private Long  executorId;
    /**
     * 执行人手机号
     */
    @ApiModelProperty(value = "执行人手机号")
    @Excel(name = "执行人手机号")
    private String  executorPhone;
    /**
     * 执行人
     */
    @ApiModelProperty(value = "执行人")
    @Excel(name = "执行人")
    private String  executor;
    /**
     * 审批意见
     */
    @ApiModelProperty(value = "审批意见")
    @Excel(name = "审批意见")
    private String  approvalComments;
    /**
     * 审批状态
     */
    @ApiModelProperty(value = "审批状态")
    @Excel(name = "审批状态")
    private String  auditStatus;
    /**
     * 会议执行要求id
     */
    @ApiModelProperty(value = "会议执行要求id")
    @Excel(name = "会议执行要求id")
    private Long  pmMeetingExecutionReqId;
    /**
     * 流程环节实例ID
     */
    @ApiModelProperty(value = "流程环节实例ID")
    @Excel(name = "流程环节实例ID")
    private Long  msProcessPhaseInstanceId;
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

