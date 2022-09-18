package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsUpdateOperationRecord;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsUpdateOperationRecord;
import top.tangyh.lamp.learnpm.vo.query.MsUpdateOperationRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsUpdateOperationRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.*;
import top.tangyh.lamp.learnpm.vo.update.*;

/**
 * <p>
 * 基础表更新操作记录业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
public interface MsUpdateOperationRecordService extends SuperService<Long, MsUpdateOperationRecord, MsUpdateOperationRecordSaveVO, MsUpdateOperationRecordUpdateVO, MsUpdateOperationRecordPageQuery, MsUpdateOperationRecordResultVO> {

    // 专家信息更新时基础记录操作表新增记录
    MsUpdateOperationRecord saveRecord(MsExpertInfoUpdateVO u);
    // 专家信息新增时基础记录操作表新增记录
    MsUpdateOperationRecord saveRecord(MsExpertInfoSaveVO u);

    // 工作经验更新时基础记录操作表新增记录
    MsUpdateOperationRecord saveRecord(MsWorkExperienceUpdateVO u);
    // 工作经验新增时基础记录操作表新增记录
    MsUpdateOperationRecord saveRecord(MsWorkExperienceSaveVO u);

    // 银行卡息更新时基础记录操作表新增记录
    MsUpdateOperationRecord saveRecord(MsExpertBankCardInfoUpdateVO u);
    // 银行卡新增时基础记录操作表新增记录
    MsUpdateOperationRecord saveRecord(MsExpertBankCardInfoSaveVO u);

    // 资格证书更新时基础记录操作表新增记录
    MsUpdateOperationRecord saveRecord(MsQualificationUpdateVO u);
    // 资格证书新增时基础记录操作表新增记录
    MsUpdateOperationRecord saveRecord(MsQualificationSaveVO u);

    MsUpdateOperationRecord save(MsUpdateOperationRecordSaveVO recordSaveVO);
}
