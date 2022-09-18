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
import top.tangyh.lamp.learnpm.entity.PmConferenceExpertServices;
import top.tangyh.lamp.learnpm.service.PmConferenceExpertServicesService;
import top.tangyh.lamp.learnpm.vo.query.PmConferenceExpertServicesPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmConferenceExpertServicesResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceExpertServicesSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceExpertServicesUpdateVO;

/**
 * <p>
 * 会议专家劳务前端控制器
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmConferenceExpertServices")
@Api(value = "PmConferenceExpertServices", tags = " 会议专家劳务")
public class PmConferenceExpertServicesController extends SuperController<PmConferenceExpertServicesService, Long, PmConferenceExpertServices, PmConferenceExpertServicesSaveVO, PmConferenceExpertServicesUpdateVO, PmConferenceExpertServicesPageQuery, PmConferenceExpertServicesResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
