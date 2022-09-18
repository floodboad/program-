package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectPlanAdjustRecord;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectPlanAdjustRecord;
import top.tangyh.lamp.learnpm.vo.query.PmProjectPlanAdjustRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectPlanAdjustRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectPlanAdjustRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectPlanAdjustRecordUpdateVO;
import top.tangyh.lamp.workflow.vo.AuditVO;

/**
 * <p>
 * 项目规划调整记录业务接口
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmProjectPlanAdjustRecordService extends SuperService<Long, PmProjectPlanAdjustRecord, PmProjectPlanAdjustRecordSaveVO, PmProjectPlanAdjustRecordUpdateVO, PmProjectPlanAdjustRecordPageQuery, PmProjectPlanAdjustRecordResultVO> {
    /**
     *审批回调接口（通过不通过专用）
     */
    void audit(AuditVO auditVO) throws Exception;
}
