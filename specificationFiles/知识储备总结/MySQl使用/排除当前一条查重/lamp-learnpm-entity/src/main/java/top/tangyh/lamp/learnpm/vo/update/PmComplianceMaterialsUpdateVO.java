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
 *  项目合规材料更新实体类
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmComplianceMaterialsUpdateVO", description = "项目合规材料")
public class PmComplianceMaterialsUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private  Long pmProjectId;
    /**
     * 合规材料名称
     */
    @ApiModelProperty(value = "合规材料名称")
    @Size(max = 300, message = "合规材料名称长度不能超过300")  
    private  String complianceMaterialsName;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Size(max = 300, message = "说明长度不能超过300")  
    private  String illustrate;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    @Size(max = 1, message = "是否有效长度不能超过1")  
    private  String isValid;
    /**
     * 项目合规文件定义ID
     */
    @ApiModelProperty(value = "项目合规文件定义ID")
    private  Long msPjComplianceFileDefId;
    /**
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    private  Long pmProjectMeetingPlanningId;
}
