package top.tangyh.lamp.learnpm.controller;


import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.lamp.learnpm.entity.MsHospitalDepartment;
import top.tangyh.lamp.learnpm.service.MsHospitalDepartmentService;
import top.tangyh.lamp.learnpm.vo.query.MsHospitalDepartmentPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsHospitalDepartmentResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsHospitalDepartmentSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsHospitalDepartmentUpdateVO;

/**
 * <p>
 * 医院科室前端控制器
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-14
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/msHospitalDepartment")
@Api(value = "MsHospitalDepartment", tags = " 医院科室")
public class MsHospitalDepartmentController extends SuperController<MsHospitalDepartmentService, Long, MsHospitalDepartment, MsHospitalDepartmentSaveVO, MsHospitalDepartmentUpdateVO, MsHospitalDepartmentPageQuery, MsHospitalDepartmentResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
