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
import top.tangyh.lamp.learnpm.entity.PmCompanyFinance;
import top.tangyh.lamp.learnpm.service.PmCompanyFinanceService;
import top.tangyh.lamp.learnpm.vo.query.PmCompanyFinancePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmCompanyFinanceResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmCompanyFinanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmCompanyFinanceUpdateVO;

/**
 * <p>
 * 公司财务人员前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmCompanyFinance")
@Api(value = "PmCompanyFinance", tags = " 公司财务人员")
public class PmCompanyFinanceController extends SuperController<PmCompanyFinanceService, Long, PmCompanyFinance, PmCompanyFinanceSaveVO, PmCompanyFinanceUpdateVO, PmCompanyFinancePageQuery, PmCompanyFinanceResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
