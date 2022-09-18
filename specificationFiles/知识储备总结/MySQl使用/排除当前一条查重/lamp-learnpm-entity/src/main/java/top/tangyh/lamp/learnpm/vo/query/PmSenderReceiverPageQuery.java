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
 * 收发件人翻页查询对象
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
@ApiModel(value = "PmSenderReceiverPageQuery", description = "收发件人")
public class PmSenderReceiverPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属用户ID
     */
    @ApiModelProperty(value = "所属用户ID")
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
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String  province;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String  city;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String  address;
    /**
     * 是否发件人
     */
    @ApiModelProperty(value = "是否发件人")
    private String  isSender;
    /**
     * 是否默认
     */
    @ApiModelProperty(value = "是否默认")
    private String  isDefault;
}

