package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsPjComplianceFileDefMapper;
import top.tangyh.lamp.learnpm.entity.MsPjComplianceFileDef;
import top.tangyh.lamp.learnpm.manager.MsPjComplianceFileDefManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 项目合规文件定义Manager
 * </p>
 *
 * @author xucl
 * @date 2022-07-06
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsPjComplianceFileDefManagerImpl extends SuperManagerImpl<MsPjComplianceFileDefMapper, MsPjComplianceFileDef> implements MsPjComplianceFileDefManager {

}
