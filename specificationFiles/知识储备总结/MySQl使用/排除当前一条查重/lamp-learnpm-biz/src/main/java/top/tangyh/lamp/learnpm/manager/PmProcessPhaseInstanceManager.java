package top.tangyh.lamp.learnpm.manager;

import top.tangyh.basic.base.manager.SuperManager;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;

/**
 * <p>
 * 流程环节实例业务层
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
public interface PmProcessPhaseInstanceManager extends SuperManager<PmProcessPhaseInstance> {

    void remove(LbQueryWrap<PmProcessPhaseInstance> in);
    // 获取指定id的记录
    PmProcessPhaseInstance getProcessConfigInstanceById(Long ProcessConfigId,Integer flagApplyNum);
}
