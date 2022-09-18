package top.tangyh.lamp.learnpm.controller;


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
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;
import top.tangyh.lamp.learnpm.service.PmApprovalProcessInstanceService;
import top.tangyh.lamp.learnpm.vo.query.PmApprovalProcessInstancePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmApprovalProcessInstanceResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmApprovalProcessInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmApprovalProcessInstanceUpdateVO;
import top.tangyh.lamp.learnpm.wechat.WO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 审批流实例前端控制器
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
@RequestMapping("/pmApprovalProcessInstance")
@Api(value = "PmApprovalProcessInstance", tags = " 审批流实例")
public class PmApprovalProcessInstanceController extends SuperController<PmApprovalProcessInstanceService, Long, PmApprovalProcessInstance, PmApprovalProcessInstanceSaveVO, PmApprovalProcessInstanceUpdateVO, PmApprovalProcessInstancePageQuery, PmApprovalProcessInstanceResultVO> {

    private final EchoService echoService;
    private final PmApprovalProcessInstanceService pmApprovalProcessInstanceService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    /**
     * 待办列表
     * @param request
     * @return
     */
    @ApiOperation(value = "待办列表", notes = "待办列表")
    @PostMapping(value = "/backlogdataVolumeList")
    @RequestMapping(value = "backlogdataVolumeList",method = RequestMethod.POST, produces = "application/json")
    public R backlogdataVolumeList(HttpServletRequest request){

        // 返回指定内容的json，json格式：{标题，流程名称，业务类型，申请人，申请时间}
        // 审批流程实例查前三个属性，流程环节实例查找申请时间，申请人，
        String userId = String.valueOf(WO.getUserId(request));
        Integer flagApplyNum = 1;
        List<String> jsonList = pmApprovalProcessInstanceService.jsonToDoList(userId,flagApplyNum);
        return R.success(jsonList);
    }
}

