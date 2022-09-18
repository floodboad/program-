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
import top.tangyh.lamp.learnpm.entity.PmPersonChargeAdjustRecord;
import top.tangyh.lamp.learnpm.service.PmPersonChargeAdjustRecordService;
import top.tangyh.lamp.learnpm.vo.query.PmPersonChargeAdjustRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmPersonChargeAdjustRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmPersonChargeAdjustRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmPersonChargeAdjustRecordUpdateVO;

/**
 * <p>
 * 项目负责人及规划负责人调整记录前端控制器
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
@RequestMapping("/pmPersonChargeAdjustRecord")
@Api(value = "PmPersonChargeAdjustRecord", tags = " 项目负责人及规划负责人调整记录")
public class PmPersonChargeAdjustRecordController extends SuperController<PmPersonChargeAdjustRecordService, Long, PmPersonChargeAdjustRecord, PmPersonChargeAdjustRecordSaveVO, PmPersonChargeAdjustRecordUpdateVO, PmPersonChargeAdjustRecordPageQuery, PmPersonChargeAdjustRecordResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
