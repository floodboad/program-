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
import top.tangyh.lamp.learnpm.entity.MsExecutionSessionType;
import top.tangyh.lamp.learnpm.service.MsExecutionSessionTypeService;
import top.tangyh.lamp.learnpm.vo.query.MsExecutionSessionTypePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExecutionSessionTypeResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExecutionSessionTypeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExecutionSessionTypeUpdateVO;

/**
 * <p>
 * 执行场次类型前端控制器
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/msExecutionSessionType")
@Api(value = "MsExecutionSessionType", tags = " 执行场次类型")
public class MsExecutionSessionTypeController extends SuperController<MsExecutionSessionTypeService, Long, MsExecutionSessionType, MsExecutionSessionTypeSaveVO, MsExecutionSessionTypeUpdateVO, MsExecutionSessionTypePageQuery, MsExecutionSessionTypeResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
