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
 * 听众信息表翻页查询对象
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
@ApiModel(value = "MsAudienceInfoPageQuery", description = "听众信息表")
public class MsAudienceInfoPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long  userId;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String  name;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String  phone;
    /**
     * 医院
     */
    @ApiModelProperty(value = "医院")
    private String  hospital;
    /**
     * 科室
     */
    @ApiModelProperty(value = "科室")
    private String  department;
    /**
     * 医生证号
     */
    @ApiModelProperty(value = "医生证号")
    private String  doctorCertificateNo;
    /**
     * 证件
     */
    @ApiModelProperty(value = "证件")
    private String  certificates;
    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态")
    private String  auditStatus;
    /**
     * openid
     */
    @ApiModelProperty(value = "openid")
    private String  openid;
    /**
     * unicode
     */
    @ApiModelProperty(value = "unicode")
    private String  unicode;
    /**
     * 来源
     */
    @ApiModelProperty(value = "来源")
    private String  source;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String  nickname;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String  sex;
    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    private String  idNo;
    /**
     * 出生年月
     */
    @ApiModelProperty(value = "出生年月")
    private Date  birthday;
    /**
     * 所在省市
     */
    @ApiModelProperty(value = "所在省市")
    private String  province;
    /**
     * 所在城市
     */
    @ApiModelProperty(value = "所在城市")
    private String  city;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String  address;
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

