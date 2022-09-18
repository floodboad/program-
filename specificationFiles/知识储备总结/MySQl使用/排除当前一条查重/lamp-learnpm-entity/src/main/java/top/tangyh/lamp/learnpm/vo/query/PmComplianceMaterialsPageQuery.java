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
 * 项目合规材料翻页查询对象
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
@ApiModel(value = "PmComplianceMaterialsPageQuery", description = "项目合规材料")
public class PmComplianceMaterialsPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long  id;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long  pmProjectId;
    /**
     * 合规材料名称
     */
    @ApiModelProperty(value = "合规材料名称")
    private String  complianceMaterialsName;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String  illustrate;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    private String  isValid;
    /**
     * 项目合规文件定义ID
     */
    @ApiModelProperty(value = "项目合规文件定义ID")
    private Long  msPjComplianceFileDefId;
    /**
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    private Long  pmProjectMeetingPlanningId;
}

