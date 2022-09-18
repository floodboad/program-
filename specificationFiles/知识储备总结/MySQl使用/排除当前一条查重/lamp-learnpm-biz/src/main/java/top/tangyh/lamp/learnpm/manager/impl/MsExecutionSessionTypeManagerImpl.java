package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsExecutionSessionTypeMapper;
import top.tangyh.lamp.learnpm.entity.MsExecutionSessionType;
import top.tangyh.lamp.learnpm.manager.MsExecutionSessionTypeManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 执行场次类型Manager
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsExecutionSessionTypeManagerImpl extends SuperManagerImpl<MsExecutionSessionTypeMapper, MsExecutionSessionType> implements MsExecutionSessionTypeManager {

}
