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
 * 基础表更新操作记录翻页查询对象
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
@ApiModel(value = "MsUpdateOperationRecordPageQuery", description = "基础表更新操作记录")
public class MsUpdateOperationRecordPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作人员id
     */
    @ApiModelProperty(value = "操作人员id")
    private Long  operatorId;
    /**
     * 操作人员姓名
     */
    @ApiModelProperty(value = "操作人员姓名")
    private String  operatorName;
    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    private String  operatorType;
    /**
     * 更新表名称
     */
    @ApiModelProperty(value = "更新表名称")
    private String  updateTableName;
    /**
     * 更新表id
     */
    @ApiModelProperty(value = "更新表id")
    private Long  updateTableId;
    /**
     * 操作描述
     */
    @ApiModelProperty(value = "操作描述")
    private String  operatorDesc;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private Date  operatorTime;
    /**
     * ip地址
     */
    @ApiModelProperty(value = "ip地址")
    private String  ip;
    /**
     * 所在单位
     */
    @ApiModelProperty(value = "所在单位")
    private String  unit;
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

