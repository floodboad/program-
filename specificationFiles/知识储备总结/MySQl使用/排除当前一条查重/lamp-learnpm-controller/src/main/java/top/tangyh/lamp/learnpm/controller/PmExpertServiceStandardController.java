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
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandard;
import top.tangyh.lamp.learnpm.service.PmExpertServiceStandardService;
import top.tangyh.lamp.learnpm.vo.query.PmExpertServiceStandardPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmExpertServiceStandardResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertServiceStandardSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertServiceStandardUpdateVO;

/**
 * <p>
 * 会议规划专家劳务标准前端控制器
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmExpertServiceStandard")
@Api(value = "PmExpertServiceStandard", tags = " 会议规划专家劳务标准")
public class PmExpertServiceStandardController extends SuperController<PmExpertServiceStandardService, Long, PmExpertServiceStandard, PmExpertServiceStandardSaveVO, PmExpertServiceStandardUpdateVO, PmExpertServiceStandardPageQuery, PmExpertServiceStandardResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
