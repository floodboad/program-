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
import top.tangyh.lamp.learnpm.entity.PmMeetingExeStatusAction;
import top.tangyh.lamp.learnpm.service.PmMeetingExeStatusActionService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExeStatusActionPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExeStatusActionResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExeStatusActionSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExeStatusActionUpdateVO;

/**
 * <p>
 * 会议执行状态操作表前端控制器
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
@RequestMapping("/pmMeetingExeStatusAction")
@Api(value = "PmMeetingExeStatusAction", tags = " 会议执行状态操作表")
public class PmMeetingExeStatusActionController extends SuperController<PmMeetingExeStatusActionService, Long, PmMeetingExeStatusAction, PmMeetingExeStatusActionSaveVO, PmMeetingExeStatusActionUpdateVO, PmMeetingExeStatusActionPageQuery, PmMeetingExeStatusActionResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
