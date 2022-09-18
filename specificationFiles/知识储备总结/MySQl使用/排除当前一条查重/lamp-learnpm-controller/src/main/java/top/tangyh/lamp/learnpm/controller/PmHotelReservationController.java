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
import top.tangyh.lamp.learnpm.entity.PmHotelReservation;
import top.tangyh.lamp.learnpm.service.PmHotelReservationService;
import top.tangyh.lamp.learnpm.vo.query.PmHotelReservationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmHotelReservationResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmHotelReservationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmHotelReservationUpdateVO;

/**
 * <p>
 * 订酒店前端控制器
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
@RequestMapping("/pmHotelReservation")
@Api(value = "PmHotelReservation", tags = " 订酒店")
public class PmHotelReservationController extends SuperController<PmHotelReservationService, Long, PmHotelReservation, PmHotelReservationSaveVO, PmHotelReservationUpdateVO, PmHotelReservationPageQuery, PmHotelReservationResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
