package top.tangyh.lamp.learnpm.vo.result;
import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import top.tangyh.basic.annotation.echo.Echo;
import top.tangyh.basic.base.entity.Entity;
import top.tangyh.basic.interfaces.echo.EchoVO;
import top.tangyh.lamp.model.constant.EchoApi;
import top.tangyh.lamp.model.constant.EchoDictType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 合作方信息管理实体类
 * </p>
 *
 * @author xucl
 * @since 2022-06-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "MsPartnerInfoManagementResultVO", description = "合作方信息管理")
public class MsPartnerInfoManagementResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    @Excel(name = "单位名称")
    private String  unitName;
    /**
     * 合作方编号
     */
    @ApiModelProperty(value = "合作方编号")
    @Excel(name = "合作方编号")
    private String  partnerCode;
    /**
     * 合作单位性质
     */
    @ApiModelProperty(value = "合作单位性质")
    @Excel(name = "合作单位性质")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.PARTNER_NATURE)
    private String  partnerNature;
    /**
     * 合作来源
     */
    @ApiModelProperty(value = "合作来源")
    @Excel(name = "合作来源")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.COOPERATION_SOURCES)
    private String  cooperationSources;
    /**
     * 合作方类别
     */
    @ApiModelProperty(value = "合作方类别")
    @Excel(name = "合作方类别")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.PARTNER_CATEGORY)
    private String  partnerCategory;
    /**
     * 本单位业务员
     */
    @ApiModelProperty(value = "本单位业务员")
    @Excel(name = "本单位业务员")
    private String  businessManager;
    /**
     * 营业执照
     */
    @ApiModelProperty(value = "营业执照")
    @Excel(name = "营业执照")
    private String  businessLicense;
    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    @Excel(name = "联系人姓名")
    private String  contactName;
    /**
     * 所属部门
     */
    @ApiModelProperty(value = "所属部门")
    @Excel(name = "所属部门")
    private String  department;
    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    @Excel(name = "职务")
    private String  post;
    /**
     * 负责产品
     */
    @ApiModelProperty(value = "负责产品")
    @Excel(name = "负责产品")
    private String  responsibleProducts;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Excel(name = "手机号")
    private String  phone;
    /**
     * 公司邮箱
     */
    @ApiModelProperty(value = "公司邮箱")
    @Excel(name = "公司邮箱")
    private String  companyMailbox;
    /**
     * 私人邮箱
     */
    @ApiModelProperty(value = "私人邮箱")
    @Excel(name = "私人邮箱")
    private String  privateMailbox;
    /**
     * 开票单位名称
     */
    @ApiModelProperty(value = "开票单位名称")
    @Excel(name = "开票单位名称")
    private String  invoicingUnitName;
    /**
     * 税号
     */
    @ApiModelProperty(value = "税号")
    @Excel(name = "税号")
    private String  dutyParagraph;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    @Excel(name = "地址")
    private String  address;
    /**
     * 开户行名称
     */
    @ApiModelProperty(value = "开户行名称")
    @Excel(name = "开户行名称")
    private String  bankBranchName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Excel(name = "备注")
    private String  remark;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    @Excel(name = "是否有效")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.IS_VALID)
    private String  isValid;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    @Excel(name = "电话")
    private String  tel;
    /**
     * 开户行账号
     */
    @ApiModelProperty(value = "开户行账号")
    @Excel(name = "开户行账号")
    private String  account;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Excel(name = "扩展字段1")
    private String  attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Excel(name = "扩展字段2")
    private String  attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Excel(name = "扩展字段3")
    private String  attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Excel(name = "扩展字段4")
    private String  attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Excel(name = "扩展字段5")
    private String  attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Excel(name = "扩展字段6")
    private String  attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Excel(name = "扩展字段7")
    private String  attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Excel(name = "扩展字段8")
    private String  attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Excel(name = "扩展字段9")
    private String  attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Excel(name = "扩展字段10")
    private String  attribute10;
}

