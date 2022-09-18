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
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanAdjust;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingPlanAdjustService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingPlanAdjustPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingPlanAdjustResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectMeetingPlanAdjustSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingPlanAdjustUpdateVO;

/**
 * <p>
 * 项目会议规划调整前端控制器
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
@RequestMapping("/pmProjectMeetingPlanAdjust")
@Api(value = "PmProjectMeetingPlanAdjust", tags = " 项目会议规划调整")
public class PmProjectMeetingPlanAdjustController extends SuperController<PmProjectMeetingPlanAdjustService, Long, PmProjectMeetingPlanAdjust, PmProjectMeetingPlanAdjustSaveVO, PmProjectMeetingPlanAdjustUpdateVO, PmProjectMeetingPlanAdjustPageQuery, PmProjectMeetingPlanAdjustResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
