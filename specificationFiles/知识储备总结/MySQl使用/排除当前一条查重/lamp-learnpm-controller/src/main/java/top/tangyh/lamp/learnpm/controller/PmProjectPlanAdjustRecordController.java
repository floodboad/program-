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
import top.tangyh.lamp.learnpm.entity.PmProjectPlanAdjustRecord;
import top.tangyh.lamp.learnpm.service.PmProjectPlanAdjustRecordService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectPlanAdjustRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectPlanAdjustRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectPlanAdjustRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectPlanAdjustRecordUpdateVO;
import top.tangyh.lamp.workflow.vo.AuditVO;

/**
 * <p>
 * 项目规划调整记录前端控制器
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
@RequestMapping("/pmProjectPlanAdjustRecord")
@Api(value = "PmProjectPlanAdjustRecord", tags = " 项目规划调整记录")
public class PmProjectPlanAdjustRecordController extends SuperController<PmProjectPlanAdjustRecordService, Long, PmProjectPlanAdjustRecord, PmProjectPlanAdjustRecordSaveVO, PmProjectPlanAdjustRecordUpdateVO, PmProjectPlanAdjustRecordPageQuery, PmProjectPlanAdjustRecordResultVO> {


    private final EchoService echoService;

    @Override
    public EchoService getEchoService() {
        return echoService;
    }
    /**
     * 审批提交接口
     */
    @ApiOperation(value = "项目会议规划审批接口", notes = "项目会议规划审批接口")
    @PostMapping(value = "/audit")
    public R audit(@RequestBody AuditVO auditVO){
        try {
            superService.audit(auditVO);
            return  R.success();
        }catch (Exception e){
            return R.fail(e);
        }
    }
}
