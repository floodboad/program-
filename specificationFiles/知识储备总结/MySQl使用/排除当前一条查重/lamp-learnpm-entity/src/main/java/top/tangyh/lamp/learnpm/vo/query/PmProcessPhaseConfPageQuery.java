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
 * 流程环节配置翻页查询对象
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
@ApiModel(value = "PmProcessPhaseConfPageQuery", description = "流程环节配置")
public class PmProcessPhaseConfPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long  id;
    /**
     * 流程id
     */
    @ApiModelProperty(value = "流程id")
    private Long  pmApprovalProcessConfigId;
    /**
     * 节点类型编码
     */
    @ApiModelProperty(value = "节点类型编码")
    private String  nodeTypeCode;
    /**
     * 环节次序
     */
    @ApiModelProperty(value = "环节次序")
    private Integer  linkSequence;
    /**
     * 审批人类型
     */
    @ApiModelProperty(value = "审批人类型")
    private String  approverType;
    /**
     * 审批人名称
     */
    @ApiModelProperty(value = "审批人名称")
    private String  approverName;
    /**
     * 审批人id
     */
    @ApiModelProperty(value = "审批人id")
    private Long  approverId;
    /**
     * 是否允许转审
     */
    @ApiModelProperty(value = "是否允许转审")
    private String  isAllowTransferApproval;
    /**
     * 是否结束
     */
    @ApiModelProperty(value = "是否结束")
    private String  isEnd;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    private String  isValid;
    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String  roleCode;
    /**
     * 审核不通过退回节点ID
     */
    @ApiModelProperty(value = "审核不通过退回节点ID")
    private Long  backNodeId;
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

