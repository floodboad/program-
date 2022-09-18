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
 * 项目合规材料调整翻页查询对象
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
@ApiModel(value = "PmComplianceMaterialAdjustPageQuery", description = "项目合规材料调整")
public class PmComplianceMaterialAdjustPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long  pmProjectId;
    /**
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 合规材料id
     */
    @ApiModelProperty(value = "合规材料id")
    private Long  pmComplianceMaterialsId;
    /**
     * 合规材料名称
     */
    @ApiModelProperty(value = "合规材料名称")
    private String  complianceMaterialsName;
    /**
     * 会议规划调整id
     */
    @ApiModelProperty(value = "会议规划调整id")
    private Long  pmProjectMeetingPlanAdjustId;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String  illustrate;
}

