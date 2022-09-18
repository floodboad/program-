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
import top.tangyh.lamp.model.constant.EchoDictType;
import top.tangyh.lamp.model.constant.EchoApi;
import top.tangyh.basic.annotation.echo.Echo;

/**
 * <p>
 * 流程环节实例实体类
 * </p>
 *
 * @author 龙色波
 * @since 2022-06-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmProcessPhaseInstanceResultVO", description = "流程环节实例")
public class PmProcessPhaseInstanceResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "ID")
    private Long id;
    /**
     * 审批流实例ID
     */
    @ApiModelProperty(value = "审批流实例ID")
    @Excel(name = "审批流实例ID")
    private Long  pmApprovalProcessInstanceId;
    /**
     * 流程环节配置ID
     */
    @ApiModelProperty(value = "流程环节配置ID")
    @Excel(name = "流程环节配置ID")
    private Long  msProcessPhaseConfId;
    /**
     * 审批人id
     */
    @ApiModelProperty(value = "审批人id")
    @Excel(name = "审批人id")
    private Long  approverId;
    /**
     * 审批人名称
     */
    @ApiModelProperty(value = "审批人名称")
    @Excel(name = "审批人名称")
    private String  approverName;
    /**
     * 审批人类型
     */
    @ApiModelProperty(value = "审批人类型")
    @Excel(name = "审批人类型")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.APPROVER_TYPE)
    private String  approverType;
    /**
     * 审批意见
     */
    @ApiModelProperty(value = "审批意见")
    @Excel(name = "审批意见")
    private String  approvalComments;
    /**
     * 是否同意
     */
    @ApiModelProperty(value = "是否同意")
    @Excel(name = "是否同意")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  agreest;
    /**
     * 是否结束
     */
    @ApiModelProperty(value = "是否结束")
    @Excel(name = "是否结束")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isEnd;
    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    @Excel(name = "角色编码")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.ROLE_COE)
    private String  roleCode;
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

