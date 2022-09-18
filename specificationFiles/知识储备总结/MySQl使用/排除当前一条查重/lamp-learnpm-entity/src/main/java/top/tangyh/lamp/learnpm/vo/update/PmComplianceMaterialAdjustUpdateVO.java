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
 *  项目合规材料调整更新实体类
 * </p>
 *
 * @author liyy
 * @date 2022-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmComplianceMaterialAdjustUpdateVO", description = "项目合规材料调整")
public class PmComplianceMaterialAdjustUpdateVO implements Serializable {

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
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    private  Long pmProjectMeetingPlanningId;
    /**
     * 合规材料id
     */
    @ApiModelProperty(value = "合规材料id")
    private  Long pmComplianceMaterialsId;
    /**
     * 合规材料名称
     */
    @ApiModelProperty(value = "合规材料名称")
    @Size(max = 300, message = "合规材料名称长度不能超过300")  
    private  String complianceMaterialsName;
    /**
     * 会议规划调整id
     */
    @ApiModelProperty(value = "会议规划调整id")
    private  Long pmProjectMeetingPlanAdjustId;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Size(max = 300, message = "说明长度不能超过300")  
    private  String illustrate;
}
