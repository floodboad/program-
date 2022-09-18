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
import top.tangyh.lamp.learnpm.entity.PmOnlineMeetingPublish;
import top.tangyh.lamp.learnpm.service.PmOnlineMeetingPublishService;
import top.tangyh.lamp.learnpm.vo.query.PmOnlineMeetingPublishPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOnlineMeetingPublishResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOnlineMeetingPublishSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOnlineMeetingPublishUpdateVO;

/**
 * <p>
 * 线上会议发布前端控制器
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
@RequestMapping("/pmOnlineMeetingPublish")
@Api(value = "PmOnlineMeetingPublish", tags = " 线上会议发布")
public class PmOnlineMeetingPublishController extends SuperController<PmOnlineMeetingPublishService, Long, PmOnlineMeetingPublish, PmOnlineMeetingPublishSaveVO, PmOnlineMeetingPublishUpdateVO, PmOnlineMeetingPublishPageQuery, PmOnlineMeetingPublishResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
