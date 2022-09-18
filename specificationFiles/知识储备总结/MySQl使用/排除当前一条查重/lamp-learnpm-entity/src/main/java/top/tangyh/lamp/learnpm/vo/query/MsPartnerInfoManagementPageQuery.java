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
 * 合作方信息管理翻页查询对象
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
@ApiModel(value = "MsPartnerInfoManagementPageQuery", description = "合作方信息管理")
public class MsPartnerInfoManagementPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long  id;
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String  unitName;
    /**
     * 合作方编号
     */
    @ApiModelProperty(value = "合作方编号")
    private String  partnerCode;
    /**
     * 合作单位性质
     */
    @ApiModelProperty(value = "合作单位性质")
    private String  partnerNature;
    /**
     * 合作来源
     */
    @ApiModelProperty(value = "合作来源")
    private String  cooperationSources;
    /**
     * 合作方类别
     */
    @ApiModelProperty(value = "合作方类别")
    private String  partnerCategory;
    /**
     * 本单位业务员
     */
    @ApiModelProperty(value = "本单位业务员")
    private String  businessManager;
    /**
     * 营业执照
     */
    @ApiModelProperty(value = "营业执照")
    private String  businessLicense;
    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    private String  contactName;
    /**
     * 所属部门
     */
    @ApiModelProperty(value = "所属部门")
    private String  department;
    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    private String  post;
    /**
     * 负责产品
     */
    @ApiModelProperty(value = "负责产品")
    private String  responsibleProducts;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String  phone;
    /**
     * 公司邮箱
     */
    @ApiModelProperty(value = "公司邮箱")
    private String  companyMailbox;
    /**
     * 私人邮箱
     */
    @ApiModelProperty(value = "私人邮箱")
    private String  privateMailbox;
    /**
     * 开票单位名称
     */
    @ApiModelProperty(value = "开票单位名称")
    private String  invoicingUnitName;
    /**
     * 税号
     */
    @ApiModelProperty(value = "税号")
    private String  dutyParagraph;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String  address;
    /**
     * 开户行名称
     */
    @ApiModelProperty(value = "开户行名称")
    private String  bankBranchName;
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
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String  tel;
    /**
     * 开户行账号
     */
    @ApiModelProperty(value = "开户行账号")
    private String  account;
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

