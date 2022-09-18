package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmProjectSponsorMapper;
import top.tangyh.lamp.learnpm.entity.PmProjectSponsor;
import top.tangyh.lamp.learnpm.manager.PmProjectSponsorManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目赞助企业Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProjectSponsorManagerImpl extends SuperManagerImpl<PmProjectSponsorMapper, PmProjectSponsor> implements PmProjectSponsorManager {

}
