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
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanExeStandards;
import top.tangyh.lamp.learnpm.service.PmMeetingPlanExeStandardsService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingPlanExeStandardsPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanExeStandardsResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingPlanExeStandardsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanExeStandardsUpdateVO;

/**
 * <p>
 * 会议规划执行标准前端控制器
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
@RequestMapping("/pmMeetingPlanExeStandards")
@Api(value = "PmMeetingPlanExeStandards", tags = " 会议规划执行标准")
public class PmMeetingPlanExeStandardsController extends SuperController<PmMeetingPlanExeStandardsService, Long, PmMeetingPlanExeStandards, PmMeetingPlanExeStandardsSaveVO, PmMeetingPlanExeStandardsUpdateVO, PmMeetingPlanExeStandardsPageQuery, PmMeetingPlanExeStandardsResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
