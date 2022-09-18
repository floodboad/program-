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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 听众信息表实体类
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
@ApiModel(value = "MsAudienceInfoResultVO", description = "听众信息表")
public class MsAudienceInfoResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    @Excel(name = "用户id")
    private Long  userId;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Excel(name = "姓名")
    private String  name;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Excel(name = "手机号")
    private String  phone;
    /**
     * 医院
     */
    @ApiModelProperty(value = "医院")
    @Excel(name = "医院")
    private String  hospital;
    /**
     * 科室
     */
    @ApiModelProperty(value = "科室")
    @Excel(name = "科室")
    private String  department;
    /**
     * 医生证号
     */
    @ApiModelProperty(value = "医生证号")
    @Excel(name = "医生证号")
    private String  doctorCertificateNo;
    /**
     * 证件
     */
    @ApiModelProperty(value = "证件")
    @Excel(name = "证件")
    private String  certificates;
    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态")
    @Excel(name = "审核状态")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.AUDIT_STATUS)
    private String  auditStatus;
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
     * 来源
     */
    @ApiModelProperty(value = "来源")
    @Excel(name = "来源")
    private String  source;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    @Excel(name = "昵称")
    private String  nickname;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @Excel(name = "性别")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.SEX)
    private String  sex;
    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    @Excel(name = "身份证号")
    private String  idNo;
    /**
     * 出生年月
     */
    @ApiModelProperty(value = "出生年月")
    @Excel(name = "出生年月")
    private Date  birthday;
    /**
     * 所在省市
     */
    @ApiModelProperty(value = "所在省市")
    @Excel(name = "所在省市")
    private String  province;
    /**
     * 所在城市
     */
    @ApiModelProperty(value = "所在城市")
    @Excel(name = "所在城市")
    private String  city;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    @Excel(name = "详细地址")
    private String  address;
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

