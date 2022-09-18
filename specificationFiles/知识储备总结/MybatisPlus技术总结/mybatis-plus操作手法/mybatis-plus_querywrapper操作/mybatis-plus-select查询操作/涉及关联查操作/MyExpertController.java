package top.tangyh.lamp.learnpm.wechatcontroller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.learnpm.entity.PmConferenceExpertServices;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.service.MsExpertInfoService;
import top.tangyh.lamp.learnpm.service.PmConferenceExpertServicesService;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingApplyService;
import top.tangyh.lamp.learnpm.vo.result.PmConferenceExpertServicesResultVO;
import top.tangyh.lamp.learnpm.wechat.WO;
import top.tangyh.lamp.learnpm.wechat.WPage;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/wechat/myExpertService")
@Api(value = "myExpertService", tags = "我的专家劳务")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class MyExpertController {

    @Autowired
    private PmConferenceExpertServicesService expertServicesService;  //专家劳务

    @Autowired
    private MsExpertInfoService expertInfoService;  //专家

    @Autowired
    private PmProjectMeetingApplyService meetingApplyService;

    @Autowired
    private EchoService echoService;

    /**
     * 我的专家劳务列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    public R myExpertServiceList(HttpServletRequest request,@RequestBody WPage wPage) {
        IPage<PmConferenceExpertServices> page = wPage.getPageParams().buildPage();
        HashMap map = new HashMap<>();

        Long userId = WO.getUserId(request);

        //通过userId获取专家Id
        Long id = expertInfoService.getByUserId(userId);

        LbQueryWrap<PmConferenceExpertServices> wrap = Wraps.<PmConferenceExpertServices>lbQ()
                .eq(PmConferenceExpertServices::getMsExpertInfoId, id);

        expertServicesService.page(page, wrap);
        IPage<PmConferenceExpertServices> voPage = BeanPlusUtil.toBeanPage(page, PmConferenceExpertServices.class);
        echoService.action(voPage);

        map.put("expertServices", voPage);
        List<PmConferenceExpertServices> servicesList = voPage.getRecords();

        for (PmConferenceExpertServices expertServices : servicesList) {
            PmProjectMeetingApply apply = meetingApplyService.getByMeetingApplyId(expertServices.getPmProjectMeetingApplyId());
            //map.put("status", expertServices.getStatus());
            //map.put("amountMoney", expertServices.getAmountMoney());
            //map.put("projectName", expertServices.getProjectName());

            map.put("startTime", apply.getSupportProjectPlanStartTime());
            map.put("endTime", apply.getSupportProjectPlanEndTime());
            map.put("meetingMode", apply.getMeetingMode());
            map.put("detailAddress", apply.getMeetingDetailAddress());
            map.put("meetingTypeName", apply.getMeetingTypeName());
        }






        //通过专家Id获取会议专家劳务列表
        //List<PmConferenceExpertServices> list = expertServicesService.list(Wraps.<PmConferenceExpertServices>lbQ()
        //        .eq(PmConferenceExpertServices::getMsExpertInfoId, id));
        //
        //ArrayList<Long> meetingApplyIds = new ArrayList<>();
        //for (PmConferenceExpertServices expertServices : list) {
        //    //通过会议申请Id获取会议申请信息
        //    PmProjectMeetingApply meetingApply = meetingApplyService.getByMeetingApplyId(expertServices.getPmProjectMeetingApplyId());
        //    map.put("", "");
        //
        //
        //
        //    //meetingApplyIds.add(expertServices.getPmProjectMeetingApplyId());
        //}
        //List<PmProjectMeetingApply> listApply = meetingApplyService.list(Wraps.<PmProjectMeetingApply>lbQ()
        //        .in(PmProjectMeetingApply::getId, meetingApplyIds));

        //LbQueryWrap<PmProjectMeetingApply> wrap = Wraps.<PmProjectMeetingApply>lbQ().in(PmProjectMeetingApply::getId, meetingApplyIds);


        return R.success(map);
    }
}
