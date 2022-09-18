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
import top.tangyh.lamp.learnpm.entity.MsDepartmentInfo;
import top.tangyh.lamp.learnpm.service.MsDepartmentInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsDepartmentInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsDepartmentInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsDepartmentInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsDepartmentInfoUpdateVO;

/**
 * <p>
 * 科室信息前端控制器
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-13
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/msDepartmentInfo")
@Api(value = "MsDepartmentInfo", tags = " 科室信息")
public class MsDepartmentInfoController extends SuperController<MsDepartmentInfoService, Long, MsDepartmentInfo, MsDepartmentInfoSaveVO, MsDepartmentInfoUpdateVO, MsDepartmentInfoPageQuery, MsDepartmentInfoResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
