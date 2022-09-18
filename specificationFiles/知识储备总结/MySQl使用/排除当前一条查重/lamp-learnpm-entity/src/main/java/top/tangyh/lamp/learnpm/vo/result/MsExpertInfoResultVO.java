package top.tangyh.lamp.learnpm.vo.result;
import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.Entity;
import top.tangyh.basic.interfaces.echo.EchoVO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import top.tangyh.lamp.model.constant.EchoDictType;
import top.tangyh.lamp.model.constant.EchoApi;
import top.tangyh.basic.annotation.echo.Echo;
import java.util.Date;


/**
 * <p>
 * 专家信息实体类
 * </p>
 *
 * @author xucl
 * @since 2022-06-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "MsExpertInfoResultVO", description = "专家信息")
public class MsExpertInfoResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Excel(name = "姓名")
    private String  name;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @Excel(name = "性别")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.SEX)
    private String  sex;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    @Excel(name = "电话")
    private String  tel;
    /**
     * 证件类型
     */
    @ApiModelProperty(value = "证件类型")
    @Excel(name = "证件类型")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.CERTIFICATE_TYPE)
    private String  certificateType;
    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码")
    @Excel(name = "证件号码")
    private String  certificateCode;
    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    @Excel(name = "出生日期")
    private Date  birthday;
    /**
     * 通讯地址
     */
    @ApiModelProperty(value = "通讯地址")
    @Excel(name = "通讯地址")
    private String  postalAddress;
    /**
     * 任职医院
     */
    @ApiModelProperty(value = "任职医院")
    @Excel(name = "任职医院")
    private String  workingHospital;
    /**
     * 任职科室
     */
    @ApiModelProperty(value = "任职科室")
    @Excel(name = "任职科室")
    private String  department;
    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    @Excel(name = "职务")
    private String  post;
    /**
     * 开户行名称
     */
    @ApiModelProperty(value = "开户行名称")
    @Excel(name = "开户行名称")
    private String  bankBranchName;
    /**
     * 开户行账号
     */
    @ApiModelProperty(value = "开户行账号")
    @Excel(name = "开户行账号")
    private String  account;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @Excel(name = "头像")
    private String  headPortrait;
    /**
     * 专家简介
     */
    @ApiModelProperty(value = "专家简介")
    @Excel(name = "专家简介")
    private String  expertProfile;
    /**
     * 最高学历
     */
    @ApiModelProperty(value = "最高学历")
    @Excel(name = "最高学历")
    private String  highestEducation;
    /**
     * 学位
     */
    @ApiModelProperty(value = "学位")
    @Excel(name = "学位")
    private String  academicDegree;
    /**
     * 参加工作时间
     */
    @ApiModelProperty(value = "参加工作时间")
    @Excel(name = "参加工作时间")
    private Date  workDate;
    /**
     * 毕业院校
     */
    @ApiModelProperty(value = "毕业院校")
    @Excel(name = "毕业院校")
    private String  graduateSchool;
    /**
     * 专业
     */
    @ApiModelProperty(value = "专业")
    @Excel(name = "专业")
    private String  major;
    /**
     * 专业特长
     */
    @ApiModelProperty(value = "专业特长")
    @Excel(name = "专业特长")
    private String  specialty;
    /**
     * 技术职称
     */
    @ApiModelProperty(value = "技术职称")
    @Excel(name = "技术职称")
    private String  technicalTitle;
    /**
     * openid
     */
    @ApiModelProperty(value = "openid")
    @Excel(name = "openid")
    private String  openid;
    /**
     * unicode
     */
    @ApiModelProperty(value = "unicode")
    @Excel(name = "unicode")
    private String  unicode;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Excel(name = "状态")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.EXPERT_STATUS)
    private String  status;
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

