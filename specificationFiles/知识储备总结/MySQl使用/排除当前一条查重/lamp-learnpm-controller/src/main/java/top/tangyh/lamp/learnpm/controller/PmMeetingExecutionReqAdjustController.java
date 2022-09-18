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
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReqAdjust;
import top.tangyh.lamp.learnpm.service.PmMeetingExecutionReqAdjustService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExecutionReqAdjustPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExecutionReqAdjustResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExecutionReqAdjustSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExecutionReqAdjustUpdateVO;

/**
 * <p>
 * 会议执行要求调整记录前端控制器
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmMeetingExecutionReqAdjust")
@Api(value = "PmMeetingExecutionReqAdjust", tags = " 会议执行要求调整记录")
public class PmMeetingExecutionReqAdjustController extends SuperController<PmMeetingExecutionReqAdjustService, Long, PmMeetingExecutionReqAdjust, PmMeetingExecutionReqAdjustSaveVO, PmMeetingExecutionReqAdjustUpdateVO, PmMeetingExecutionReqAdjustPageQuery, PmMeetingExecutionReqAdjustResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
