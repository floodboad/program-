package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmProcessPhaseConfMapper;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import top.tangyh.lamp.learnpm.manager.PmProcessPhaseConfManager;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * <p>
 * 流程环节配置Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProcessPhaseConfManagerImpl extends SuperManagerImpl<PmProcessPhaseConfMapper, PmProcessPhaseConf> implements PmProcessPhaseConfManager {

    @Autowired
    private PmProcessPhaseConfMapper pmProcessPhaseConfMapper;

    @Override
    public ArrayList<Integer> selectLinkSequence(long ProcessId) {
        return pmProcessPhaseConfMapper.selectLinkSequence(ProcessId);
    }

    @Override
    public String selectEndNode(long ProcessId) {
        return pmProcessPhaseConfMapper.selectEndNode(ProcessId);
    }
}
