package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmExpertServiceStandardAdjMapper;
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandardAdj;
import top.tangyh.lamp.learnpm.manager.PmExpertServiceStandardAdjManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议规划专家劳务标准调整记录Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmExpertServiceStandardAdjManagerImpl extends SuperManagerImpl<PmExpertServiceStandardAdjMapper, PmExpertServiceStandardAdj> implements PmExpertServiceStandardAdjManager {

}
