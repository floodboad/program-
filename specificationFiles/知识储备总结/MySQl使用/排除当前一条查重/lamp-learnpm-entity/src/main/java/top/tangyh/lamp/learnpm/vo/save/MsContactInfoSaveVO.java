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
 * 联系人信息实体类
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "MsContactInfoSaveVO", description = "联系人信息")
public class MsContactInfoSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 合作单位ID
     */
    @ApiModelProperty(value = "合作单位ID")
    private Long   msPartnerInfoManagementId;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Size(max = 200, message = "姓名长度不能超过200")
    private String   name;
    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    @Size(max = 300, message = "部门长度不能超过300")
    private String   department;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Size(max = 11, message = "手机号长度不能超过11")
    private String   phone;
    /**
     * 电子邮箱
     */
    @ApiModelProperty(value = "电子邮箱")
    @Size(max = 300, message = "电子邮箱长度不能超过300")
    private String   email;
    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
    @Size(max = 300, message = "职位长度不能超过300")
    private String   post;
    /**
     * 负责产品
     */
    @ApiModelProperty(value = "负责产品")
    @Size(max = 300, message = "负责产品长度不能超过300")
    private String   responsibleProducts;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 300, message = "备注长度不能超过300")
    private String   remark;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    @Size(max = 1, message = "是否有效长度不能超过1")
    private String   isValid;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Size(max = 100, message = "扩展字段1长度不能超过100")
    private String   attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Size(max = 100, message = "扩展字段2长度不能超过100")
    private String   attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Size(max = 100, message = "扩展字段3长度不能超过100")
    private String   attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Size(max = 100, message = "扩展字段4长度不能超过100")
    private String   attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Size(max = 100, message = "扩展字段5长度不能超过100")
    private String   attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Size(max = 100, message = "扩展字段6长度不能超过100")
    private String   attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Size(max = 100, message = "扩展字段7长度不能超过100")
    private String   attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Size(max = 100, message = "扩展字段8长度不能超过100")
    private String   attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Size(max = 100, message = "扩展字段9长度不能超过100")
    private String   attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Size(max = 100, message = "扩展字段10长度不能超过100")
    private String   attribute10;
}
