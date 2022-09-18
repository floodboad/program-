package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmComplianceMaterialAdjustMapper;
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterialAdjust;
import top.tangyh.lamp.learnpm.manager.PmComplianceMaterialAdjustManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目合规材料调整Manager
 * </p>
 *
 * @author liyy
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmComplianceMaterialAdjustManagerImpl extends SuperManagerImpl<PmComplianceMaterialAdjustMapper, PmComplianceMaterialAdjust> implements PmComplianceMaterialAdjustManager {

}
