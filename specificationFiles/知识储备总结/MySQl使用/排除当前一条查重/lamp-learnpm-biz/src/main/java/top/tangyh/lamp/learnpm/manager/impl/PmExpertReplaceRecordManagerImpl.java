package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmExpertReplaceRecordMapper;
import top.tangyh.lamp.learnpm.entity.PmExpertReplaceRecord;
import top.tangyh.lamp.learnpm.manager.PmExpertReplaceRecordManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 专家更换记录Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmExpertReplaceRecordManagerImpl extends SuperManagerImpl<PmExpertReplaceRecordMapper, PmExpertReplaceRecord> implements PmExpertReplaceRecordManager {

}
