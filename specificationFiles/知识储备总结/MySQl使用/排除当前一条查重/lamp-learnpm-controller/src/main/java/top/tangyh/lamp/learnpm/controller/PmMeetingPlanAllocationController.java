package top.tangyh.lamp.learnpm.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.basic.context.ContextUtil;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.service.*;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingPlanAllocationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanAllocationResultVO;
import top.tangyh.lamp.learnpm.vo.save.*;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanAllocationUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingPlanningUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectUpdateVO;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 会议规划分配前端控制器
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/pmMeetingPlanAllocation")
@Api(value = "PmMeetingPlanAllocation", tags = " 会议规划分配")
public class PmMeetingPlanAllocationController extends SuperController<PmMeetingPlanAllocationService, Long, PmMeetingPlanAllocation, PmMeetingPlanAllocationSaveVO, PmMeetingPlanAllocationUpdateVO, PmMeetingPlanAllocationPageQuery, PmMeetingPlanAllocationResultVO> {

    private final EchoService echoService;
    private final PmMeetingPlanAllocationService pmMeetingPlanAllocationService;



    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    /**
     * @author dz
     * @date 2022-06-27
     * @param id 前端传入
     * @return 申请会议结果
     */
    @GetMapping( "/apply")
    public R applyMeeting(@RequestParam("id")Long id){
        R result = pmMeetingPlanAllocationService.meetingApply(id);
        //申请成功的情况
        if (result.getData() instanceof PmProjectMeetingApply){
            return R.success(result.getData(),result.getMsg());
        }
        return R.fail(result.getMsg());
    }




    /**
     * 分配新增，同时回填规划信息
     */
    @ApiOperation(value = "分配新增", notes = "分配新增")
    @PostMapping(value = "/insert")
    public R insert( @RequestBody PmMeetingPlanAllocationSaveVO saveVO){
        try {
            superService.insert(saveVO);
            return  R.success();
        }catch (Exception e){
            e.printStackTrace();
            return R.fail(e);
        }
    }
    /**
     * 分配修改，同时回填规划信息
     */
    @ApiOperation(value = "分配修改", notes = "分配修改")
    @PostMapping(value = "/update")
    public R update(@RequestBody PmMeetingPlanAllocationUpdateVO updateVO){
        try {
            superService.update(updateVO);
            return  R.success();
        }catch (Exception e){
            return R.fail(e);
        }
    }


}
