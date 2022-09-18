package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmDesignRequirementMapper;
import top.tangyh.lamp.learnpm.entity.PmDesignRequirement;
import top.tangyh.lamp.learnpm.manager.PmDesignRequirementManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 设计要求Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmDesignRequirementManagerImpl extends SuperManagerImpl<PmDesignRequirementMapper, PmDesignRequirement> implements PmDesignRequirementManager {

}
