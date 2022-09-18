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
import top.tangyh.lamp.learnpm.entity.MsQualification;
import top.tangyh.lamp.learnpm.service.MsQualificationService;
import top.tangyh.lamp.learnpm.vo.query.MsQualificationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsQualificationResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsQualificationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsQualificationUpdateVO;

/**
 * <p>
 * 资格证书前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/msQualification")
@Api(value = "MsQualification", tags = " 资格证书")
public class MsQualificationController extends SuperController<MsQualificationService, Long, MsQualification, MsQualificationSaveVO, MsQualificationUpdateVO, MsQualificationPageQuery, MsQualificationResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
