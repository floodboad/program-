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
import top.tangyh.lamp.learnpm.entity.PmWkNodeTypeConf;
import top.tangyh.lamp.learnpm.service.PmWkNodeTypeConfService;
import top.tangyh.lamp.learnpm.vo.query.PmWkNodeTypeConfPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmWkNodeTypeConfResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmWkNodeTypeConfSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmWkNodeTypeConfUpdateVO;

/**
 * <p>
 * 工作流节点类型配置前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmWkNodeTypeConf")
@Api(value = "PmWkNodeTypeConf", tags = " 工作流节点类型配置")
public class PmWkNodeTypeConfController extends SuperController<PmWkNodeTypeConfService, Long, PmWkNodeTypeConf, PmWkNodeTypeConfSaveVO, PmWkNodeTypeConfUpdateVO, PmWkNodeTypeConfPageQuery, PmWkNodeTypeConfResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
