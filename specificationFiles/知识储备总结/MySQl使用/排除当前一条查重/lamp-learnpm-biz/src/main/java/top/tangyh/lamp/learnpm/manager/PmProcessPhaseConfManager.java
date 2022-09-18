package top.tangyh.lamp.learnpm.manager;

import top.tangyh.basic.base.manager.SuperManager;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;

import java.util.ArrayList;

/**
 * <p>
 * 流程环节配置业务层
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
public interface PmProcessPhaseConfManager extends SuperManager<PmProcessPhaseConf> {

    // 获取指定的id的所有环节次序
    ArrayList<Integer> selectLinkSequence(long ProcessId);

    // 查询是否只有一个结束节点
     String  selectEndNode(long ProcessId);
}
