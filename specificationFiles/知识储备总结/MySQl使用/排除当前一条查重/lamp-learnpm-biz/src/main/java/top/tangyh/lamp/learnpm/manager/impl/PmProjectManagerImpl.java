package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmProjectMapper;
import top.tangyh.lamp.learnpm.entity.PmProject;
import top.tangyh.lamp.learnpm.manager.PmProjectManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目信息Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmProjectManagerImpl extends SuperManagerImpl<PmProjectMapper, PmProject> implements PmProjectManager {

}
