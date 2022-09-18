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
import java.math.BigDecimal;



/**
 * <p>
 * 会议专家劳务实体类
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
@ApiModel(value = "PmConferenceExpertServicesSaveVO", description = "会议专家劳务")
public class PmConferenceExpertServicesSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目会议申请id
     */
    @ApiModelProperty(value = "项目会议申请id")
    private Long   pmProjectMeetingApplyId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long   pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    @Size(max = 300, message = "项目名称长度不能超过300")
    private String   projectName;
    /**
     * 项目会议规划id
     */
    @ApiModelProperty(value = "项目会议规划id")
    private Long   pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    @Size(max = 300, message = "项目会议规划名称长度不能超过300")
    private String   projectMeetingPlanningName;
    /**
     * 费用id
     */
    @ApiModelProperty(value = "费用id")
    private Long   msBudgetSubjectId;
    /**
     * 费用名称
     */
    @ApiModelProperty(value = "费用名称")
    @Size(max = 300, message = "费用名称长度不能超过300")
    private String   feeName;
    /**
     * 费用执行标准
     */
    @ApiModelProperty(value = "费用执行标准")
    @Size(max = 300, message = "费用执行标准长度不能超过300")
    private String   controlStandards;
    /**
     * 人数
     */
    @ApiModelProperty(value = "人数")
    private Long   personNumber;
    /**
     * 劳务税费id
     */
    @ApiModelProperty(value = "劳务税费id")
    private BigDecimal   serviceTaxId;
    /**
     * 劳务税费
     */
    @ApiModelProperty(value = "劳务税费")
    private BigDecimal   serviceTax;
    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private BigDecimal   amountMoney;
    /**
     * 专家id
     */
    @ApiModelProperty(value = "专家id")
    private Long   msExpertInfoId;
    /**
     * 专家姓名
     */
    @ApiModelProperty(value = "专家姓名")
    @Size(max = 200, message = "专家姓名长度不能超过200")
    private String   expertInfoName;
    /**
     * 所属医院id
     */
    @ApiModelProperty(value = "所属医院id")
    private Long   msHospitalInfoId;
    /**
     * 所属医院
     */
    @ApiModelProperty(value = "所属医院")
    @Size(max = 300, message = "所属医院长度不能超过300")
    private String   hospitalName;
    /**
     * 所属科室id
     */
    @ApiModelProperty(value = "所属科室id")
    private Long   msDepartmentInfoId;
    /**
     * 所属科室名称
     */
    @ApiModelProperty(value = "所属科室名称")
    @Size(max = 300, message = "所属科室名称长度不能超过300")
    private String   departmentInfoName;
    /**
     * 专家类别
     */
    @ApiModelProperty(value = "专家类别")
    @Size(max = 300, message = "专家类别长度不能超过300")
    private String   expertsCategory;
    /**
     * 劳务协议附件
     */
    @ApiModelProperty(value = "劳务协议附件")
    @Size(max = 300, message = "劳务协议附件长度不能超过300")
    private String   serviceAgreementAttachment;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Size(max = 2, message = "状态长度不能超过2")
    private String   status;
    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同编号")
    @Size(max = 300, message = "合同编号长度不能超过300")
    private String   contractNo;
    /**
     * 专家身份证号
     */
    @ApiModelProperty(value = "专家身份证号")
    @Size(max = 100, message = "专家身份证号长度不能超过100")
    private String   attribute1;
    /**
     * 专家银行账号
     */
    @ApiModelProperty(value = "专家银行账号")
    @Size(max = 100, message = "专家银行账号长度不能超过100")
    private String   attribute2;
    /**
     * 专家银行卡号
     */
    @ApiModelProperty(value = "专家银行卡号")
    @Size(max = 100, message = "专家银行卡号长度不能超过100")
    private String   attribute3;
    /**
     * 专家手机号
     */
    @ApiModelProperty(value = "专家手机号")
    @Size(max = 100, message = "专家手机号长度不能超过100")
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
