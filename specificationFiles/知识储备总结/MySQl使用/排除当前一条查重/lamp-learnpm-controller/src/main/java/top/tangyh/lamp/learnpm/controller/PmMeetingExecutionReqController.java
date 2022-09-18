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
import top.tangyh.lamp.learnpm.entity.PmMeetingExecutionReq;
import top.tangyh.lamp.learnpm.service.PmMeetingExecutionReqService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExecutionReqPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExecutionReqResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExecutionReqSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExecutionReqUpdateVO;

/**
 * <p>
 * 会议执行要求前端控制器
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmMeetingExecutionReq")
@Api(value = "PmMeetingExecutionReq", tags = " 会议执行要求")
public class PmMeetingExecutionReqController extends SuperController<PmMeetingExecutionReqService, Long, PmMeetingExecutionReq, PmMeetingExecutionReqSaveVO, PmMeetingExecutionReqUpdateVO, PmMeetingExecutionReqPageQuery, PmMeetingExecutionReqResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
