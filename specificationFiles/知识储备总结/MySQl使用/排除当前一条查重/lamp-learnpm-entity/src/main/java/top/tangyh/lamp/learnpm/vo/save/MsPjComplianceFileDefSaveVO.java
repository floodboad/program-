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


/**
 * <p>
 * 项目合规文件定义实体类
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
@ApiModel(value = "MsPjComplianceFileDefSaveVO", description = "项目合规文件定义")
public class MsPjComplianceFileDefSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 合规文件名称
     */
    @ApiModelProperty(value = "合规文件名称")
    @Size(max = 300, message = "合规文件名称长度不能超过300")
    private String   complianceFileName;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Size(max = 300, message = "说明长度不能超过300")
    private String   illustrate;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    @Size(max = 1, message = "是否有效长度不能超过1")
    private String   isValid;
    /**
     * 会议执行环节
     */
    @ApiModelProperty(value = "会议执行环节")
    @Size(max = 2, message = "会议执行环节长度不能超过2")
    private String   meetingExecutionLink;
}
