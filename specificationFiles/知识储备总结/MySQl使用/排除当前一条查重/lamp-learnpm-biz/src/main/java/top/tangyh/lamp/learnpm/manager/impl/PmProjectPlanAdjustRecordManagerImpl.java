package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmProjectPlanAdjustRecordMapper;
import top.tangyh.lamp.learnpm.entity.PmProjectPlanAdjustRecord;
import top.tangyh.lamp.learnpm.manager.PmProjectPlanAdjustRecordManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目规划调整记录Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProjectPlanAdjustRecordManagerImpl extends SuperManagerImpl<PmProjectPlanAdjustRecordMapper, PmProjectPlanAdjustRecord> implements PmProjectPlanAdjustRecordManager {

}
