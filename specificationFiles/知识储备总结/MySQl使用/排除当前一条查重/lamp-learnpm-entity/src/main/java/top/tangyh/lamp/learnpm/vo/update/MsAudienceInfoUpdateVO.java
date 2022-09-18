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
import java.util.Date;


/**
 * <p>
 *  听众信息表更新实体类
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
@ApiModel(value = "MsAudienceInfoUpdateVO", description = "听众信息表")
public class MsAudienceInfoUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private  Long userId;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Size(max = 200, message = "姓名长度不能超过200")  
    private  String name;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Size(max = 11, message = "手机号长度不能超过11")  
    private  String phone;
    /**
     * 医院
     */
    @ApiModelProperty(value = "医院")
    @Size(max = 300, message = "医院长度不能超过300")  
    private  String hospital;
    /**
     * 科室
     */
    @ApiModelProperty(value = "科室")
    @Size(max = 300, message = "科室长度不能超过300")  
    private  String department;
    /**
     * 医生证号
     */
    @ApiModelProperty(value = "医生证号")
    @Size(max = 300, message = "医生证号长度不能超过300")  
    private  String doctorCertificateNo;
    /**
     * 证件
     */
    @ApiModelProperty(value = "证件")
    @Size(max = 300, message = "证件长度不能超过300")  
    private  String certificates;
    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态")
    @Size(max = 2, message = "审核状态长度不能超过2")  
    private  String auditStatus;
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
     * 来源
     */
    @ApiModelProperty(value = "来源")
    @Size(max = 300, message = "来源长度不能超过300")  
    private  String source;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    @Size(max = 200, message = "昵称长度不能超过200")  
    private  String nickname;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @Size(max = 1, message = "性别长度不能超过1")  
    private  String sex;
    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    @Size(max = 18, message = "身份证号长度不能超过18")  
    private  String idNo;
    /**
     * 出生年月
     */
    @ApiModelProperty(value = "出生年月")
    private  Date birthday;
    /**
     * 所在省市
     */
    @ApiModelProperty(value = "所在省市")
    @Size(max = 300, message = "所在省市长度不能超过300")  
    private  String province;
    /**
     * 所在城市
     */
    @ApiModelProperty(value = "所在城市")
    @Size(max = 300, message = "所在城市长度不能超过300")  
    private  String city;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    @Size(max = 300, message = "详细地址长度不能超过300")  
    private  String address;
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
}
