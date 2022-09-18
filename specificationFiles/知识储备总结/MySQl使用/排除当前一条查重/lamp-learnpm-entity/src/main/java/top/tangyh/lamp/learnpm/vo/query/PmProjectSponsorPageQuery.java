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
import java.math.BigDecimal;


/**
 * <p>
 * 项目赞助企业翻页查询对象
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
@ApiModel(value = "PmProjectSponsorPageQuery", description = "项目赞助企业")
public class PmProjectSponsorPageQuery implements Serializable {

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
     * 赞助企业id
     */
    @ApiModelProperty(value = "赞助企业id")
    private Long  sponsorId;
    /**
     * 赞助企业名称
     */
    @ApiModelProperty(value = "赞助企业名称")
    private String  sponsorName;
    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private BigDecimal  amountMoney;
    /**
     * 税费
     */
    @ApiModelProperty(value = "税费")
    private BigDecimal  taxation;
    /**
     * 管理费
     */
    @ApiModelProperty(value = "管理费")
    private BigDecimal  managementExpense;
    /**
     * 系统维护费
     */
    @ApiModelProperty(value = "系统维护费")
    private BigDecimal  systemMaintenanceCost;
    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String  contacts;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String  contactNumber;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private String  attachment;
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

