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
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterials;
import top.tangyh.lamp.learnpm.service.PmComplianceMaterialsService;
import top.tangyh.lamp.learnpm.vo.query.PmComplianceMaterialsPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmComplianceMaterialsResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmComplianceMaterialsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmComplianceMaterialsUpdateVO;

/**
 * <p>
 * 项目合规材料前端控制器
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
@RequestMapping("/pmComplianceMaterials")
@Api(value = "PmComplianceMaterials", tags = " 项目合规材料")
public class PmComplianceMaterialsController extends SuperController<PmComplianceMaterialsService, Long, PmComplianceMaterials, PmComplianceMaterialsSaveVO, PmComplianceMaterialsUpdateVO, PmComplianceMaterialsPageQuery, PmComplianceMaterialsResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
