package top.tangyh.lamp.learnpm.wechatcontroller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.annotation.log.WebLog;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.request.PageParams;
import top.tangyh.basic.context.ContextUtil;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanAllocation;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanAllocationResultVO;
import top.tangyh.lamp.learnpm.wechat.WO;
import top.tangyh.lamp.learnpm.wechat.WPage;
import top.tangyh.lamp.msg.entity.Msg;
import top.tangyh.lamp.msg.entity.MsgReceive;
import top.tangyh.lamp.msg.service.MsgReceiveService;
import top.tangyh.lamp.msg.service.MsgService;
import top.tangyh.lamp.msg.vo.query.MsgPageQuery;
import top.tangyh.lamp.msg.vo.result.MsgReceiveResultVO;
import top.tangyh.lamp.msg.vo.result.MsgResultVO;
import top.tangyh.lamp.system.entity.tenant.DefTenant;
import top.tangyh.lamp.system.vo.query.tenant.DefTenantPageQuery;
import top.tangyh.lamp.system.vo.result.tenant.DefTenantResultVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Cleverguyyy
 * @date 2022年06月23日 16:16
 */

@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/wechat/myMessage")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
@Api(value = "mymsg", tags = "我的消息")
public class MyMessageController {

    private static final String ILLEGAL_ARGUMENT = "参数异常！请填写正确的userId对应的msgId。";

    @Autowired
    private MsgService msgService;

    /**
     * 我的消息列表
     * @param request
     * @param current
     * @param size
     * @return
     */
    @ApiOperation(value = "我的消息列表", notes = "我的消息列表")
    @GetMapping(value = "/myMsgList")
    public R myMsgList(HttpServletRequest request, Long current, Long size) {
        String userId = request.getHeader("userId");
        Long aLong = Long.valueOf(userId);
        List<Msg> msgList = msgService.getMyMsgList(aLong,current,size);
        if (msgList == null) {
            return R.success("您的消息列表为空");
        }
        return R.success(msgList);
    }

    /**
     * 我的消息详情
     * @param request
     * @param msgId
     * @return
     */
    @ApiOperation(value = "我的消息详情", notes = "我的消息详情")
    @GetMapping(value = "/myMsgDetail")
    public R myMsgDetail(HttpServletRequest request,Long msgId) {
        Long userId = Long.valueOf(request.getHeader("userId"));
        Msg msgDetail = msgService.getMyMsgDetail(userId,msgId);
        if (msgDetail == null) {
            return R.fail(ILLEGAL_ARGUMENT);
        }

        return R.success(msgDetail);
    }

    /**
     * 修改为已读
     * @param request
     * @param msgId
     * @return
     */
    @ApiOperation(value = "修改为已读", notes = "修改为已读")
    @GetMapping(value = "/updateRead")
    public R updateRead(HttpServletRequest request,Long msgId) {
        Long userId = Long.valueOf(request.getHeader("userId"));
        Boolean result = msgService.updateRead(userId,msgId);
        if (!result) {
            return R.fail(ILLEGAL_ARGUMENT);
        }

        return R.success(result);
    }
}
