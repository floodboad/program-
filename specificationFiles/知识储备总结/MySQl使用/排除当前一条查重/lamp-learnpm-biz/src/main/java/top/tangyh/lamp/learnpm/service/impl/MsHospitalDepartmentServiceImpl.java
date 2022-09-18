package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsHospitalDepartment;
import top.tangyh.lamp.learnpm.manager.MsHospitalDepartmentManager;
import top.tangyh.lamp.learnpm.service.MsHospitalDepartmentService;
import top.tangyh.lamp.learnpm.vo.query.MsHospitalDepartmentPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsHospitalDepartmentResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsHospitalDepartmentSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsHospitalDepartmentUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 医院科室业务实现类
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-14
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsHospitalDepartmentServiceImpl extends SuperServiceImpl<MsHospitalDepartmentManager, Long, MsHospitalDepartment, MsHospitalDepartmentSaveVO, MsHospitalDepartmentUpdateVO, MsHospitalDepartmentPageQuery, MsHospitalDepartmentResultVO>
        implements MsHospitalDepartmentService {
    
}
