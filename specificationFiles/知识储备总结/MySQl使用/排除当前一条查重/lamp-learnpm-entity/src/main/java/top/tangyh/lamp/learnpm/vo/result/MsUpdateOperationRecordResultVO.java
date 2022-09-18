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
import java.util.Date;


/**
 * <p>
 * 基础表更新操作记录实体类
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
@ApiModel(value = "MsUpdateOperationRecordResultVO", description = "基础表更新操作记录")
public class MsUpdateOperationRecordResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 操作人员id
     */
    @ApiModelProperty(value = "操作人员id")
    @Excel(name = "操作人员id")
    private Long  operatorId;
    /**
     * 操作人员姓名
     */
    @ApiModelProperty(value = "操作人员姓名")
    @Excel(name = "操作人员姓名")
    private String  operatorName;
    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    @Excel(name = "操作类型")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.OPERATOR_TYPE)
    private String  operatorType;
    /**
     * 更新表名称
     */
    @ApiModelProperty(value = "更新表名称")
    @Excel(name = "更新表名称")
    private String  updateTableName;
    /**
     * 更新表id
     */
    @ApiModelProperty(value = "更新表id")
    @Excel(name = "更新表id")
    private Long  updateTableId;
    /**
     * 操作描述
     */
    @ApiModelProperty(value = "操作描述")
    @Excel(name = "操作描述")
    private String  operatorDesc;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    @Excel(name = "操作时间")
    private Date  operatorTime;
    /**
     * ip地址
     */
    @ApiModelProperty(value = "ip地址")
    @Excel(name = "ip地址")
    private String  ip;
    /**
     * 所在单位
     */
    @ApiModelProperty(value = "所在单位")
    @Excel(name = "所在单位")
    private String  unit;
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

