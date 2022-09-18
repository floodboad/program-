package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmPersonChargeAdjustRecord;
import top.tangyh.lamp.learnpm.vo.query.PmPersonChargeAdjustRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmPersonChargeAdjustRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmPersonChargeAdjustRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmPersonChargeAdjustRecordUpdateVO;
import top.tangyh.lamp.learnpm.wechat.PmMeetingupdateproject;
import top.tangyh.lamp.workflow.vo.AuditVO;

/**
 * <p>
 * 项目负责人及规划负责人调整记录业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmPersonChargeAdjustRecordService extends SuperService<Long, PmPersonChargeAdjustRecord, PmPersonChargeAdjustRecordSaveVO, PmPersonChargeAdjustRecordUpdateVO, PmPersonChargeAdjustRecordPageQuery, PmPersonChargeAdjustRecordResultVO> {
    Object updatePrincipal(PmMeetingupdateproject pmProjectMeetingPlanning);

    Object updatePrincipal1(PmMeetingupdateproject pmProjectMeetingPlanning);




  



}
