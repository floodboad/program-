package top.tangyh.lamp.learnpm.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessConfig;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import top.tangyh.lamp.learnpm.service.PmApprovalProcessConfigService;
import top.tangyh.lamp.learnpm.vo.query.PmApprovalProcessConfigPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmApprovalProcessConfigResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmApprovalProcessConfigSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmApprovalProcessConfigUpdateVO;

/**
 * <p>
 * 审批流配置前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmApprovalProcessConfig")
@Api(value = "PmApprovalProcessConfig", tags = " 审批流配置")
public class PmApprovalProcessConfigController extends SuperController<PmApprovalProcessConfigService, Long, PmApprovalProcessConfig, PmApprovalProcessConfigSaveVO, PmApprovalProcessConfigUpdateVO, PmApprovalProcessConfigPageQuery, PmApprovalProcessConfigResultVO> {

    private final PmApprovalProcessConfigService ProcessConfigService;
    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
    // 用于新增时判重
    @Override
    public R<PmApprovalProcessConfig> save(PmApprovalProcessConfigSaveVO pmApprovalProcessConfigSaveVO){
        Boolean approvalProcessConfig = ProcessConfigService.processNameRepeatOrNot(pmApprovalProcessConfigSaveVO);
        if(approvalProcessConfig){
            return R.fail("流程名称已经存在！");
        }
        return R.success(superService.save(pmApprovalProcessConfigSaveVO));
    }
    // 用于更新时判重
    @Override
    public R<PmApprovalProcessConfig> update(PmApprovalProcessConfigUpdateVO pmApprovalProcessConfigUpdateVO){
        Boolean  PmApprovalProcessConfig = ProcessConfigService.processNameRepeatOrNot2(pmApprovalProcessConfigUpdateVO);
        if (PmApprovalProcessConfig){
            return R.success(superService.updateById(pmApprovalProcessConfigUpdateVO),"验证成功可以编辑更改");
        }
        return R.fail("验证不通过，请重新输入信息");
    }

    @RequestMapping("/getFirstProcessPhaseConf")
    public R<String> getFirstProcessPhaseConf(@RequestParam("processName")String processName){
        Integer linkSequence = DSConstant.MIN_LINK_SEQUENCE;
        String viewName = ProcessConfigService.getFirstProcessPhaseConf(linkSequence,processName);
        return R.success(viewName);
    }

}
