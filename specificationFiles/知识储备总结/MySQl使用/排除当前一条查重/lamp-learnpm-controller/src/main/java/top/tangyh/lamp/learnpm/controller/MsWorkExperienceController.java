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
import top.tangyh.lamp.learnpm.entity.MsWorkExperience;
import top.tangyh.lamp.learnpm.service.MsWorkExperienceService;
import top.tangyh.lamp.learnpm.vo.query.MsWorkExperiencePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsWorkExperienceResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsWorkExperienceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsWorkExperienceUpdateVO;

/**
 * <p>
 * 工作经历前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/msWorkExperience")
@Api(value = "MsWorkExperience", tags = " 工作经历")
public class MsWorkExperienceController extends SuperController<MsWorkExperienceService, Long, MsWorkExperience, MsWorkExperienceSaveVO, MsWorkExperienceUpdateVO, MsWorkExperiencePageQuery, MsWorkExperienceResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
