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
 * 流程环节配置实体类
 * </p>
 *
 * @author xucl
 * @since 2022-06-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmProcessPhaseConfResultVO", description = "流程环节配置")
public class PmProcessPhaseConfResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 流程id
     */
    @ApiModelProperty(value = "流程id")
    @Excel(name = "流程id")
    private Long  pmApprovalProcessConfigId;
    /**
     * 节点类型编码
     */
    @ApiModelProperty(value = "节点类型编码")
    @Excel(name = "节点类型编码")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.NODE_TYPE_CODE)
    private String  nodeTypeCode;
    /**
     * 环节次序
     */
    @ApiModelProperty(value = "环节次序")
    @Excel(name = "环节次序")
    private Integer  linkSequence;
    /**
     * 审批人类型
     */
    @ApiModelProperty(value = "审批人类型")
    @Excel(name = "审批人类型")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.APPROVER_TYPE)
    private String  approverType;
    /**
     * 审批人名称
     */
    @ApiModelProperty(value = "审批人名称")
    @Excel(name = "审批人名称")
    private String  approverName;
    /**
     * 审批人id
     */
    @ApiModelProperty(value = "审批人id")
    @Excel(name = "审批人id")
    private Long  approverId;
    /**
     * 是否允许转审
     */
    @ApiModelProperty(value = "是否允许转审")
    @Excel(name = "是否允许转审")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isAllowTransferApproval;
    /**
     * 是否结束
     */
    @ApiModelProperty(value = "是否结束")
    @Excel(name = "是否结束")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isEnd;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    @Excel(name = "是否有效")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.IS_VALID)
    private String  isValid;
    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    @Excel(name = "角色编码")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.ROLE_COE)
    private String  roleCode;
    /**
     * 审核不通过退回节点ID
     */
    @ApiModelProperty(value = "审核不通过退回节点ID")
    @Excel(name = "审核不通过退回节点ID")
    private Long  backNodeId;
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

