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
import top.tangyh.lamp.learnpm.entity.MsPjComplianceFileDef;
import top.tangyh.lamp.learnpm.service.MsPjComplianceFileDefService;
import top.tangyh.lamp.learnpm.vo.query.MsPjComplianceFileDefPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsPjComplianceFileDefResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsPjComplianceFileDefSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsPjComplianceFileDefUpdateVO;

/**
 * <p>
 * 项目合规文件定义前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-07-06
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/msPjComplianceFileDef")
@Api(value = "MsPjComplianceFileDef", tags = " 项目合规文件定义")
public class MsPjComplianceFileDefController extends SuperController<MsPjComplianceFileDefService, Long, MsPjComplianceFileDef, MsPjComplianceFileDefSaveVO, MsPjComplianceFileDefUpdateVO, MsPjComplianceFileDefPageQuery, MsPjComplianceFileDefResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
