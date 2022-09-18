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
import java.util.Date;


import top.tangyh.lamp.learnpm.entity.MsExpertBankCardInfo;
import top.tangyh.lamp.learnpm.vo.save.MsExpertBankCardInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExpertBankCardInfoUpdateVO;
import top.tangyh.lamp.learnpm.entity.MsQualification;
import top.tangyh.lamp.learnpm.vo.save.MsQualificationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsQualificationUpdateVO;
import top.tangyh.lamp.learnpm.entity.MsWorkExperience;
import top.tangyh.lamp.learnpm.vo.save.MsWorkExperienceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsWorkExperienceUpdateVO;
/**
 * <p>
 *  专家信息更新实体类
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
@ApiModel(value = "MsExpertInfoUpdateVO", description = "专家信息")
public class MsExpertInfoUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Size(max = 200, message = "姓名长度不能超过200")  
    private  String name;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @Size(max = 1, message = "性别长度不能超过1")  
    private  String sex;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    @Size(max = 20, message = "电话长度不能超过20")  
    private  String tel;
    /**
     * 证件类型
     */
    @ApiModelProperty(value = "证件类型")
    @Size(max = 2, message = "证件类型长度不能超过2")  
    private  String certificateType;
    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码")
    @Size(max = 300, message = "证件号码长度不能超过300")  
    private  String certificateCode;
    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private  Date birthday;
    /**
     * 通讯地址
     */
    @ApiModelProperty(value = "通讯地址")
    @Size(max = 300, message = "通讯地址长度不能超过300")  
    private  String postalAddress;
    /**
     * 任职医院
     */
    @ApiModelProperty(value = "任职医院")
    @Size(max = 300, message = "任职医院长度不能超过300")  
    private  String workingHospital;
    /**
     * 任职科室
     */
    @ApiModelProperty(value = "任职科室")
    @Size(max = 300, message = "任职科室长度不能超过300")  
    private  String department;
    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    @Size(max = 300, message = "职务长度不能超过300")  
    private  String post;
    /**
     * 开户行名称
     */
    @ApiModelProperty(value = "开户行名称")
    @Size(max = 300, message = "开户行名称长度不能超过300")  
    private  String bankBranchName;
    /**
     * 开户行账号
     */
    @ApiModelProperty(value = "开户行账号")
    @Size(max = 300, message = "开户行账号长度不能超过300")  
    private  String account;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @Size(max = 300, message = "头像长度不能超过300")  
    private  String headPortrait;
    /**
     * 专家简介
     */
    @ApiModelProperty(value = "专家简介")
    @Size(max = 300, message = "专家简介长度不能超过300")  
    private  String expertProfile;
    /**
     * 最高学历
     */
    @ApiModelProperty(value = "最高学历")
    @Size(max = 300, message = "最高学历长度不能超过300")  
    private  String highestEducation;
    /**
     * 学位
     */
    @ApiModelProperty(value = "学位")
    @Size(max = 300, message = "学位长度不能超过300")  
    private  String academicDegree;
    /**
     * 参加工作时间
     */
    @ApiModelProperty(value = "参加工作时间")
    private  Date workDate;
    /**
     * 毕业院校
     */
    @ApiModelProperty(value = "毕业院校")
    @Size(max = 300, message = "毕业院校长度不能超过300")  
    private  String graduateSchool;
    /**
     * 专业
     */
    @ApiModelProperty(value = "专业")
    @Size(max = 300, message = "专业长度不能超过300")  
    private  String major;
    /**
     * 专业特长
     */
    @ApiModelProperty(value = "专业特长")
    @Size(max = 300, message = "专业特长长度不能超过300")  
    private  String specialty;
    /**
     * 技术职称
     */
    @ApiModelProperty(value = "技术职称")
    @Size(max = 300, message = "技术职称长度不能超过300")  
    private  String technicalTitle;
    /**
     * openid
     */
    @ApiModelProperty(value = "openid")
    @Size(max = 300, message = "openid长度不能超过300")  
    private  String openid;
    /**
     * unicode
     */
    @ApiModelProperty(value = "unicode")
    @Size(max = 300, message = "unicode长度不能超过300")  
    private  String unicode;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Size(max = 2, message = "状态长度不能超过2")  
    private  String status;
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
     //专家银行卡信息插入列表
    private List<MsExpertBankCardInfoSaveVO> msExpertBankCardInfoMsExpertInfoIdInsertList;
     //专家银行卡信息更新列表
    private List<MsExpertBankCardInfoUpdateVO> msExpertBankCardInfoMsExpertInfoIdUpdateList;
     //专家银行卡信息删除列表
    private List<Long> msExpertBankCardInfoMsExpertInfoIdDeleteList;		
     //资格证书插入列表
    private List<MsQualificationSaveVO> msQualificationMsExpertInfoIdInsertList;
     //资格证书更新列表
    private List<MsQualificationUpdateVO> msQualificationMsExpertInfoIdUpdateList;
     //资格证书删除列表
    private List<Long> msQualificationMsExpertInfoIdDeleteList;		
     //工作经历插入列表
    private List<MsWorkExperienceSaveVO> msWorkExperienceMsExpertInfoIdInsertList;
     //工作经历更新列表
    private List<MsWorkExperienceUpdateVO> msWorkExperienceMsExpertInfoIdUpdateList;
     //工作经历删除列表
    private List<Long> msWorkExperienceMsExpertInfoIdDeleteList;		
}
