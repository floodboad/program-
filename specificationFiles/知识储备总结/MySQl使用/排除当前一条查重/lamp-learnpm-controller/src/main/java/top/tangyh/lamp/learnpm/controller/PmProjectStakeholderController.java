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
import top.tangyh.lamp.learnpm.entity.PmProjectStakeholder;
import top.tangyh.lamp.learnpm.service.PmProjectStakeholderService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectStakeholderPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectStakeholderResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectStakeholderSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectStakeholderUpdateVO;

/**
 * <p>
 * 项目干系人前端控制器
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
@RequestMapping("/pmProjectStakeholder")
@Api(value = "PmProjectStakeholder", tags = " 项目干系人")
public class PmProjectStakeholderController extends SuperController<PmProjectStakeholderService, Long, PmProjectStakeholder, PmProjectStakeholderSaveVO, PmProjectStakeholderUpdateVO, PmProjectStakeholderPageQuery, PmProjectStakeholderResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
