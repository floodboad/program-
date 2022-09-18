package top.tangyh.lamp.learnpm.vo.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.SuperEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * <p>
 *  项目会议规划调整更新实体类
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "PmProjectMeetingPlanAdjustUpdateVO", description = "项目会议规划调整")
public class PmProjectMeetingPlanAdjustUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 项目规划调整记录id
     */
    @ApiModelProperty(value = "项目规划调整记录id")
    private  Long pmProjectPlanAdjustRecordId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private  Long pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    @Size(max = 300, message = "项目名称长度不能超过300")  
    private  String projectName;
    /**
     * 会议规划id
     */
    @ApiModelProperty(value = "会议规划id")
    private  Long pmProjectMeetingPlanningId;
    /**
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    @Size(max = 300, message = "项目会议规划名称长度不能超过300")  
    private  String projectMeetingPlanningName;
    /**
     * 会议方式
     */
    @ApiModelProperty(value = "会议方式")
    @Size(max = 300, message = "会议方式长度不能超过300")  
    private  String meetingMode;
    /**
     * 会议类型id
     */
    @ApiModelProperty(value = "会议类型id")
    private  Long msLongzhuMeetingTypeId;
    /**
     * 会议类型名称
     */
    @ApiModelProperty(value = "会议类型名称")
    @Size(max = 300, message = "会议类型名称长度不能超过300")  
    private  String meetingType;
    /**
     * 原执行场次数量
     */
    @ApiModelProperty(value = "原执行场次数量")
    private  Integer oldExecutionSessionsNumber;
    /**
     * 调整场次数量
     */
    @ApiModelProperty(value = "调整场次数量")
    private  Integer adjustExecutionSessionsNumber;
    /**
     * 现未执行场次数量
     */
    @ApiModelProperty(value = "现未执行场次数量")
    private  Integer nowExecutionSessionsNumber;
    /**
     * 原单场会议费标准
     */
    @ApiModelProperty(value = "原单场会议费标准")
    private  BigDecimal meetingFeeStandard;
    /**
     * 会议省份编码
     */
    @ApiModelProperty(value = "会议省份编码")
    private  Integer provinceCode;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    @Size(max = 300, message = "省份长度不能超过300")  
    private  String province;
    /**
     * 会议城市编码
     */
    @ApiModelProperty(value = "会议城市编码")
    private  Integer cityCode;
    /**
     * 会议城市名称
     */
    @ApiModelProperty(value = "会议城市名称")
    @Size(max = 300, message = "会议城市名称长度不能超过300")  
    private  String meetingCity;
    /**
     * 会议区县编码
     */
    @ApiModelProperty(value = "会议区县编码")
    private  Integer meetingDistrictCountyCode;
    /**
     * 会议区县名称
     */
    @ApiModelProperty(value = "会议区县名称")
    @Size(max = 300, message = "会议区县名称长度不能超过300")  
    private  String meetingDistrictCountyName;
    /**
     * 原分配预算总金额
     */
    @ApiModelProperty(value = "原分配预算总金额")
    private  BigDecimal totalBudgetAmount;
    /**
     * 调整预算金额
     */
    @ApiModelProperty(value = "调整预算金额")
    private  BigDecimal oldTotalBudgetAmount;
    /**
     * 调整后预算总金额
     */
    @ApiModelProperty(value = "调整后预算总金额")
    private  BigDecimal adjustTotalBudgetAmount;
    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    private  Long chargePersonId;
    /**
     * 负责人姓名
     */
    @ApiModelProperty(value = "负责人姓名")
    @Size(max = 200, message = "负责人姓名长度不能超过200")  
    private  String chargePersonName;
    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    @Size(max = 11, message = "负责人手机号长度不能超过11")  
    private  String phone;
    /**
     * 参会人员数量起
     */
    @ApiModelProperty(value = "参会人员数量起")
    private  Integer minimumParticipantsNumber;
    /**
     * 参会人员数量止
     */
    @ApiModelProperty(value = "参会人员数量止")
    private  Integer maximumParticipantsNumber;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @Size(max = 300, message = "说明长度不能超过300")  
    private  String illustrate;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    @Size(max = 300, message = "附件长度不能超过300")  
    private  String attachment;
    /**
     * 单场会议费标准
     */
    @ApiModelProperty(value = "单场会议费标准")
    private  BigDecimal meetingFeeStandard2;
    /**
     * 已申请场次
     */
    @ApiModelProperty(value = "已申请场次")
    private  Integer openedTimes;
    /**
     * 其中原每场专家劳务费用
     */
    @ApiModelProperty(value = "其中原每场专家劳务费用")
    private  BigDecimal inLaborCostOfEachExpert;
    /**
     * 其中现每场专家劳务费用
     */
    @ApiModelProperty(value = "其中现每场专家劳务费用")
    private  BigDecimal inCurrentExpertServiceFee;
    /**
     * 其中原会议执行费用
     */
    @ApiModelProperty(value = "其中原会议执行费用")
    private  BigDecimal inOriginalMeetingExecutionCost;
    /**
     * 其中现会议执行费用
     */
    @ApiModelProperty(value = "其中现会议执行费用")
    private  BigDecimal inCurrentMeetingExecCost;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1")
    @Size(max = 100, message = "扩展字段1长度不能超过100")  
    private  String attribute1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2")
    @Size(max = 100, message = "扩展字段2长度不能超过100")  
    private  String attribute2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3")
    @Size(max = 100, message = "扩展字段3长度不能超过100")  
    private  String attribute3;
    /**
     * 扩展字段4
     */
    @ApiModelProperty(value = "扩展字段4")
    @Size(max = 100, message = "扩展字段4长度不能超过100")  
    private  String attribute4;
    /**
     * 扩展字段5
     */
    @ApiModelProperty(value = "扩展字段5")
    @Size(max = 100, message = "扩展字段5长度不能超过100")  
    private  String attribute5;
    /**
     * 扩展字段6
     */
    @ApiModelProperty(value = "扩展字段6")
    @Size(max = 100, message = "扩展字段6长度不能超过100")  
    private  String attribute6;
    /**
     * 扩展字段7
     */
    @ApiModelProperty(value = "扩展字段7")
    @Size(max = 100, message = "扩展字段7长度不能超过100")  
    private  String attribute7;
    /**
     * 扩展字段8
     */
    @ApiModelProperty(value = "扩展字段8")
    @Size(max = 100, message = "扩展字段8长度不能超过100")  
    private  String attribute8;
    /**
     * 扩展字段9
     */
    @ApiModelProperty(value = "扩展字段9")
    @Size(max = 100, message = "扩展字段9长度不能超过100")  
    private  String attribute9;
    /**
     * 扩展字段10
     */
    @ApiModelProperty(value = "扩展字段10")
    @Size(max = 100, message = "扩展字段10长度不能超过100")  
    private  String attribute10;
}
