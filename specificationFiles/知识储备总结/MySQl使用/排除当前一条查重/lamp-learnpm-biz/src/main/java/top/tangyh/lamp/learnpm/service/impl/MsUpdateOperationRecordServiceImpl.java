package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.context.ContextUtil;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.learnpm.entity.MsExpertInfo;
import top.tangyh.lamp.learnpm.entity.MsUpdateOperationRecord;
import top.tangyh.lamp.learnpm.manager.MsUpdateOperationRecordManager;
import top.tangyh.lamp.learnpm.service.MsUpdateOperationRecordService;
import top.tangyh.lamp.learnpm.vo.query.MsUpdateOperationRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsUpdateOperationRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.*;
import top.tangyh.lamp.learnpm.vo.update.*;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import java.util.Date;
import java.util.Random;


/**
 * <p>
 * 基础表更新操作记录业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsUpdateOperationRecordServiceImpl extends SuperServiceImpl<MsUpdateOperationRecordManager, Long, MsUpdateOperationRecord, MsUpdateOperationRecordSaveVO, MsUpdateOperationRecordUpdateVO, MsUpdateOperationRecordPageQuery, MsUpdateOperationRecordResultVO>
        implements MsUpdateOperationRecordService {



    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsUpdateOperationRecord saveRecord(MsExpertInfoUpdateVO u) {
        Date date = new Date();
        //InetAddress localHost = Inet4Address.getLocalHost();
        //String ip = localHost.getHostAddress();
        // MsExpertInfo msExpertInfo = BeanPlusUtil.toBean(u, MsExpertInfo.class);
        MsUpdateOperationRecord record = MsUpdateOperationRecord.builder().operatorId(ContextUtil.getUserId())
                .operatorName(ContextUtil.getUserName())
                .operatorTime(date)
                .updateTableId(u.getId())
                .updateTableName("MS_EXPERT_INFO")
                .operatorType("更新")
                .operatorDesc("更新相关信息")
                .unit(u.getWorkingHospital()+u.getDepartment())
                .ip("127.0.0.1")
                .build();
        superManager.save(record);
        return record;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsUpdateOperationRecord saveRecord(MsExpertInfoSaveVO s) {
        Long id = new Random().nextLong();
        Date date = new Date();
        MsUpdateOperationRecord record = MsUpdateOperationRecord.builder().operatorId(ContextUtil.getUserId())
                .operatorName(ContextUtil.getUserName())
                .operatorTime(date)
                .updateTableId(id)
                .updateTableName("MS_EXPERT_INFO")
                .operatorType("新增")
                .operatorDesc("新增相关信息")
                .unit(s.getWorkingHospital()+s.getDepartment())
                .ip("127.0.0.1")
                .build();
        superManager.save(record);
        return record;

    }

    @Override
    public MsUpdateOperationRecord saveRecord(MsWorkExperienceUpdateVO u) {
        Date date = new Date();
        //InetAddress localHost = Inet4Address.getLocalHost();
        //String ip = localHost.getHostAddress();
        //MsExpertInfo msExpertInfo = BeanPlusUtil.toBean(u, MsExpertInfo.class);
        MsUpdateOperationRecord record = MsUpdateOperationRecord.builder().operatorId(ContextUtil.getUserId())
                .operatorName(ContextUtil.getUserName())
                .operatorTime(date)
                .updateTableId(u.getId())
                .updateTableName("MS_WORK_EXPERIENCE")
                .operatorType("更新")
                .operatorDesc("新增相关信息")
                .unit(u.getWorkUnit())
                .ip("127.0.0.1")
                .build();
        superManager.save(record);
        return record;
    }

    @Override
    public MsUpdateOperationRecord saveRecord(MsWorkExperienceSaveVO u) {
        Long id = new Random().nextLong();
        Date date = new Date();
        MsUpdateOperationRecord record = MsUpdateOperationRecord.builder().operatorId(ContextUtil.getUserId())
                .operatorName(ContextUtil.getUserName())
                .operatorTime(date)
                .updateTableId(id)
                .updateTableName("MS_WORK_EXPERIENCE")
                .operatorType("新增")
                .operatorDesc("新增相关信息")
                .unit(u.getWorkUnit())
                .ip("127.0.0.1")
                .build();
        superManager.save(record);
        return record;
    }

    @Override
    public MsUpdateOperationRecord saveRecord(MsExpertBankCardInfoUpdateVO u) {
        Date date = new Date();
        //InetAddress localHost = Inet4Address.getLocalHost();
        //String ip = localHost.getHostAddress();
        MsExpertInfo msExpertInfo = BeanPlusUtil.toBean(u, MsExpertInfo.class);
        MsUpdateOperationRecord record = MsUpdateOperationRecord.builder().operatorId(ContextUtil.getUserId())
                .operatorName(ContextUtil.getUserName())
                .operatorTime(date)
                .updateTableId(u.getId())
                .updateTableName("MS_EXPERT_BANK_CARD_INFO")
                .operatorType("更新")
                .operatorDesc("新增相关信息")
                .ip("127.0.0.1")
                .build();
        superManager.save(record);
        return record;
    }

    @Override
    public MsUpdateOperationRecord saveRecord(MsExpertBankCardInfoSaveVO u) {
        Long id = new Random().nextLong();
        Date date = new Date();
        MsUpdateOperationRecord record = MsUpdateOperationRecord.builder().operatorId(ContextUtil.getUserId())
                .operatorName(ContextUtil.getUserName())
                .operatorTime(date)
                .updateTableId(id)
                .updateTableName("MS_EXPERT_BANK_CARD_INFO")
                .operatorType("新增")
                .operatorDesc("新增相关信息")
                .ip("127.0.0.1")
                .build();
        superManager.save(record);
        return record;
    }

    @Override
    public MsUpdateOperationRecord saveRecord(MsQualificationUpdateVO u) {
        Date date = new Date();
        //InetAddress localHost = Inet4Address.getLocalHost();
        //String ip = localHost.getHostAddress();
        MsExpertInfo msExpertInfo = BeanPlusUtil.toBean(u, MsExpertInfo.class);
        MsUpdateOperationRecord record = MsUpdateOperationRecord.builder().operatorId(ContextUtil.getUserId())
                .operatorName(ContextUtil.getUserName())
                .operatorTime(date)
                .updateTableId(u.getId())
                .updateTableName("MS_QUALIFICATION")
                .operatorType("更新")
                .operatorDesc("新增相关信息")
                .ip("127.0.0.1")
                .build();
        superManager.save(record);
        return record;
    }

    @Override
    public MsUpdateOperationRecord saveRecord(MsQualificationSaveVO u) {
        Long id = new Random().nextLong();
        Date date = new Date();
        MsUpdateOperationRecord record = MsUpdateOperationRecord.builder().operatorId(ContextUtil.getUserId())
                .operatorName(ContextUtil.getUserName())
                .operatorTime(date)
                .updateTableId(id)
                .updateTableName("MS_QUALIFICATION")
                .operatorType("新增")
                .operatorDesc("新增相关信息")
                .ip("127.0.0.1")
                .build();
        superManager.save(record);
        return record;
    }

}
