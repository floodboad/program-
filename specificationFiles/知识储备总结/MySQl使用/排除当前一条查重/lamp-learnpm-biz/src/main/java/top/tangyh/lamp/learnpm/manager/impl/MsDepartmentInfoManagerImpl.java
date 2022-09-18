package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsDepartmentInfoMapper;
import top.tangyh.lamp.learnpm.entity.MsDepartmentInfo;
import top.tangyh.lamp.learnpm.manager.MsDepartmentInfoManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 科室信息Manager
 * </p>
 *
 * @author zyq
 * @date 2022-06-13
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsDepartmentInfoManagerImpl extends SuperManagerImpl<MsDepartmentInfoMapper, MsDepartmentInfo> implements MsDepartmentInfoManager {

}
