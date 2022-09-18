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
import java.math.BigDecimal;


/**
 * <p>
 * 会议专家劳务实体类
 * </p>
 *
 * @author dz
 * @since 2022-07-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmConferenceExpertServicesResultVO", description = "会议专家劳务")
public class PmConferenceExpertServicesResultVO extends Entity<Long> implements Serializable, EchoVO {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> echoMap = new HashMap<>();

   
	
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 项目会议申请id
     */
    @ApiModelProperty(value = "项目会议申请id")
    @Excel(name = "项目会议申请id")
    private Long  pmProjectMeetingApplyId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    @Excel(name = "项目id")
    private Long  pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    @Excel(name = "项目名称")
    private String  projectName;
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
     * 费用id
     */
    @ApiModelProperty(value = "费用id")
    @Excel(name = "费用id")
    private Long  msBudgetSubjectId;
    /**
     * 费用名称
     */
    @ApiModelProperty(value = "费用名称")
    @Excel(name = "费用名称")
    private String  feeName;
    /**
     * 费用执行标准
     */
    @ApiModelProperty(value = "费用执行标准")
    @Excel(name = "费用执行标准")
    private String  controlStandards;
    /**
     * 人数
     */
    @ApiModelProperty(value = "人数")
    @Excel(name = "人数")
    private Long  personNumber;
    /**
     * 劳务税费id
     */
    @ApiModelProperty(value = "劳务税费id")
    @Excel(name = "劳务税费id")
    private BigDecimal  serviceTaxId;
    /**
     * 劳务税费
     */
    @ApiModelProperty(value = "劳务税费")
    @Excel(name = "劳务税费")
    private BigDecimal  serviceTax;
    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    @Excel(name = "金额")
    private BigDecimal  amountMoney;
    /**
     * 专家id
     */
    @ApiModelProperty(value = "专家id")
    @Excel(name = "专家id")
    private Long  msExpertInfoId;
    /**
     * 专家姓名
     */
    @ApiModelProperty(value = "专家姓名")
    @Excel(name = "专家姓名")
    private String  expertInfoName;
    /**
     * 所属医院id
     */
    @ApiModelProperty(value = "所属医院id")
    @Excel(name = "所属医院id")
    private Long  msHospitalInfoId;
    /**
     * 所属医院
     */
    @ApiModelProperty(value = "所属医院")
    @Excel(name = "所属医院")
    private String  hospitalName;
    /**
     * 所属科室id
     */
    @ApiModelProperty(value = "所属科室id")
    @Excel(name = "所属科室id")
    private Long  msDepartmentInfoId;
    /**
     * 所属科室名称
     */
    @ApiModelProperty(value = "所属科室名称")
    @Excel(name = "所属科室名称")
    private String  departmentInfoName;
    /**
     * 专家类别
     */
    @ApiModelProperty(value = "专家类别")
    @Excel(name = "专家类别")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.EXPERTS_CATEGORY)
    private String  expertsCategory;
    /**
     * 劳务协议附件
     */
    @ApiModelProperty(value = "劳务协议附件")
    @Excel(name = "劳务协议附件")
    private String  serviceAgreementAttachment;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Excel(name = "状态")
  @Echo(api = EchoApi.DICTIONARY_ITEM_FEIGN_CLASS, dictType = EchoDictType.Learnpm.CONFERENCE_EXPERT_SERVICES_STATUS)
    private String  status;
    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同编号")
    @Excel(name = "合同编号")
    private String  contractNo;
    /**
     * 专家身份证号
     */
    @ApiModelProperty(value = "专家身份证号")
    @Excel(name = "专家身份证号")
    private String  attribute1;
    /**
     * 专家银行账号
     */
    @ApiModelProperty(value = "专家银行账号")
    @Excel(name = "专家银行账号")
    private String  attribute2;
    /**
     * 专家银行卡号
     */
    @ApiModelProperty(value = "专家银行卡号")
    @Excel(name = "专家银行卡号")
    private String  attribute3;
    /**
     * 专家手机号
     */
    @ApiModelProperty(value = "专家手机号")
    @Excel(name = "专家手机号")
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

