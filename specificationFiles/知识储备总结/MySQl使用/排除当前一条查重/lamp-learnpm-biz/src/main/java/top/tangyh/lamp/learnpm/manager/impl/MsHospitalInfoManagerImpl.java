package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsHospitalInfoMapper;
import top.tangyh.lamp.learnpm.entity.MsHospitalInfo;
import top.tangyh.lamp.learnpm.manager.MsHospitalInfoManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 医院信息Manager
 * </p>
 *
 * @author zyq
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsHospitalInfoManagerImpl extends SuperManagerImpl<MsHospitalInfoMapper, MsHospitalInfo> implements MsHospitalInfoManager {

}
