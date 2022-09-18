package top.tangyh.lamp.learnpm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.tangyh.basic.annotation.log.WebLog;
import top.tangyh.basic.base.R;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.lamp.learnpm.service.MsSecondarySubjectService;
import top.tangyh.lamp.learnpm.entity.MsSecondarySubject;
import top.tangyh.lamp.learnpm.vo.save.MsSecondarySubjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsSecondarySubjectUpdateVO;
import top.tangyh.lamp.learnpm.vo.result.MsSecondarySubjectResultVO;
import top.tangyh.lamp.learnpm.vo.query.MsSecondarySubjectPageQuery;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * 二级科目维护
 * </p>
 *
 * @author zuihou
 * @date 2022-06-17 11:55:05
 * @create [2022-06-17 11:55:05] [zuihou] [代码生成器生成]
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/msSecondarySubject")
@Api(value = "MsSecondarySubject", tags = "二级科目维护")
public class MsSecondarySubjectController extends SuperController<MsSecondarySubjectService, Long, MsSecondarySubject, MsSecondarySubjectSaveVO,
    MsSecondarySubjectUpdateVO, MsSecondarySubjectPageQuery, MsSecondarySubjectResultVO> {
    private final EchoService echoService;
    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    /**
     * 按树结构查询
     *
     * @param pageQuery 查询参数
     * @return 查询结果
     */
    @ApiOperation(value = "按树结构查询", notes = "按树结构查询")
    @PostMapping("/tree")
    @WebLog("级联查询")
    public R<List<MsSecondarySubject>> tree(@RequestBody MsSecondarySubjectPageQuery pageQuery) {
        return success(superService.findTree(pageQuery));
    }
}


