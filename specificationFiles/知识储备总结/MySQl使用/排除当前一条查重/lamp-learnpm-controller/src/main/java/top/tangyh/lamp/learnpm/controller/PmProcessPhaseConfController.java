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
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import top.tangyh.lamp.learnpm.service.PmProcessPhaseConfService;
import top.tangyh.lamp.learnpm.vo.query.PmProcessPhaseConfPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProcessPhaseConfResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseConfSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProcessPhaseConfUpdateVO;

/**
 * <p>
 * 流程环节配置前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmProcessPhaseConf")
@Api(value = "PmProcessPhaseConf", tags = " 流程环节配置")
public class PmProcessPhaseConfController extends SuperController<PmProcessPhaseConfService, Long, PmProcessPhaseConf, PmProcessPhaseConfSaveVO, PmProcessPhaseConfUpdateVO, PmProcessPhaseConfPageQuery, PmProcessPhaseConfResultVO> {

    private final EchoService echoService;

    private final PmProcessPhaseConfService processPhaseConfService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    @Override
    public R<PmProcessPhaseConf> save(PmProcessPhaseConfSaveVO pmProcessPhaseConfSaveVO){

        Boolean isEnd = processPhaseConfService.isEndrequirements(pmProcessPhaseConfSaveVO);
        Boolean linkId = processPhaseConfService.controlLinkIdCheck(pmProcessPhaseConfSaveVO);
        if (isEnd && linkId){
            return R.fail("验证不通过，请重新输入");
        }
        return R.success(superService.save(pmProcessPhaseConfSaveVO),"验证通过");
    }
}
