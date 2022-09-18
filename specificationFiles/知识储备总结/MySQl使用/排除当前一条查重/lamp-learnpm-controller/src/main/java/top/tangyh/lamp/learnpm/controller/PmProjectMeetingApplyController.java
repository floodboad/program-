package top.tangyh.lamp.learnpm.controller;


import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
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
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.PmProject;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanning;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingApplyService;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingPlanningService;
import top.tangyh.lamp.learnpm.service.PmProjectService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingApplyPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingApplyResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectMeetingApplySaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingApplyUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingPlanningUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectUpdateVO;

import java.util.List;

/**
 * <p>
 * 项目会议申请前端控制器
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
@RequestMapping("/pmProjectMeetingApply")
@Api(value = "PmProjectMeetingApply", tags = " 项目会议申请")
public class PmProjectMeetingApplyController extends SuperController<PmProjectMeetingApplyService, Long, PmProjectMeetingApply, PmProjectMeetingApplySaveVO, PmProjectMeetingApplyUpdateVO, PmProjectMeetingApplyPageQuery, PmProjectMeetingApplyResultVO> {

    private final EchoService echoService;
    private final PmProjectMeetingApplyService pmProjectMeetingApplyService;
    private final PmProjectMeetingPlanningService pmProjectMeetingPlanningService;
    private final PmProjectService pmProjectService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    /**
     * 重写删除
     * @param longs id
     * @return
     */
    @Override
    @ApiOperation(value = "删除")
    @DeleteMapping
    @WebLog("'删除:' + #ids")
    public R<Boolean> delete(List<Long> longs) {
        for(Long id:longs){
            PmProjectMeetingApply apply = pmProjectMeetingApplyService.getById(id);
            if (!apply.getMeetingStatus().equals(DSConstant.DICTIONARY_MEETING_STATUS_01)){
                return R.fail("不可删除已经提交了的会议！");
            }
        }
        boolean b = pmProjectMeetingApplyService.removeByIds(longs);
        //更新场次信息，回填申请场次
        pmProjectMeetingApplyService.updateAppliedNum(longs);
        return R.success(b,"作废了"+longs.size()+"条会议申请！");
    }


}
