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
import top.tangyh.lamp.learnpm.entity.MsProjectTypeSettings;
import top.tangyh.lamp.learnpm.service.MsProjectTypeSettingsService;
import top.tangyh.lamp.learnpm.vo.query.MsProjectTypeSettingsPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsProjectTypeSettingsResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsProjectTypeSettingsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsProjectTypeSettingsUpdateVO;

/**
 * <p>
 * 项目类型设置前端控制器
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/msProjectTypeSettings")
@Api(value = "MsProjectTypeSettings", tags = " 项目类型设置")
public class MsProjectTypeSettingsController extends SuperController<MsProjectTypeSettingsService, Long, MsProjectTypeSettings, MsProjectTypeSettingsSaveVO, MsProjectTypeSettingsUpdateVO, MsProjectTypeSettingsPageQuery, MsProjectTypeSettingsResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
