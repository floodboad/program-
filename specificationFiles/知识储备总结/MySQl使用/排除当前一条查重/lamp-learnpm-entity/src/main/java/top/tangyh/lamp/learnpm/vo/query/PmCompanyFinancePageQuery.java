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
 * 公司财务人员翻页查询对象
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmCompanyFinancePageQuery", description = "公司财务人员")
public class PmCompanyFinancePageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long  userId;
    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    private String  phone;
    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String  userName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String  remark;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    private String  isValid;
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

