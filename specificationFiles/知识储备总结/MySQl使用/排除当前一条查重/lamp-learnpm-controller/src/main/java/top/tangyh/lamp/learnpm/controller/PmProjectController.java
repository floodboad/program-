package top.tangyh.lamp.learnpm.controller;


import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.basic.base.request.PageParams;
import top.tangyh.basic.context.ContextUtil;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.PmProject;
import top.tangyh.lamp.learnpm.service.PmProjectService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectUpdateVO;
import top.tangyh.lamp.msg.vo.result.MsgResultVO;
import top.tangyh.lamp.workflow.vo.AuditVO;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 项目信息前端控制器
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
@RequestMapping("/pmProject")
@Api(value = "PmProject", tags = " 项目信息")
public class PmProjectController extends SuperController<PmProjectService, Long, PmProject, PmProjectSaveVO, PmProjectUpdateVO, PmProjectPageQuery, PmProjectResultVO> {

    private final EchoService echoService;
    private final PmProjectService pmProjectService;
    private final  PmProjectService projectService;


    @Override
    public EchoService getEchoService() {
        return echoService;
    }


//    // 项目详情
//
//    @ApiOperation(value = "项目详情", notes = "项目详情")
//    @PostMapping(value = "/pmprojectAll")
//    @RequestMapping(value = "pmprojectAll",method = RequestMethod.POST, produces = "application/json")
//    public R MessageAmountMine(HttpServletRequest request,
//                               @RequestParam(value="phone")String phone
//                           ){
//        return null;
//    }



    /**
     * 项目会议规划新增，同时回填项目信息
     *
     */
    @ApiOperation(value = "项目会议规划新增", notes = "项目会议规划新增")
    @PostMapping(value = "/insert")
    public R insert(@Validated @RequestBody  PmProjectSaveVO saveVO){
        try {
            log.error("会议新增进来了");
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
    @PostMapping(value = "/updateNew")
    public R updateNew(@Validated @RequestBody PmProjectUpdateVO updateVO){
        try {
            superService.update(updateVO);
            return  R.success();
        }catch (Exception e){
            e.printStackTrace();
            return R.fail(e);
        }
    }

    /**
     * 项目审批接口
     */
    @ApiOperation(value = "项目审批接口", notes = "项目审批接口")
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
     * 项目规划专用
     */
    @ApiOperation(value = "项目规划专用", notes = "项目规划专用")
    @PostMapping(value = "/pageList")
    public R<IPage<PmProjectResultVO>> pageList(PageParams<PmProjectPageQuery> params) {
        IPage<PmProject> page = params.buildPage();
//        LbQueryWrap<PmProject> wrap = Wraps.<PmProject>lbQ().eq(PmProject::getProjectStauts, DSConstant.DICTIONARY_PROJECT_STAUTS_04).notIn(PmProject::getMeetingPlanningStatus,DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_02,DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_03);
        LbQueryWrap<PmProject> wrap = Wraps.<PmProject>lbQ().notIn(PmProject::getMeetingPlanningStatus,DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_02,DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_03);
        pmProjectService.page(page, wrap);
        IPage<PmProjectResultVO> voPage = BeanPlusUtil.toBeanPage(page, PmProjectResultVO.class);
        echoService.action(voPage);
        return R.success(voPage);
    }
    /**
     * 项目信息调整
     *
     */
    @ApiOperation(value = "项目信息调整", notes = "项目信息调整")
    @PostMapping(value = "/projectAdjust")
    public R projectAdjust(@Validated @RequestBody PmProjectUpdateVO updateVO){
        try {
            superService.projectAdjust(updateVO);
            return  R.success();
        }catch (Exception e){
            e.printStackTrace();
            return R.fail(e);
        }
    }
}
