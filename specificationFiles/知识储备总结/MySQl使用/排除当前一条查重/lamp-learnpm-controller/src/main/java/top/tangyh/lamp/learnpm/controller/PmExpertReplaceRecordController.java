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
import top.tangyh.lamp.learnpm.entity.PmExpertReplaceRecord;
import top.tangyh.lamp.learnpm.service.PmExpertReplaceRecordService;
import top.tangyh.lamp.learnpm.vo.query.PmExpertReplaceRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmExpertReplaceRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertReplaceRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertReplaceRecordUpdateVO;

/**
 * <p>
 * 专家更换记录前端控制器
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmExpertReplaceRecord")
@Api(value = "PmExpertReplaceRecord", tags = " 专家更换记录")
public class PmExpertReplaceRecordController extends SuperController<PmExpertReplaceRecordService, Long, PmExpertReplaceRecord, PmExpertReplaceRecordSaveVO, PmExpertReplaceRecordUpdateVO, PmExpertReplaceRecordPageQuery, PmExpertReplaceRecordResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
