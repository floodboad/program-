package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmMaterialProductionMapper;
import top.tangyh.lamp.learnpm.entity.PmMaterialProduction;
import top.tangyh.lamp.learnpm.manager.PmMaterialProductionManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 物料制作Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmMaterialProductionManagerImpl extends SuperManagerImpl<PmMaterialProductionMapper, PmMaterialProduction> implements PmMaterialProductionManager {

}
