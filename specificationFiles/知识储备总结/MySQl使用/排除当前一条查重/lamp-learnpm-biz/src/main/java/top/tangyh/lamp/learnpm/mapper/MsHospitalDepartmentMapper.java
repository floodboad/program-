package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.MsHospitalDepartment;

import java.util.ArrayList;

/**
 * <p>
 * 医院科室Mapper 接口
 * </p>
 *
 * @author zyq
 * @date 2022-06-14
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface MsHospitalDepartmentMapper extends SuperMapper<MsHospitalDepartment> {

    // 获取所有的医院名称（去重）xucl
    ArrayList<String> selectDistinctHospitalName();

    // 获取指定医院名称的科室信息 xucl
    ArrayList<String> selectHospitalDeptName(@Param("name")String name);


}
