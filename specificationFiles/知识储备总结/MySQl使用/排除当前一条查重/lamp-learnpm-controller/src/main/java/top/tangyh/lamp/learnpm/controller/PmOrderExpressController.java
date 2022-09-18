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
import top.tangyh.lamp.learnpm.entity.PmOrderExpress;
import top.tangyh.lamp.learnpm.service.PmOrderExpressService;
import top.tangyh.lamp.learnpm.vo.query.PmOrderExpressPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOrderExpressResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOrderExpressSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOrderExpressUpdateVO;

/**
 * <p>
 * 定快递前端控制器
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmOrderExpress")
@Api(value = "PmOrderExpress", tags = " 定快递")
public class PmOrderExpressController extends SuperController<PmOrderExpressService, Long, PmOrderExpress, PmOrderExpressSaveVO, PmOrderExpressUpdateVO, PmOrderExpressPageQuery, PmOrderExpressResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
