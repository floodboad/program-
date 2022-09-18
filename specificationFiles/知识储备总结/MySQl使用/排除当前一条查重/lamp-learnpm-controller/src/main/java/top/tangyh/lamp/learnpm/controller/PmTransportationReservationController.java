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
import top.tangyh.lamp.learnpm.entity.PmTransportationReservation;
import top.tangyh.lamp.learnpm.service.PmTransportationReservationService;
import top.tangyh.lamp.learnpm.vo.query.PmTransportationReservationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmTransportationReservationResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmTransportationReservationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmTransportationReservationUpdateVO;

/**
 * <p>
 * 交通预定前端控制器
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmTransportationReservation")
@Api(value = "PmTransportationReservation", tags = " 交通预定")
public class PmTransportationReservationController extends SuperController<PmTransportationReservationService, Long, PmTransportationReservation, PmTransportationReservationSaveVO, PmTransportationReservationUpdateVO, PmTransportationReservationPageQuery, PmTransportationReservationResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
