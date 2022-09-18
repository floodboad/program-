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
import top.tangyh.lamp.learnpm.entity.MsBudgetSubject;
import top.tangyh.lamp.learnpm.service.MsBudgetSubjectService;
import top.tangyh.lamp.learnpm.vo.query.MsBudgetSubjectPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsBudgetSubjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsBudgetSubjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsBudgetSubjectUpdateVO;

/**
 * <p>
 * 预算科目前端控制器
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
@RequestMapping("/msBudgetSubject")
@Api(value = "MsBudgetSubject", tags = " 预算科目")
public class MsBudgetSubjectController extends SuperController<MsBudgetSubjectService, Long, MsBudgetSubject, MsBudgetSubjectSaveVO, MsBudgetSubjectUpdateVO, MsBudgetSubjectPageQuery, MsBudgetSubjectResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
