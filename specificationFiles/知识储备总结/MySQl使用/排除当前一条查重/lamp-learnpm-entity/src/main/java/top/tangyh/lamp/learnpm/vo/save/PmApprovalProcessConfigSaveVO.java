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
import java.util.List;

import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseConfSaveVO;
/**
 * <p>
 * 审批流配置实体类
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
@ApiModel(value = "PmApprovalProcessConfigSaveVO", description = "审批流配置")
public class PmApprovalProcessConfigSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流程名称
     */
    @ApiModelProperty(value = "流程名称")
    @NotEmpty(message = "请填写流程名称")
    @Size(max = 300, message = "流程名称长度不能超过300")
    private String   processName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 300, message = "备注长度不能超过300")
    private String   remark;
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
        //流程环节配置列表
    private List<PmProcessPhaseConfSaveVO> pmProcessPhaseConfPmApprovalProcessConfigIdInsertList;		
}
