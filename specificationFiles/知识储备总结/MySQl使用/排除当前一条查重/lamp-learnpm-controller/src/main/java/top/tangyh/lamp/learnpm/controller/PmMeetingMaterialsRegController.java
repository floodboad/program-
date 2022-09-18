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
import top.tangyh.lamp.learnpm.entity.PmMeetingMaterialsReg;
import top.tangyh.lamp.learnpm.service.PmMeetingMaterialsRegService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingMaterialsRegPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingMaterialsRegResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingMaterialsRegSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingMaterialsRegUpdateVO;

/**
 * <p>
 * 会议合规材料登记前端控制器
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmMeetingMaterialsReg")
@Api(value = "PmMeetingMaterialsReg", tags = " 会议合规材料登记")
public class PmMeetingMaterialsRegController extends SuperController<PmMeetingMaterialsRegService, Long, PmMeetingMaterialsReg, PmMeetingMaterialsRegSaveVO, PmMeetingMaterialsRegUpdateVO, PmMeetingMaterialsRegPageQuery, PmMeetingMaterialsRegResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
