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
import top.tangyh.lamp.learnpm.entity.PmProjectBudgetInfo;
import top.tangyh.lamp.learnpm.service.PmProjectBudgetInfoService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectBudgetInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectBudgetInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectBudgetInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectBudgetInfoUpdateVO;

/**
 * <p>
 * 项目预算信息前端控制器
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmProjectBudgetInfo")
@Api(value = "PmProjectBudgetInfo", tags = " 项目预算信息")
public class PmProjectBudgetInfoController extends SuperController<PmProjectBudgetInfoService, Long, PmProjectBudgetInfo, PmProjectBudgetInfoSaveVO, PmProjectBudgetInfoUpdateVO, PmProjectBudgetInfoPageQuery, PmProjectBudgetInfoResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
