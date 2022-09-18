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
import top.tangyh.lamp.learnpm.entity.PmMaterialProduction;
import top.tangyh.lamp.learnpm.service.PmMaterialProductionService;
import top.tangyh.lamp.learnpm.vo.query.PmMaterialProductionPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMaterialProductionResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMaterialProductionSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMaterialProductionUpdateVO;

/**
 * <p>
 * 物料制作前端控制器
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
@RequestMapping("/pmMaterialProduction")
@Api(value = "PmMaterialProduction", tags = " 物料制作")
public class PmMaterialProductionController extends SuperController<PmMaterialProductionService, Long, PmMaterialProduction, PmMaterialProductionSaveVO, PmMaterialProductionUpdateVO, PmMaterialProductionPageQuery, PmMaterialProductionResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
