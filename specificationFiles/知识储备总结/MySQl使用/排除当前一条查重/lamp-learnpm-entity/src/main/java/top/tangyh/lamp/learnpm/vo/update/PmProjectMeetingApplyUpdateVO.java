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
import java.util.Date;



import top.tangyh.lamp.learnpm.entity.PmConferenceApplyFee;
import top.tangyh.lamp.learnpm.vo.save.*;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceApplyFeeUpdateVO;
import top.tangyh.lamp.learnpm.entity.PmConferenceExpertServices;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceExpertServicesUpdateVO;
import top.tangyh.lamp.learnpm.entity.PmMeetingMaterialsReg;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingMaterialsRegUpdateVO;
import top.tangyh.lamp.learnpm.entity.PmOnlineMeetingPublish;
import top.tangyh.lamp.learnpm.vo.update.PmOnlineMeetingPublishUpdateVO;
/**
 * <p>
 *  项目会议申请更新实体类
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
@ApiModel(value = "PmProjectMeetingApplyUpdateVO", description = "项目会议申请")
public class PmProjectMeetingApplyUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private  Long id;
    /**
     * 会议分配id
     */
    @ApiModelProperty(value = "会议分配id")
    private  Long meetingAllocationId;
    /**
     * 会议规划id
     */
    @ApiModelProperty(value = "会议规划id")
    private  Long pmProjectMeetingPlanningId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private  Long pmProjectId;
    /**
     * 会议支持项目名称
     */
    @ApiModelProperty(value = "会议支持项目名称")
    @Size(max = 300, message = "会议支持项目名称长度不能超过300")  
    private  String meetingSupportProjectName;
    /**
     * 会议编号名称
     */
    @ApiModelProperty(value = "会议编号名称")
    @Size(max = 300, message = "会议编号名称长度不能超过300")  
    private  String meetingNoName;
    /**
     * 支持项目计划开始时间
     */
    @ApiModelProperty(value = "支持项目计划开始时间")
    private  Date supportProjectPlanStartTime;
    /**
     * 支持项目计划结束时间
     */
    @ApiModelProperty(value = "支持项目计划结束时间")
    private  Date supportProjectPlanEndTime;
    /**
     * 会议方式
     */
    @ApiModelProperty(value = "会议方式")
    @Size(max = 300, message = "会议方式长度不能超过300")  
    private  String meetingMode;
    /**
     * 会议类型名称
     */
    @ApiModelProperty(value = "会议类型名称")
    @Size(max = 300, message = "会议类型名称长度不能超过300")  
    private  String meetingTypeName;
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
    private  Integer meetingCityCode;
    /**
     * 会议城市名称
     */
    @ApiModelProperty(value = "会议城市名称")
    @Size(max = 300, message = "会议城市名称长度不能超过300")  
    private  String meetingCityName;
    /**
     * 会议召开地址
     */
    @ApiModelProperty(value = "会议召开地址")
    @Size(max = 300, message = "会议召开地址长度不能超过300")  
    private  String meetingAddress;
    /**
     * 会议详细地址
     */
    @ApiModelProperty(value = "会议详细地址")
    @Size(max = 300, message = "会议详细地址长度不能超过300")  
    private  String meetingDetailAddress;
    /**
     * 会议经度
     */
    @ApiModelProperty(value = "会议经度")
    private  BigDecimal meetingLongitude;
    /**
     * 会议维度
     */
    @ApiModelProperty(value = "会议维度")
    private  BigDecimal meetingLatitude;
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
     * 现场联系人姓名
     */
    @ApiModelProperty(value = "现场联系人姓名")
    @Size(max = 200, message = "现场联系人姓名长度不能超过200")  
    private  String siteContactName;
    /**
     * 现场联系人电话
     */
    @ApiModelProperty(value = "现场联系人电话")
    @Size(max = 20, message = "现场联系人电话长度不能超过20")  
    private  String siteContactPhone;
    /**
     * 会议说明
     */
    @ApiModelProperty(value = "会议说明")
    @Size(max = 300, message = "会议说明长度不能超过300")  
    private  String meetingNote;
    /**
     * 会议总预算
     */
    @ApiModelProperty(value = "会议总预算")
    private  BigDecimal totalMeetingBudget;
    /**
     * 会议支出金额
     */
    @ApiModelProperty(value = "会议支出金额")
    private  BigDecimal meetingExpensesAmount;
    /**
     * 预算剩余金额
     */
    @ApiModelProperty(value = "预算剩余金额")
    private  BigDecimal budgetRemainingAmount;
    /**
     * 会议支出审定金额
     */
    @ApiModelProperty(value = "会议支出审定金额")
    private  BigDecimal meetingExpensesAuditAmount;
    /**
     * 会议预算执行返回金额
     */
    @ApiModelProperty(value = "会议预算执行返回金额")
    private  BigDecimal budgetExeReturnAmt;
    /**
     * 会议状态
     */
    @ApiModelProperty(value = "会议状态")
    @Size(max = 2, message = "会议状态长度不能超过2")  
    private  String meetingStatus;
    /**
     * 会议结算状态
     */
    @ApiModelProperty(value = "会议结算状态")
    @Size(max = 2, message = "会议结算状态长度不能超过2")  
    private  String meetingFinalAccountStatus;
    /**
     * 会议决算说明
     */
    @ApiModelProperty(value = "会议决算说明")
    @Size(max = 300, message = "会议决算说明长度不能超过300")  
    private  String meetingFinalAccountRemark;
    /**
     * 会议决算附件
     */
    @ApiModelProperty(value = "会议决算附件")
    @Size(max = 300, message = "会议决算附件长度不能超过300")  
    private  String meetingFinalAccountAttachment;
    /**
     * 会议线下支出
     */
    @ApiModelProperty(value = "会议线下支出")
    private  BigDecimal meetingOfflineExpenditure;
    /**
     * 商企通支出
     */
    @ApiModelProperty(value = "商企通支出")
    private  BigDecimal shangqitongExpenditure;
    /**
     * 顺丰支出
     */
    @ApiModelProperty(value = "顺丰支出")
    private  BigDecimal sfExpenditure;
    /**
     * 预付款支出
     */
    @ApiModelProperty(value = "预付款支出")
    private  BigDecimal prepaymentExpenditure;
    /**
     * 预约人数
     */
    @ApiModelProperty(value = "预约人数")
    private  Integer appointmentsNumber;
    /**
     * 商企通同步状态
     */
    @ApiModelProperty(value = "商企通同步状态")
    @Size(max = 2, message = "商企通同步状态长度不能超过2")  
    private  String shangqitongStatus;
    /**
     * 发布状态
     */
    @ApiModelProperty(value = "发布状态")
    @Size(max = 2, message = "发布状态长度不能超过2")  
    private  String publishStatus;
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
     //会议申请费用表插入列表
    private List<PmConferenceApplyFeeSaveVO> pmConferenceApplyFeePmProjectMeetingApplyIdInsertList;
     //会议申请费用表更新列表
    private List<PmConferenceApplyFeeUpdateVO> pmConferenceApplyFeePmProjectMeetingApplyIdUpdateList;
     //会议申请费用表删除列表
    private List<Long> pmConferenceApplyFeePmProjectMeetingApplyIdDeleteList;		
     //会议专家劳务插入列表
    private List<PmConferenceExpertServicesSaveVO> pmConferenceExpertServicesPmProjectMeetingApplyIdInsertList;
     //会议专家劳务更新列表
    private List<PmConferenceExpertServicesUpdateVO> pmConferenceExpertServicesPmProjectMeetingApplyIdUpdateList;
     //会议专家劳务删除列表
    private List<Long> pmConferenceExpertServicesPmProjectMeetingApplyIdDeleteList;		
     //会议合规材料登记插入列表
    private List<PmMeetingMaterialsRegSaveVO> pmMeetingMaterialsRegPmProjectMeetingApplyIdInsertList;
     //会议合规材料登记更新列表
    private List<PmMeetingMaterialsRegUpdateVO> pmMeetingMaterialsRegPmProjectMeetingApplyIdUpdateList;
     //会议合规材料登记删除列表
    private List<Long> pmMeetingMaterialsRegPmProjectMeetingApplyIdDeleteList;		
     //线上会议发布插入列表
    private List<PmOnlineMeetingPublishSaveVO> pmOnlineMeetingPublishPmProjectMeetingApplyIdInsertList;
     //线上会议发布更新列表
    private List<PmOnlineMeetingPublishUpdateVO> pmOnlineMeetingPublishPmProjectMeetingApplyIdUpdateList;
     //线上会议发布删除列表
    private List<Long> pmOnlineMeetingPublishPmProjectMeetingApplyIdDeleteList;
    //会议执行费用支付录入列表
    private List<PmOtherExpensesRegSaveVO> pmOtherExpensesRegPmProjectMeetingApplyIdInsertList;
    //会议执行费用支付更新列表
    private List<PmOtherExpensesRegUpdateVO> pmOtherExpensesRegPmProjectMeetingApplyIdUpdateList;
    //会议执行费用支付录入删除列表
    private List<Long> pmOtherExpensesRegPmProjectMeetingApplyIdDeleteList;
}
