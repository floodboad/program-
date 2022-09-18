package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;
import top.tangyh.lamp.learnpm.mapper.PmProcessPhaseInstanceMapper;
import top.tangyh.lamp.learnpm.manager.PmProcessPhaseInstanceManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 流程环节实例Manager
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProcessPhaseInstanceManagerImpl extends SuperManagerImpl<PmProcessPhaseInstanceMapper, PmProcessPhaseInstance> implements PmProcessPhaseInstanceManager {

    @Override
    public void remove(LbQueryWrap<PmProcessPhaseInstance> in) {

    }
    @Autowired
    private PmProcessPhaseInstanceMapper pmProcessPhaseInstanceMapper;

    @Override
    public PmProcessPhaseInstance getProcessConfigInstanceById(Long ProcessConfigId,Integer flagApplyNum) {

        return pmProcessPhaseInstanceMapper.getProcessConfigInstanceById(ProcessConfigId,flagApplyNum);
    }
}
