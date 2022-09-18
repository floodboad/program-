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
import top.tangyh.lamp.learnpm.entity.PmOrderFood;
import top.tangyh.lamp.learnpm.service.PmOrderFoodService;
import top.tangyh.lamp.learnpm.vo.query.PmOrderFoodPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOrderFoodResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOrderFoodSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOrderFoodUpdateVO;

/**
 * <p>
 * 订餐前端控制器
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmOrderFood")
@Api(value = "PmOrderFood", tags = " 订餐")
public class PmOrderFoodController extends SuperController<PmOrderFoodService, Long, PmOrderFood, PmOrderFoodSaveVO, PmOrderFoodUpdateVO, PmOrderFoodPageQuery, PmOrderFoodResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
