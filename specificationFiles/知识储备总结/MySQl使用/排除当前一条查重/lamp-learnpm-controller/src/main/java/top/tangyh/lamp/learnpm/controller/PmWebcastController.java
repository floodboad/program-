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
import top.tangyh.lamp.learnpm.entity.PmWebcast;
import top.tangyh.lamp.learnpm.service.PmWebcastService;
import top.tangyh.lamp.learnpm.vo.query.PmWebcastPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmWebcastResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmWebcastSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmWebcastUpdateVO;

/**
 * <p>
 * 网上直播前端控制器
 * 
 * </p>
 *
 * @author liyy
 * @date 2022-06-14
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmWebcast")
@Api(value = "PmWebcast", tags = " 网上直播")
public class PmWebcastController extends SuperController<PmWebcastService, Long, PmWebcast, PmWebcastSaveVO, PmWebcastUpdateVO, PmWebcastPageQuery, PmWebcastResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
