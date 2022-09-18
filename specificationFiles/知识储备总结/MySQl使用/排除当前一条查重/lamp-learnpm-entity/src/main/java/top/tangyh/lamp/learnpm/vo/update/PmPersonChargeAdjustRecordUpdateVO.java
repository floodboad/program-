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
 *  项目负责人及规划负责人调整记录更新实体类
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
@ApiModel(value = "PmPersonChargeAdjustRecordUpdateVO", description = "项目负责人及规划负责人调整记录")
public class PmPersonChargeAdjustRecordUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 项目角色
     */
    @ApiModelProperty(value = "项目角色")
    @Size(max = 2, message = "项目角色长度不能超过2")  
    private  String projectRole;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private  Long pmProjectId;
    /**
     * 会议规划id
     */
    @ApiModelProperty(value = "会议规划id")
    private  Long pmProjectMeetingPlanningId;
    /**
     * 原负责人id
     */
    @ApiModelProperty(value = "原负责人id")
    private  Long originalPrincipalId;
    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    @Size(max = 11, message = "负责人手机号长度不能超过11")  
    private  String originalPrincipalPhone;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Size(max = 200, message = "姓名长度不能超过200")  
    private  String name;
    /**
     * 现在负责人id
     */
    @ApiModelProperty(value = "现在负责人id")
    private  Long nowPrincipalId;
    /**
     * 现负责人人姓名
     */
    @ApiModelProperty(value = "现负责人人姓名")
    @Size(max = 200, message = "现负责人人姓名长度不能超过200")  
    private  String nowPrincipalName;
    /**
     * 现负责人手机
     */
    @ApiModelProperty(value = "现负责人手机")
    @Size(max = 11, message = "现负责人手机长度不能超过11")  
    private  String nowPrincipalPhone;
    /**
     * 调整原因
     */
    @ApiModelProperty(value = "调整原因")
    @Size(max = 300, message = "调整原因长度不能超过300")  
    private  String adjustReason;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Size(max = 2, message = "状态长度不能超过2")  
    private  String status;
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
