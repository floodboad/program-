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
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterialAdjust;
import top.tangyh.lamp.learnpm.service.PmComplianceMaterialAdjustService;
import top.tangyh.lamp.learnpm.vo.query.PmComplianceMaterialAdjustPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmComplianceMaterialAdjustResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmComplianceMaterialAdjustSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmComplianceMaterialAdjustUpdateVO;

/**
 * <p>
 * 项目合规材料调整前端控制器
 * 
 * </p>
 *
 * @author liyy
 * @date 2022-06-28
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmComplianceMaterialAdjust")
@Api(value = "PmComplianceMaterialAdjust", tags = " 项目合规材料调整")
public class PmComplianceMaterialAdjustController extends SuperController<PmComplianceMaterialAdjustService, Long, PmComplianceMaterialAdjust, PmComplianceMaterialAdjustSaveVO, PmComplianceMaterialAdjustUpdateVO, PmComplianceMaterialAdjustPageQuery, PmComplianceMaterialAdjustResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
