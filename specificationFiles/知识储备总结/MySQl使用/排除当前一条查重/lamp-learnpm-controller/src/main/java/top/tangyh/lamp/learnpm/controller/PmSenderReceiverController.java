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
import top.tangyh.lamp.learnpm.entity.PmSenderReceiver;
import top.tangyh.lamp.learnpm.service.PmSenderReceiverService;
import top.tangyh.lamp.learnpm.vo.query.PmSenderReceiverPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmSenderReceiverResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmSenderReceiverSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmSenderReceiverUpdateVO;

/**
 * <p>
 * 收发件人前端控制器
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-09
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmSenderReceiver")
@Api(value = "PmSenderReceiver", tags = " 收发件人")
public class PmSenderReceiverController extends SuperController<PmSenderReceiverService, Long, PmSenderReceiver, PmSenderReceiverSaveVO, PmSenderReceiverUpdateVO, PmSenderReceiverPageQuery, PmSenderReceiverResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
