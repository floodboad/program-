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
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanning;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingPlanningService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingPlanningPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingPlanningResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectMeetingPlanningSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingPlanningUpdateVO;
import top.tangyh.lamp.workflow.vo.AuditVO;

/**
 * <p>
 * 项目会议规划前端控制器
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmProjectMeetingPlanning")
@Api(value = "PmProjectMeetingPlanning", tags = " 项目会议规划")
public class PmProjectMeetingPlanningController extends SuperController<PmProjectMeetingPlanningService, Long, PmProjectMeetingPlanning, PmProjectMeetingPlanningSaveVO, PmProjectMeetingPlanningUpdateVO, PmProjectMeetingPlanningPageQuery, PmProjectMeetingPlanningResultVO> {

    private final EchoService echoService;

    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    /**
     * 项目会议规划新增，同时回填项目信息
     *
     */
    @ApiOperation(value = "项目会议规划新增", notes = "项目会议规划新增")
    @PostMapping(value = "/insert")
    public R insert(@RequestBody PmProjectMeetingPlanningSaveVO saveVO){
        try {
            superService.insert(saveVO);
            return  R.success();
        }catch (Exception e){
         e.printStackTrace();
            return R.fail(e);
        }
    }
    /**
     * 项目会议规划修改，同时回填项目信息
     *
     */
    @ApiOperation(value = "项目会议规划修改", notes = "项目会议规划修改")
    @PostMapping(value = "/update")
    public R update(@RequestBody PmProjectMeetingPlanningUpdateVO updateVO){
        try {
            superService.update(updateVO);
            return  R.success();
        }catch (Exception e){
            e.printStackTrace();
            return R.fail(e);
        }
    }
    /**
     *项目规划完成后提交审核
     */
    @ApiOperation(value = "项目会议规划提交审核", notes = "项目会议规划提交审核")
    @GetMapping(value = "/commitAudit")
    public R commitAudit(@RequestParam("projectId")Long projectId){
        try {
            superService.commitAudit(projectId);
            return  R.success();
        }catch (Exception e){
            e.printStackTrace();
            return R.fail(e);
        }
    }
    /**
     *会议调整提交审核
     */
    @ApiOperation(value = "会议调整提交审核", notes = "会议调整提交审核")
    @GetMapping(value = "/commitPlanAdjustAudit")
    public R commitPlanAdjustAudit(@RequestParam("projectId")Long projectId){
        try {
            superService.commitPlanAdjustAudit(projectId);
            return  R.success();
        }catch (Exception e){
            e.printStackTrace();
            return R.fail(e);
        }
    }
    /**
     *项目会议规划审核页面数据组装
     */
    @ApiOperation(value = "项目会议规划审核页面数据组装", notes = "项目会议规划审核页面数据组装")
    @PostMapping(value = "/auditPage")
    public R auditPage(@RequestParam("projectId")Long projectId){
        try {
            return  R.success(superService.auditPage(projectId));
        }catch (Exception e){
            e.printStackTrace();
            return R.fail(e);
        }
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
            e.printStackTrace();
            return R.fail(e);
        }
    }
    /**
     * 规划调整接口
     */
    @ApiOperation(value = "规划调整接口", notes = "规划调整接口")
    @PostMapping(value = "/adjustPlan")
    public R adjustPlan(@RequestBody PmProjectMeetingPlanningUpdateVO updateVO){
        try {
            superService.adjustPlan(updateVO);
            return  R.success();
        }catch (Exception e){
            e.printStackTrace();
            return R.fail(e);
        }
    }
}
