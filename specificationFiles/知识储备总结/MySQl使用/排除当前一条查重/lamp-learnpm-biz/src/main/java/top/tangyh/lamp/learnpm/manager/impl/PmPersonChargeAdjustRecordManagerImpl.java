package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmPersonChargeAdjustRecordMapper;
import top.tangyh.lamp.learnpm.entity.PmPersonChargeAdjustRecord;
import top.tangyh.lamp.learnpm.manager.PmPersonChargeAdjustRecordManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目负责人及规划负责人调整记录Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmPersonChargeAdjustRecordManagerImpl extends SuperManagerImpl<PmPersonChargeAdjustRecordMapper, PmPersonChargeAdjustRecord> implements PmPersonChargeAdjustRecordManager {

}
