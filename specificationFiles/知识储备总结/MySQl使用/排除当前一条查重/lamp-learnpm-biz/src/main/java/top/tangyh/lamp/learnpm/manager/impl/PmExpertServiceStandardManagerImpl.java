package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmExpertServiceStandardMapper;
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandard;
import top.tangyh.lamp.learnpm.manager.PmExpertServiceStandardManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议规划专家劳务标准Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmExpertServiceStandardManagerImpl extends SuperManagerImpl<PmExpertServiceStandardMapper, PmExpertServiceStandard> implements PmExpertServiceStandardManager {

}
