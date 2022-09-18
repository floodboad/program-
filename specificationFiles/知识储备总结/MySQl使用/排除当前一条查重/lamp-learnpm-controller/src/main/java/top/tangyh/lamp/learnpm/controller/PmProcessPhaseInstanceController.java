package top.tangyh.lamp.learnpm.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.annotation.log.WebLog;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;
import top.tangyh.lamp.learnpm.service.PmProcessPhaseInstanceService;
import top.tangyh.lamp.learnpm.vo.query.PmProcessPhaseInstancePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProcessPhaseInstanceResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProcessPhaseInstanceUpdateVO;

import javax.websocket.server.PathParam;

/**
 * <p>
 * 流程环节实例前端控制器
 * 
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmProcessPhaseInstance")
@Api(value = "PmProcessPhaseInstance", tags = " 流程环节实例")
public class PmProcessPhaseInstanceController extends SuperController<PmProcessPhaseInstanceService, Long, PmProcessPhaseInstance, PmProcessPhaseInstanceSaveVO, PmProcessPhaseInstanceUpdateVO, PmProcessPhaseInstancePageQuery, PmProcessPhaseInstanceResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    @ApiOperation(value = "获取下一个节点页面", notes = "获取当前节点下一个节点页面，当前节点已经运行过，下一个节点将要运行")
    @GetMapping("/getNextNodePage/{pmApprovalProcessInstanceId}")
    @WebLog(value = "获取下一个节点页面")
    public R<String> getNextNodePage( @PathParam("pmApprovalProcessInstanceId") long pmApprovalProcessInstanceId) {
        try {
            return success(superService.getNextNodePage(pmApprovalProcessInstanceId));
        }catch (Exception e){
            log.error("查询下一个节点页面失败!",e);
            return  fail(e.getMessage());
        }
    }
}
