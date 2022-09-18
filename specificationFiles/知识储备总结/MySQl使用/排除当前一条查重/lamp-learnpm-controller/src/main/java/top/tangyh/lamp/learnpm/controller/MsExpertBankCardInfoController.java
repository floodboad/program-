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
import top.tangyh.lamp.learnpm.entity.MsExpertBankCardInfo;
import top.tangyh.lamp.learnpm.service.MsExpertBankCardInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsExpertBankCardInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExpertBankCardInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExpertBankCardInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExpertBankCardInfoUpdateVO;

/**
 * <p>
 * 专家银行卡信息前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/msExpertBankCardInfo")
@Api(value = "MsExpertBankCardInfo", tags = " 专家银行卡信息")
public class MsExpertBankCardInfoController extends SuperController<MsExpertBankCardInfoService, Long, MsExpertBankCardInfo, MsExpertBankCardInfoSaveVO, MsExpertBankCardInfoUpdateVO, MsExpertBankCardInfoPageQuery, MsExpertBankCardInfoResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
