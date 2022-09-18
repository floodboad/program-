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

/**
 * <p>
 * 会议执行要求实体类
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
@ApiModel(value = "PmMeetingExecutionReqResultVO", description = "会议执行要求")
public class PmMeetingExecutionReqResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    @Excel(name = "项目会议规划id")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    @Excel(name = "项目会议规划名称")
    private String  projectMeetingPlanningName;
    /**
     * 会议执行环节
     */
    @ApiModelProperty(value = "会议执行环节")
    @Excel(name = "会议执行环节")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.MEETING_EXECUTION_LINK)
    private String  meetingExecutionLink;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Excel(name = "说明")
    private String  illustrate;
    /**
     * 执行方式
     */
    @ApiModelProperty(value = "执行方式")
    @Excel(name = "执行方式")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.EXECUTION_MODE)
    private String  executionMode;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id")
    @Excel(name = "单位id")
    private Long  unitId;
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    @Excel(name = "单位名称")
    private String  unitName;
    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    @Excel(name = "负责人id")
    private Long  chargePersonId;
    /**
     * 负责人姓名
     */
    @ApiModelProperty(value = "负责人姓名")
    @Excel(name = "负责人姓名")
    private String  chargePersonName;
    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    @Excel(name = "负责人手机号")
    private String  chargePhone;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Excel(name = "备注")
    private String  remark;
    /**
     * 会议范围
     */
    @ApiModelProperty(value = "会议范围")
    @Excel(name = "会议范围")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.MEETING_RANGE)
    private String  meetingRange;
    /**
     * 是否有观看条件
     */
    @ApiModelProperty(value = "是否有观看条件")
    @Excel(name = "是否有观看条件")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isViewingConditions;
    /**
     * 填写信息内容要求
     */
    @ApiModelProperty(value = "填写信息内容要求")
    @Excel(name = "填写信息内容要求")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.FILL_INFO_CONTENT_REQ)
    private String  fillInfoContentReq;
    /**
     * 是否填写姓名
     */
    @ApiModelProperty(value = "是否填写姓名")
    @Excel(name = "是否填写姓名")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isFillName;
    /**
     * 是否填写手机号
     */
    @ApiModelProperty(value = "是否填写手机号")
    @Excel(name = "是否填写手机号")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isFillPhone;
    /**
     * 是否上传医生证明
     */
    @ApiModelProperty(value = "是否上传医生证明")
    @Excel(name = "是否上传医生证明")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  doctorCertificate;
    /**
     * 是否填写医院
     */
    @ApiModelProperty(value = "是否填写医院")
    @Excel(name = "是否填写医院")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isFillHospital;
    /**
     * 是否填写科室
     */
    @ApiModelProperty(value = "是否填写科室")
    @Excel(name = "是否填写科室")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isFillDepartment;
    /**
     * 是否填写职称
     */
    @ApiModelProperty(value = "是否填写职称")
    @Excel(name = "是否填写职称")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.RM_YES_NOT)
    private String  isFillPost;
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

