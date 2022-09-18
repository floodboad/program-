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
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandardAdj;
import top.tangyh.lamp.learnpm.service.PmExpertServiceStandardAdjService;
import top.tangyh.lamp.learnpm.vo.query.PmExpertServiceStandardAdjPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmExpertServiceStandardAdjResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertServiceStandardAdjSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertServiceStandardAdjUpdateVO;

/**
 * <p>
 * 会议规划专家劳务标准调整记录前端控制器
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
@RequestMapping("/pmExpertServiceStandardAdj")
@Api(value = "PmExpertServiceStandardAdj", tags = " 会议规划专家劳务标准调整记录")
public class PmExpertServiceStandardAdjController extends SuperController<PmExpertServiceStandardAdjService, Long, PmExpertServiceStandardAdj, PmExpertServiceStandardAdjSaveVO, PmExpertServiceStandardAdjUpdateVO, PmExpertServiceStandardAdjPageQuery, PmExpertServiceStandardAdjResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
