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
import top.tangyh.lamp.model.constant.EchoApi;
import top.tangyh.lamp.model.constant.EchoDictType;
import top.tangyh.basic.annotation.echo.Echo;

/**
 * <p>
 * 收发件人实体类
 * </p>
 *
 * @author zhaoxl
 * @since 2022-07-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmSenderReceiverResultVO", description = "收发件人")
public class PmSenderReceiverResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "ID")
    private Long id;
    /**
     * 所属用户ID
     */
    @ApiModelProperty(value = "所属用户ID")
    @Excel(name = "所属用户ID")
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
     * 省份
     */
    @ApiModelProperty(value = "省份")
    @Excel(name = "省份")
    private String  province;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    @Excel(name = "城市")
    private String  city;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    @Excel(name = "详细地址")
    private String  address;
    /**
     * 是否发件人
     */
    @ApiModelProperty(value = "是否发件人")
    @Excel(name = "是否发件人")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isSender;
    /**
     * 是否默认
     */
    @ApiModelProperty(value = "是否默认")
    @Excel(name = "是否默认")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isDefault;
}

