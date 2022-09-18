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
import top.tangyh.lamp.learnpm.entity.MsUpdateOperationRecord;
import top.tangyh.lamp.learnpm.service.MsUpdateOperationRecordService;
import top.tangyh.lamp.learnpm.vo.query.MsUpdateOperationRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsUpdateOperationRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsUpdateOperationRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsUpdateOperationRecordUpdateVO;

/**
 * <p>
 * 基础表更新操作记录前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/msUpdateOperationRecord")
@Api(value = "MsUpdateOperationRecord", tags = " 基础表更新操作记录")
public class MsUpdateOperationRecordController extends SuperController<MsUpdateOperationRecordService, Long, MsUpdateOperationRecord, MsUpdateOperationRecordSaveVO, MsUpdateOperationRecordUpdateVO, MsUpdateOperationRecordPageQuery, MsUpdateOperationRecordResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }

}
