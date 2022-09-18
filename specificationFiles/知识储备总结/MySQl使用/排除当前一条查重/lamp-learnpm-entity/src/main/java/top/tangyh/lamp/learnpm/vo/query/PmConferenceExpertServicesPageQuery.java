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
import java.math.BigDecimal;


/**
 * <p>
 * 会议专家劳务翻页查询对象
 * </p>
 *
 * @author dz
 * @date 2022-07-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmConferenceExpertServicesPageQuery", description = "会议专家劳务")
public class PmConferenceExpertServicesPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long  id;
    /**
     * 项目会议申请id
     */
    @ApiModelProperty(value = "项目会议申请id")
    private Long  pmProjectMeetingApplyId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long  pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String  projectName;
    /**
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    private Long  pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    private String  projectMeetingPlanningName;
    /**
     * 费用id
     */
    @ApiModelProperty(value = "费用id")
    private Long  msBudgetSubjectId;
    /**
     * 费用名称
     */
    @ApiModelProperty(value = "费用名称")
    private String  feeName;
    /**
     * 费用执行标准
     */
    @ApiModelProperty(value = "费用执行标准")
    private String  controlStandards;
    /**
     * 人数
     */
    @ApiModelProperty(value = "人数")
    private Long  personNumber;
    /**
     * 劳务税费id
     */
    @ApiModelProperty(value = "劳务税费id")
    private BigDecimal  serviceTaxId;
    /**
     * 劳务税费
     */
    @ApiModelProperty(value = "劳务税费")
    private BigDecimal  serviceTax;
    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private BigDecimal  amountMoney;
    /**
     * 专家id
     */
    @ApiModelProperty(value = "专家id")
    private Long  msExpertInfoId;
    /**
     * 专家姓名
     */
    @ApiModelProperty(value = "专家姓名")
    private String  expertInfoName;
    /**
     * 所属医院id
     */
    @ApiModelProperty(value = "所属医院id")
    private Long  msHospitalInfoId;
    /**
     * 所属医院
     */
    @ApiModelProperty(value = "所属医院")
    private String  hospitalName;
    /**
     * 所属科室id
     */
    @ApiModelProperty(value = "所属科室id")
    private Long  msDepartmentInfoId;
    /**
     * 所属科室名称
     */
    @ApiModelProperty(value = "所属科室名称")
    private String  departmentInfoName;
    /**
     * 专家类别
     */
    @ApiModelProperty(value = "专家类别")
    private String  expertsCategory;
    /**
     * 劳务协议附件
     */
    @ApiModelProperty(value = "劳务协议附件")
    private String  serviceAgreementAttachment;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String  status;
    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同编号")
    private String  contractNo;
    /**
     * 专家身份证号
     */
    @ApiModelProperty(value = "专家身份证号")
    private String  attribute1;
    /**
     * 专家银行账号
     */
    @ApiModelProperty(value = "专家银行账号")
    private String  attribute2;
    /**
     * 专家银行卡号
     */
    @ApiModelProperty(value = "专家银行卡号")
    private String  attribute3;
    /**
     * 专家手机号
     */
    @ApiModelProperty(value = "专家手机号")
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

