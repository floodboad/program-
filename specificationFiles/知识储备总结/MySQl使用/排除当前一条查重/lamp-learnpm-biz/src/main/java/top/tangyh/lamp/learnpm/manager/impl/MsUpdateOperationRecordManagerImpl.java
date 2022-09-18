package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsUpdateOperationRecordMapper;
import top.tangyh.lamp.learnpm.entity.MsUpdateOperationRecord;
import top.tangyh.lamp.learnpm.manager.MsUpdateOperationRecordManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 基础表更新操作记录Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsUpdateOperationRecordManagerImpl extends SuperManagerImpl<MsUpdateOperationRecordMapper, MsUpdateOperationRecord> implements MsUpdateOperationRecordManager {

}
