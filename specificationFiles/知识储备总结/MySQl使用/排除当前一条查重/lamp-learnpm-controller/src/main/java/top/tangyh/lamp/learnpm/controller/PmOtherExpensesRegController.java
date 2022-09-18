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
import top.tangyh.lamp.learnpm.entity.PmOtherExpensesReg;
import top.tangyh.lamp.learnpm.service.PmOtherExpensesRegService;
import top.tangyh.lamp.learnpm.vo.query.PmOtherExpensesRegPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOtherExpensesRegResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOtherExpensesRegSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOtherExpensesRegUpdateVO;

/**
 * <p>
 * 会议执行费用支付录入前端控制器
 * 
 * </p>
 *
 * @author dz
 * @date 2022-07-04
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmOtherExpensesReg")
@Api(value = "PmOtherExpensesReg", tags = " 会议执行费用支付录入")
public class PmOtherExpensesRegController extends SuperController<PmOtherExpensesRegService, Long, PmOtherExpensesReg, PmOtherExpensesRegSaveVO, PmOtherExpensesRegUpdateVO, PmOtherExpensesRegPageQuery, PmOtherExpensesRegResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
