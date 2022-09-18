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
import top.tangyh.lamp.learnpm.entity.MsHospitalInfo;
import top.tangyh.lamp.learnpm.service.MsHospitalInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsHospitalInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsHospitalInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsHospitalInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsHospitalInfoUpdateVO;

/**
 * <p>
 * 医院信息前端控制器
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
@RequestMapping("/msHospitalInfo")
@Api(value = "MsHospitalInfo", tags = " 医院信息")
public class MsHospitalInfoController extends SuperController<MsHospitalInfoService, Long, MsHospitalInfo, MsHospitalInfoSaveVO, MsHospitalInfoUpdateVO, MsHospitalInfoPageQuery, MsHospitalInfoResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
