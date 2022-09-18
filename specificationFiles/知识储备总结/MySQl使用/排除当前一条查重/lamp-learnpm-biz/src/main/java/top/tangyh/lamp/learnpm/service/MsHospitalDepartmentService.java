package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsHospitalDepartment;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsHospitalDepartment;
import top.tangyh.lamp.learnpm.vo.query.MsHospitalDepartmentPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsHospitalDepartmentResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsHospitalDepartmentSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsHospitalDepartmentUpdateVO;
/**
 * <p>
 * 医院科室业务接口
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-14
 */
public interface MsHospitalDepartmentService extends SuperService<Long, MsHospitalDepartment, MsHospitalDepartmentSaveVO, MsHospitalDepartmentUpdateVO, MsHospitalDepartmentPageQuery, MsHospitalDepartmentResultVO> {

}
