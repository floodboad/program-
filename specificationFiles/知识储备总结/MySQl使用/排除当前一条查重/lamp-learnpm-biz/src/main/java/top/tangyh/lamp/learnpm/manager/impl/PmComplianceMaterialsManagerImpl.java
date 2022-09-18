package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmComplianceMaterialsMapper;
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterials;
import top.tangyh.lamp.learnpm.manager.PmComplianceMaterialsManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目合规材料Manager
 * </p>
 *
 * @author liyy
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmComplianceMaterialsManagerImpl extends SuperManagerImpl<PmComplianceMaterialsMapper, PmComplianceMaterials> implements PmComplianceMaterialsManager {

}
