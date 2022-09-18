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
 *  流程环节配置更新实体类
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmProcessPhaseConfUpdateVO", description = "流程环节配置")
public class PmProcessPhaseConfUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 流程id
     */
    @ApiModelProperty(value = "流程id")
    private  Long pmApprovalProcessConfigId;
    /**
     * 节点类型编码
     */
    @ApiModelProperty(value = "节点类型编码")
    @Size(max = 2, message = "节点类型编码长度不能超过2")  
    private  String nodeTypeCode;
    /**
     * 环节次序
     */
    @ApiModelProperty(value = "环节次序")
    private  Integer linkSequence;
    /**
     * 审批人类型
     */
    @ApiModelProperty(value = "审批人类型")
    @Size(max = 2, message = "审批人类型长度不能超过2")  
    private  String approverType;
    /**
     * 审批人名称
     */
    @ApiModelProperty(value = "审批人名称")
    @Size(max = 200, message = "审批人名称长度不能超过200")  
    private  String approverName;
    /**
     * 审批人id
     */
    @ApiModelProperty(value = "审批人id")
    private  Long approverId;
    /**
     * 是否允许转审
     */
    @ApiModelProperty(value = "是否允许转审")
    @Size(max = 1, message = "是否允许转审长度不能超过1")  
    private  String isAllowTransferApproval;
    /**
     * 是否结束
     */
    @ApiModelProperty(value = "是否结束")
    @Size(max = 1, message = "是否结束长度不能超过1")  
    private  String isEnd;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    @Size(max = 1, message = "是否有效长度不能超过1")  
    private  String isValid;
    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    @Size(max = 2, message = "角色编码长度不能超过2")  
    private  String roleCode;
    /**
     * 审核不通过退回节点ID
     */
    @ApiModelProperty(value = "审核不通过退回节点ID")
    private  Long backNodeId;
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
