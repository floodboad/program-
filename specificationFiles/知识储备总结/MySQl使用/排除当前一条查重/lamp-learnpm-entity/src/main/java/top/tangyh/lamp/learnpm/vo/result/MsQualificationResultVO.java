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
 * 资格证书实体类
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
@ApiModel(value = "MsQualificationResultVO", description = "资格证书")
public class MsQualificationResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 专家信息id
     */
    @ApiModelProperty(value = "专家信息id")
    @Excel(name = "专家信息id")
    private Long  msExpertInfoId;
    /**
     * 证书名称
     */
    @ApiModelProperty(value = "证书名称")
    @Excel(name = "证书名称")
    private String  certificateName;
    /**
     * 专业类别
     */
    @ApiModelProperty(value = "专业类别")
    @Excel(name = "专业类别")
    private String  specialtyCategory;
    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    @Excel(name = "等级")
    private String  level;
    /**
     * 发证日期
     */
    @ApiModelProperty(value = "发证日期")
    @Excel(name = "发证日期")
    private Date  issueDate;
    /**
     * 有效日期
     */
    @ApiModelProperty(value = "有效日期")
    @Excel(name = "有效日期")
    private Date  effectiveDate;
    /**
     * 颁布单位
     */
    @ApiModelProperty(value = "颁布单位")
    @Excel(name = "颁布单位")
    private String  publishUnit;
    /**
     * 扫描件
     */
    @ApiModelProperty(value = "扫描件")
    @Excel(name = "扫描件")
    private String  scanningCopy;
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

