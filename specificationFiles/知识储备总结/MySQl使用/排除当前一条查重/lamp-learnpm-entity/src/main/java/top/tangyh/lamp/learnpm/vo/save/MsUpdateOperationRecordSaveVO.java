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
import java.util.Date;



/**
 * <p>
 * 基础表更新操作记录实体类
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
@ApiModel(value = "MsUpdateOperationRecordSaveVO", description = "基础表更新操作记录")
public class MsUpdateOperationRecordSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作人员id
     */
    @ApiModelProperty(value = "操作人员id")
    private Long   operatorId;
    /**
     * 操作人员姓名
     */
    @ApiModelProperty(value = "操作人员姓名")
    @Size(max = 200, message = "操作人员姓名长度不能超过200")
    private String   operatorName;
    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    @Size(max = 2, message = "操作类型长度不能超过2")
    private String   operatorType;
    /**
     * 更新表名称
     */
    @ApiModelProperty(value = "更新表名称")
    @Size(max = 300, message = "更新表名称长度不能超过300")
    private String   updateTableName;
    /**
     * 更新表id
     */
    @ApiModelProperty(value = "更新表id")
    private Long   updateTableId;
    /**
     * 操作描述
     */
    @ApiModelProperty(value = "操作描述")
    @Size(max = 300, message = "操作描述长度不能超过300")
    private String   operatorDesc;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private Date   operatorTime;
    /**
     * ip地址
     */
    @ApiModelProperty(value = "ip地址")
    @Size(max = 300, message = "ip地址长度不能超过300")
    private String   ip;
    /**
     * 所在单位
     */
    @ApiModelProperty(value = "所在单位")
    @Size(max = 300, message = "所在单位长度不能超过300")
    private String   unit;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Size(max = 100, message = "扩展字段1长度不能超过100")
    private String   attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Size(max = 100, message = "扩展字段2长度不能超过100")
    private String   attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Size(max = 100, message = "扩展字段3长度不能超过100")
    private String   attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Size(max = 100, message = "扩展字段4长度不能超过100")
    private String   attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Size(max = 100, message = "扩展字段5长度不能超过100")
    private String   attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Size(max = 100, message = "扩展字段6长度不能超过100")
    private String   attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Size(max = 100, message = "扩展字段7长度不能超过100")
    private String   attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Size(max = 100, message = "扩展字段8长度不能超过100")
    private String   attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Size(max = 100, message = "扩展字段9长度不能超过100")
    private String   attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Size(max = 100, message = "扩展字段10长度不能超过100")
    private String   attribute10;
}
