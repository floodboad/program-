package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.entity.MsSecondarySubject;
import top.tangyh.lamp.learnpm.mapper.MsFirstLevelSubjectMapper;
import top.tangyh.lamp.learnpm.entity.MsFirstLevelSubject;
import top.tangyh.lamp.learnpm.manager.MsFirstLevelSubjectManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 一级科目维护Manager
 * </p>
 *
 * @author zyq
 * @date 2022-06-16
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsFirstLevelSubjectManagerImpl extends SuperManagerImpl<MsFirstLevelSubjectMapper, MsFirstLevelSubject> implements MsFirstLevelSubjectManager {



}
