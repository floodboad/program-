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
 * 项目负责人及规划负责人调整记录实体类
 * </p>
 *
 * @author zhaoxl
 * @since 2022-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmPersonChargeAdjustRecordResultVO", description = "项目负责人及规划负责人调整记录")
public class PmPersonChargeAdjustRecordResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 项目角色
     */
    @ApiModelProperty(value = "项目角色")
    @Excel(name = "项目角色")
    private String  projectRole;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    @Excel(name = "项目id")
    private Long  pmProjectId;
    /**
     * 会议规划id
     */
    @ApiModelProperty(value = "会议规划id")
    @Excel(name = "会议规划id")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 原负责人id
     */
    @ApiModelProperty(value = "原负责人id")
    @Excel(name = "原负责人id")
    private Long  originalPrincipalId;
    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    @Excel(name = "负责人手机号")
    private String  originalPrincipalPhone;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Excel(name = "姓名")
    private String  name;
    /**
     * 现在负责人id
     */
    @ApiModelProperty(value = "现在负责人id")
    @Excel(name = "现在负责人id")
    private Long  nowPrincipalId;
    /**
     * 现负责人人姓名
     */
    @ApiModelProperty(value = "现负责人人姓名")
    @Excel(name = "现负责人人姓名")
    private String  nowPrincipalName;
    /**
     * 现负责人手机
     */
    @ApiModelProperty(value = "现负责人手机")
    @Excel(name = "现负责人手机")
    private String  nowPrincipalPhone;
    /**
     * 调整原因
     */
    @ApiModelProperty(value = "调整原因")
    @Excel(name = "调整原因")
    private String  adjustReason;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Excel(name = "状态")
    @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.IS_VALID)
    private String  status;
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

