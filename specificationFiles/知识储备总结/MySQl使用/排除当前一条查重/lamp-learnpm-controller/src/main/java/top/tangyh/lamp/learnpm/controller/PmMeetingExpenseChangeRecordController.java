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
import top.tangyh.lamp.learnpm.entity.PmMeetingExpenseChangeRecord;
import top.tangyh.lamp.learnpm.service.PmMeetingExpenseChangeRecordService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExpenseChangeRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExpenseChangeRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExpenseChangeRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExpenseChangeRecordUpdateVO;

/**
 * <p>
 * 会议费用变更记录前端控制器
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
@RequestMapping("/pmMeetingExpenseChangeRecord")
@Api(value = "PmMeetingExpenseChangeRecord", tags = " 会议费用变更记录")
public class PmMeetingExpenseChangeRecordController extends SuperController<PmMeetingExpenseChangeRecordService, Long, PmMeetingExpenseChangeRecord, PmMeetingExpenseChangeRecordSaveVO, PmMeetingExpenseChangeRecordUpdateVO, PmMeetingExpenseChangeRecordPageQuery, PmMeetingExpenseChangeRecordResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
