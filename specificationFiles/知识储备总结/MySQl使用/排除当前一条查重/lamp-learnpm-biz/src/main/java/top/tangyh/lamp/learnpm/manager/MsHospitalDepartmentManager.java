package top.tangyh.lamp.learnpm.manager;

import top.tangyh.basic.base.manager.SuperManager;
import top.tangyh.lamp.learnpm.entity.MsHospitalDepartment;

import java.util.ArrayList;

/**
 * <p>
 * 医院科室业务层
 * </p>
 *
 * @author zyq
 * @date 2022-06-14
 */
public interface MsHospitalDepartmentManager extends SuperManager<MsHospitalDepartment> {

    // 获取所有的医院名称（去重）xucl
    ArrayList<String> selectDistinctHospitalName();

    // 获取指定医院名称的科室信息 xucl
    ArrayList<String> selectHospitalDeptName(String name);
}
