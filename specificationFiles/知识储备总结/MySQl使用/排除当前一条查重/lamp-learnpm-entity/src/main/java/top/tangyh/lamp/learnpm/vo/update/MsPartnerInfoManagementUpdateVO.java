package top.tangyh.lamp.learnpm.vo.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.SuperEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

import top.tangyh.lamp.learnpm.entity.MsContactInfo;
import top.tangyh.lamp.learnpm.vo.save.MsContactInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsContactInfoUpdateVO;
/**
 * <p>
 *  合作方信息管理更新实体类
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
@ApiModel(value = "MsPartnerInfoManagementUpdateVO", description = "合作方信息管理")
public class MsPartnerInfoManagementUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    @Size(max = 300, message = "单位名称长度不能超过300")  
    private  String unitName;
    /**
     * 合作方编号
     */
    @ApiModelProperty(value = "合作方编号")
    @Size(max = 300, message = "合作方编号长度不能超过300")  
    private  String partnerCode;
    /**
     * 合作单位性质
     */
    @ApiModelProperty(value = "合作单位性质")
    @Size(max = 2, message = "合作单位性质长度不能超过2")  
    private  String partnerNature;
    /**
     * 合作来源
     */
    @ApiModelProperty(value = "合作来源")
    @Size(max = 2, message = "合作来源长度不能超过2")  
    private  String cooperationSources;
    /**
     * 合作方类别
     */
    @ApiModelProperty(value = "合作方类别")
    @Size(max = 2, message = "合作方类别长度不能超过2")  
    private  String partnerCategory;
    /**
     * 本单位业务员
     */
    @ApiModelProperty(value = "本单位业务员")
    @Size(max = 200, message = "本单位业务员长度不能超过200")  
    private  String businessManager;
    /**
     * 营业执照
     */
    @ApiModelProperty(value = "营业执照")
    @Size(max = 300, message = "营业执照长度不能超过300")  
    private  String businessLicense;
    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    @Size(max = 200, message = "联系人姓名长度不能超过200")  
    private  String contactName;
    /**
     * 所属部门
     */
    @ApiModelProperty(value = "所属部门")
    @Size(max = 300, message = "所属部门长度不能超过300")  
    private  String department;
    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    @Size(max = 300, message = "职务长度不能超过300")  
    private  String post;
    /**
     * 负责产品
     */
    @ApiModelProperty(value = "负责产品")
    @Size(max = 300, message = "负责产品长度不能超过300")  
    private  String responsibleProducts;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Size(max = 11, message = "手机号长度不能超过11")  
    private  String phone;
    /**
     * 公司邮箱
     */
    @ApiModelProperty(value = "公司邮箱")
    @Size(max = 300, message = "公司邮箱长度不能超过300")  
    private  String companyMailbox;
    /**
     * 私人邮箱
     */
    @ApiModelProperty(value = "私人邮箱")
    @Size(max = 300, message = "私人邮箱长度不能超过300")  
    private  String privateMailbox;
    /**
     * 开票单位名称
     */
    @ApiModelProperty(value = "开票单位名称")
    @Size(max = 300, message = "开票单位名称长度不能超过300")  
    private  String invoicingUnitName;
    /**
     * 税号
     */
    @ApiModelProperty(value = "税号")
    @Size(max = 300, message = "税号长度不能超过300")  
    private  String dutyParagraph;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    @Size(max = 300, message = "地址长度不能超过300")  
    private  String address;
    /**
     * 开户行名称
     */
    @ApiModelProperty(value = "开户行名称")
    @Size(max = 300, message = "开户行名称长度不能超过300")  
    private  String bankBranchName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 300, message = "备注长度不能超过300")  
    private  String remark;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    @Size(max = 1, message = "是否有效长度不能超过1")  
    private  String isValid;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    @Size(max = 20, message = "电话长度不能超过20")  
    private  String tel;
    /**
     * 开户行账号
     */
    @ApiModelProperty(value = "开户行账号")
    @Size(max = 300, message = "开户行账号长度不能超过300")  
    private  String account;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Size(max = 100, message = "扩展字段1长度不能超过100")  
    private  String attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Size(max = 100, message = "扩展字段2长度不能超过100")  
    private  String attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Size(max = 100, message = "扩展字段3长度不能超过100")  
    private  String attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Size(max = 100, message = "扩展字段4长度不能超过100")  
    private  String attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Size(max = 100, message = "扩展字段5长度不能超过100")  
    private  String attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Size(max = 100, message = "扩展字段6长度不能超过100")  
    private  String attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Size(max = 100, message = "扩展字段7长度不能超过100")  
    private  String attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Size(max = 100, message = "扩展字段8长度不能超过100")  
    private  String attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Size(max = 100, message = "扩展字段9长度不能超过100")  
    private  String attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Size(max = 100, message = "扩展字段10长度不能超过100")  
    private  String attribute10;
     //联系人信息插入列表
    private List<MsContactInfoSaveVO> msPartnerInfoManagementIdInsertList;
     //联系人信息更新列表
    private List<MsContactInfoUpdateVO> msPartnerInfoManagementIdUpdateList;
     //联系人信息删除列表
    private List<Long> msPartnerInfoManagementIdDeleteList;		
}
