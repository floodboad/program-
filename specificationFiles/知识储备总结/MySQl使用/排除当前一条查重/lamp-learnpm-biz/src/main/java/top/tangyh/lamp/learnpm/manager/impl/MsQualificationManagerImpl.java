package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsQualificationMapper;
import top.tangyh.lamp.learnpm.entity.MsQualification;
import top.tangyh.lamp.learnpm.manager.MsQualificationManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 资格证书Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsQualificationManagerImpl extends SuperManagerImpl<MsQualificationMapper, MsQualification> implements MsQualificationManager {

}
