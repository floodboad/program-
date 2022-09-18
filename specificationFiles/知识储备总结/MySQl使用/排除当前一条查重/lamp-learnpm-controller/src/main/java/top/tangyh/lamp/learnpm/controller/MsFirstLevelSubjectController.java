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
import top.tangyh.lamp.learnpm.entity.MsFirstLevelSubject;
import top.tangyh.lamp.learnpm.service.MsFirstLevelSubjectService;
import top.tangyh.lamp.learnpm.vo.query.MsFirstLevelSubjectPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsFirstLevelSubjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsFirstLevelSubjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsFirstLevelSubjectUpdateVO;

/**
 * <p>
 * 一级科目维护前端控制器
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-16
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/msFirstLevelSubject")
@Api(value = "MsFirstLevelSubject", tags = " 一级科目维护")
public class MsFirstLevelSubjectController extends SuperController<MsFirstLevelSubjectService, Long, MsFirstLevelSubject, MsFirstLevelSubjectSaveVO, MsFirstLevelSubjectUpdateVO, MsFirstLevelSubjectPageQuery, MsFirstLevelSubjectResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
