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
import java.util.List;
import java.util.Date;


import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProcessPhaseInstanceUpdateVO;
/**
 * <p>
 *  审批流实例更新实体类
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmApprovalProcessInstanceUpdateVO", description = "审批流实例")
public class PmApprovalProcessInstanceUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    @NotNull(message = "请填写ID", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 审批流配置ID
     */
    @ApiModelProperty(value = "审批流配置ID")
    private  Long pmApprovalProcessConfigId;
    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型")
    @Size(max = 2, message = "业务类型长度不能超过2")  
    private  String businessType;
    /**
     * 业务ID
     */
    @ApiModelProperty(value = "业务ID")
    private  Long businessId;
    /**
     * 待办人
     */
    @ApiModelProperty(value = "待办人")
    @Size( message = "待办人长度不能超过")
    private  String toDoId;
    /**
     * 流程名称
     */
    @ApiModelProperty(value = "流程名称")
    @NotEmpty(message = "请填写流程名称")
    @Size(max = 300, message = "流程名称长度不能超过300")  
    private  String processName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 300, message = "备注长度不能超过300")  
    private  String remark;
    /**
     * 是否结束
     */
    @ApiModelProperty(value = "是否结束")
    @Size(max = 1, message = "是否结束长度不能超过1")  
    private  String isEnd;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private  Date endTime;
    /**
     * 业务信息
     */
    @ApiModelProperty(value = "业务信息")
    @Size( message = "业务信息长度不能超过")
    private  String businessInfo;
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
     //流程环节实例插入列表
    private List<PmProcessPhaseInstanceSaveVO> pmProcessPhaseInstancePmApprovalProcessInstanceIdInsertList;
     //流程环节实例更新列表
    private List<PmProcessPhaseInstanceUpdateVO> pmProcessPhaseInstancePmApprovalProcessInstanceIdUpdateList;
     //流程环节实例删除列表
    private List<Long> pmProcessPhaseInstancePmApprovalProcessInstanceIdDeleteList;		
}
