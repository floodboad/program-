package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsHospitalDepartmentMapper;
import top.tangyh.lamp.learnpm.entity.MsHospitalDepartment;
import top.tangyh.lamp.learnpm.manager.MsHospitalDepartmentManager;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * <p>
 * 医院科室Manager
 * </p>
 *
 * @author zyq
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsHospitalDepartmentManagerImpl extends SuperManagerImpl<MsHospitalDepartmentMapper, MsHospitalDepartment> implements MsHospitalDepartmentManager {

    @Autowired
    private MsHospitalDepartmentMapper msHospitalDepartmentMapper;
    @Override
    public ArrayList<String> selectDistinctHospitalName() {
        return msHospitalDepartmentMapper.selectDistinctHospitalName();
    }

    @Override
    public ArrayList<String> selectHospitalDeptName(String name) {
        return msHospitalDepartmentMapper.selectHospitalDeptName(name);
    }
}
