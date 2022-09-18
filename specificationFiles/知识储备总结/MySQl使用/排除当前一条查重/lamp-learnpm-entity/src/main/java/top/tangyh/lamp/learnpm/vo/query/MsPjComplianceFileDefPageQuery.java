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
 * 项目合规文件定义翻页查询对象
 * </p>
 *
 * @author xucl
 * @date 2022-07-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "MsPjComplianceFileDefPageQuery", description = "项目合规文件定义")
public class MsPjComplianceFileDefPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 合规文件名称
     */
    @ApiModelProperty(value = "合规文件名称")
    private String  complianceFileName;
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
     * 会议执行环节
     */
    @ApiModelProperty(value = "会议执行环节")
    private String  meetingExecutionLink;
}

