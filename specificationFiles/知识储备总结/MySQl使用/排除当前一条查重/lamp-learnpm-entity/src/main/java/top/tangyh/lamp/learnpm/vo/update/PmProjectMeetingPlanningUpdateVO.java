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
import java.util.List;
import java.math.BigDecimal;


import top.tangyh.lamp.learnpm.entity.PmMeetingPlanExeStandards;
import top.tangyh.lamp.learnpm.vo.save.PmComplianceMaterialsSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingPlanExeStandardsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanExeStandardsUpdateVO;
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandard;
import top.tangyh.lamp.learnpm.vo.save.PmExpertServiceStandardSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertServiceStandardUpdateVO;
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReq;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExecutionReqSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExecutionReqUpdateVO;
/**
 * <p>
 *  项目会议规划更新实体类
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
@ApiModel(value = "PmProjectMeetingPlanningUpdateVO", description = "项目会议规划")
public class PmProjectMeetingPlanningUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    @NotNull
    private  Long pmProjectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    @NotEmpty
    @Size(max = 300, message = "项目名称长度不能超过300")
    private  String projectName;
    /**
     * 项目会议规划名称
     */
    @ApiModelProperty(value = "项目会议规划名称")
    @Size(max = 300, message = "项目会议规划名称长度不能超过300")
    @NotEmpty
    private  String projectMeetingPlanningName;
    /**
     * 会议方式
     */
    @ApiModelProperty(value = "会议方式")
    @NotEmpty
    @Size(max = 300, message = "会议方式长度不能超过300")
    private  String meetingMode;
    /**
     * 会议类型id
     */
    @ApiModelProperty(value = "会议类型id")
    @NotNull
    private  Long msLongzhuMeetingTypeId;
    /**
     * 会议类型名称
     */
    @ApiModelProperty(value = "会议类型名称")
    @NotEmpty
    @Size(max = 300, message = "会议类型名称长度不能超过300")
    private  String meetingType;
    /**
     * 单场会议费标准
     */
    @ApiModelProperty(value = "单场会议费标准")
    @NotNull
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
     * 本规划分配金额
     */
    @ApiModelProperty(value = "本规划分配金额")
    @NotNull
    private  BigDecimal totalBudgetAmount;
    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    @NotNull
    private  Long chargePersonId;
    /**
     * 负责人姓名
     */
    @ApiModelProperty(value = "负责人姓名")
    @NotEmpty
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
    private  String attachment;
    /**
     * 已分配数量
     */
    @ApiModelProperty(value = "已分配数量")
    private  Integer assignedQuantity;
    /**
     * 剩余未分配数量
     */
    @ApiModelProperty(value = "剩余未分配数量")
    private  Integer remainingUnallocatedNum;
    /**
     * 执行场次数量
     */
    @ApiModelProperty(value = "执行场次数量")
    private  Integer executionSessionsNumber;
    /**
     * 已申请场次
     */
    @ApiModelProperty(value = "已申请场次")
    private  Integer openedTimes;
    /**
     * 会议预算差额
     */
    @ApiModelProperty(value = "会议预算差额")
    private  BigDecimal meetingBudgetDifference;
    /**
     * 已执行会议预算
     */
    @ApiModelProperty(value = "已执行会议预算")
    private  BigDecimal meetingBudgetImplemented;
    /**
     * 其中专家劳务费用
     */
    @ApiModelProperty(value = "其中专家劳务费用")
    private  BigDecimal inExpertServiceExpenses;
    /**
     * 其中会议执行费用
     */
    @ApiModelProperty(value = "其中会议执行费用")
    private  BigDecimal inMeetingExecutionCost;
    /**
     * 规划场次
     */
    @ApiModelProperty(value = "规划场次")
    @NotNull
    private Integer   meetingPlanNum;
    /**
     * 结算金额
     */
    @ApiModelProperty(value = "结算金额")
    private BigDecimal   settlementAmount;
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
     //会议规划执行标准插入列表
    private List<PmMeetingPlanExeStandardsSaveVO> pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdInsertList;
     //会议规划执行标准更新列表
    private List<PmMeetingPlanExeStandardsUpdateVO> pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdUpdateList;
     //会议规划执行标准删除列表
    private List<Long> pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdDeleteList;
     //会议规划专家劳务标准插入列表
    private List<PmExpertServiceStandardSaveVO> pmExpertServiceStandardPmProjectMeetingPlanningIdInsertList;
     //会议规划专家劳务标准更新列表
    private List<PmExpertServiceStandardUpdateVO> pmExpertServiceStandardPmProjectMeetingPlanningIdUpdateList;
     //会议规划专家劳务标准删除列表
    private List<Long> pmExpertServiceStandardPmProjectMeetingPlanningIdDeleteList;
     //会议执行要求插入列表
    private List<PmMeetingExecutionReqSaveVO> pmMeetingExecutionReqPmProjectMeetingPlanningIdInsertList;
     //会议执行要求更新列表
    private List<PmMeetingExecutionReqUpdateVO> pmMeetingExecutionReqPmProjectMeetingPlanningIdUpdateList;
     //会议执行要求删除列表
    private List<Long> pmMeetingExecutionReqPmProjectMeetingPlanningIdDeleteList;
    //项目合规材料插入列表
    private List<PmComplianceMaterialsSaveVO> pmComplianceMaterialsPmProjectMeetingPlanningIdInsertList;
    //项目合规材料更新列表
    private List<PmComplianceMaterialsUpdateVO> pmComplianceMaterialsPmProjectMeetingPlanningIdUpdateList;
    //项目合规材料删除列表
    private List<Long> pmComplianceMaterialsPmProjectMeetingPlanningIdDeleteList;
}
