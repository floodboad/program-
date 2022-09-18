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
import java.util.Date;


/**
 * <p>
 * 审批流实例翻页查询对象
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
@ApiModel(value = "PmApprovalProcessInstancePageQuery", description = "审批流实例")
public class PmApprovalProcessInstancePageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Long  id;
    /**
     * 审批流配置ID
     */
    @ApiModelProperty(value = "审批流配置ID")
    private Long  pmApprovalProcessConfigId;
    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型")
    private String  businessType;
    /**
     * 业务ID
     */
    @ApiModelProperty(value = "业务ID")
    private Long  businessId;
    /**
     * 待办人
     */
    @ApiModelProperty(value = "待办人")
    private String  toDoId;
    /**
     * 流程名称
     */
    @ApiModelProperty(value = "流程名称")
    private String  processName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String  remark;
    /**
     * 是否结束
     */
    @ApiModelProperty(value = "是否结束")
    private String  isEnd;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private Date  endTime;
    /**
     * 业务信息
     */
    @ApiModelProperty(value = "业务信息")
    private String  businessInfo;
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

