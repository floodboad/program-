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
 * 收发件人实体类
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmSenderReceiverSaveVO", description = "收发件人")
public class PmSenderReceiverSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属用户ID
     */
    @ApiModelProperty(value = "所属用户ID")
    private Long   userId;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Size(max = 200, message = "姓名长度不能超过200")
    private String   name;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Size(max = 11, message = "手机号长度不能超过11")
    private String   phone;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    @Size(max = 300, message = "省份长度不能超过300")
    private String   province;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    @Size(max = 300, message = "城市长度不能超过300")
    private String   city;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    @Size(max = 300, message = "详细地址长度不能超过300")
    private String   address;
    /**
     * 是否发件人
     */
    @ApiModelProperty(value = "是否发件人")
    @Size(max = 1, message = "是否发件人长度不能超过1")
    private String   isSender;
    /**
     * 是否默认
     */
    @ApiModelProperty(value = "是否默认")
    @Size(max = 1, message = "是否默认长度不能超过1")
    private String   isDefault;
}
