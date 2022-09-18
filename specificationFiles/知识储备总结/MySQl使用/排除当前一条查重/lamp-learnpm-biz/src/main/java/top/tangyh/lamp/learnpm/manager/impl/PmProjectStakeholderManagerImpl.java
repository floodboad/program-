package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmProjectStakeholderMapper;
import top.tangyh.lamp.learnpm.entity.PmProjectStakeholder;
import top.tangyh.lamp.learnpm.manager.PmProjectStakeholderManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目干系人Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProjectStakeholderManagerImpl extends SuperManagerImpl<PmProjectStakeholderMapper, PmProjectStakeholder> implements PmProjectStakeholderManager {

}
