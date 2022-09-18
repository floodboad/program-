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
import top.tangyh.lamp.learnpm.entity.PmConferenceApplyFee;
import top.tangyh.lamp.learnpm.service.PmConferenceApplyFeeService;
import top.tangyh.lamp.learnpm.vo.query.PmConferenceApplyFeePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmConferenceApplyFeeResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceApplyFeeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceApplyFeeUpdateVO;

/**
 * <p>
 * 会议申请费用表前端控制器
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmConferenceApplyFee")
@Api(value = "PmConferenceApplyFee", tags = " 会议申请费用表")
public class PmConferenceApplyFeeController extends SuperController<PmConferenceApplyFeeService, Long, PmConferenceApplyFee, PmConferenceApplyFeeSaveVO, PmConferenceApplyFeeUpdateVO, PmConferenceApplyFeePageQuery, PmConferenceApplyFeeResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
