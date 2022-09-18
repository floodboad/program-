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
import top.tangyh.lamp.learnpm.entity.PmProjectSponsor;
import top.tangyh.lamp.learnpm.service.PmProjectSponsorService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectSponsorPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectSponsorResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectSponsorSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectSponsorUpdateVO;

/**
 * <p>
 * 项目赞助企业前端控制器
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
@RequestMapping("/pmProjectSponsor")
@Api(value = "PmProjectSponsor", tags = " 项目赞助企业")
public class PmProjectSponsorController extends SuperController<PmProjectSponsorService, Long, PmProjectSponsor, PmProjectSponsorSaveVO, PmProjectSponsorUpdateVO, PmProjectSponsorPageQuery, PmProjectSponsorResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
