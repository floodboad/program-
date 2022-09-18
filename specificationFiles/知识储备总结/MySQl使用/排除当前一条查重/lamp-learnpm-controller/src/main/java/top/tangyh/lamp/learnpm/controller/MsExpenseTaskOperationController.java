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
import top.tangyh.lamp.learnpm.entity.MsExpenseTaskOperation;
import top.tangyh.lamp.learnpm.service.MsExpenseTaskOperationService;
import top.tangyh.lamp.learnpm.vo.query.MsExpenseTaskOperationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExpenseTaskOperationResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExpenseTaskOperationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExpenseTaskOperationUpdateVO;

/**
 * <p>
 * 费用任务操作前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-14
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/msExpenseTaskOperation")
@Api(value = "MsExpenseTaskOperation", tags = " 费用任务操作")
public class MsExpenseTaskOperationController extends SuperController<MsExpenseTaskOperationService, Long, MsExpenseTaskOperation, MsExpenseTaskOperationSaveVO, MsExpenseTaskOperationUpdateVO, MsExpenseTaskOperationPageQuery, MsExpenseTaskOperationResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
