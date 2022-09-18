package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmWkNodeTypeConfMapper;
import top.tangyh.lamp.learnpm.entity.PmWkNodeTypeConf;
import top.tangyh.lamp.learnpm.manager.PmWkNodeTypeConfManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 工作流节点类型配置Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmWkNodeTypeConfManagerImpl extends SuperManagerImpl<PmWkNodeTypeConfMapper, PmWkNodeTypeConf> implements PmWkNodeTypeConfManager {

}
