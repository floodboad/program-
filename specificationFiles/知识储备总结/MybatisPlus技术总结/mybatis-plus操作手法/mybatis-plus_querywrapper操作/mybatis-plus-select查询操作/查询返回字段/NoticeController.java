package top.tangyh.lamp.learnpm.wechatcontroller;/**
 * @author xuchunlong
 * @create 2022-06-21-12:04
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.request.PageParams;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.database.mybatis.conditions.query.QueryWrap;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.basic.jwt.model.Token;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.com.fasc.open.api.bean.req.user.GetUserIdentityInfoReq;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.PmConferenceExpertServices;
import top.tangyh.lamp.learnpm.wechat.WO;
import top.tangyh.lamp.learnpm.wechat.WPage;
import top.tangyh.lamp.learnpm.wechatsevice.NoticeService;
import top.tangyh.lamp.msg.entity.Msg;
import top.tangyh.lamp.msg.entity.MsgReceive;
import top.tangyh.lamp.msg.service.MsgReceiveService;
import top.tangyh.lamp.msg.service.MsgService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xucl
 * @create: 2022/6/21
 * @Description: 通知公告
 * @FileName: NoticeController
 * @History:
 */

@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/wechat/notice")
@Api(value = "notice", tags = "通知公告")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class NoticeController {

    @Autowired
    private MsgService msgService;

    @Autowired
    private MsgReceiveService msgReceiveService;
    private EchoService echoService;

    @Autowired
    private NoticeService noticeService;


    /**
     * 通知公告列表
     * @param request
     * @return
     */
    @ApiOperation(value = "通知公告列表", notes = "通知公告列表")
    @PostMapping(value = "/noticeList")
    @RequestMapping(value = "noticeList",method = RequestMethod.POST, produces = "application/json")
    public R noticeList(@RequestBody WO wo,HttpServletRequest request){
        // MsgReceive表的userid查询所有的Msg表的MsgType为通知公告的记录并返回
        Long userId = 1l;
        String userId1 = request.getHeader("userId");
        String token = request.getHeader("Token");
        System.out.println(userId1);
        System.out.println(token);
        WO.getUserId(request);
        System.out.println("==============================="+WO.getUserId(request)+userId);
        userId = WO.getUserId(request);
        System.out.println("======================="+userId);
        ArrayList<Msg> list = msgService.listNotifyAndPublictyMessage(userId);
        //ArrayList<Msg> list = noticeService.listNotifyAndPublictyMessage(userId);
        return R.success(list);
    }

    /**
     * 通知公告分页列表
     * @param wPage
     * @param request
     * @description 分页：currentPage,pageSize;返回一个分页列表。
     * @return
     */
    @ApiOperation(value = "通知公告分页列表", notes = "通知公告分页列表")
    @PostMapping(value = "/noticePageList")
    @RequestMapping(value = "noticePageList",method = RequestMethod.POST, produces = "application/json")
    public R noticePageList(@RequestBody WPage wPage,HttpServletRequest request) {
        // 翻页查询,方法的入参对象userid
        IPage<Msg> page = wPage.getPageParams().buildPage();
        HashMap map = new HashMap<>();
        Long userId = WO.getUserId(request);
        // 通过userId获取专家msgId
        QueryWrap<MsgReceive> queryWrap = new QueryWrap<>();
        queryWrap.eq("user_id",userId);
        List<MsgReceive> list = msgReceiveService.list(queryWrap);
        // 获取当前用户所有msgid
        List<Long> msgIds = list.stream().mapToLong(MsgReceive::getMsgId).boxed().collect(Collectors.toList());
        LbQueryWrap<Msg> wrap = Wraps.<Msg>lbQ()
                .in(Msg::getId,msgIds);
        msgService.page(page, wrap);
        IPage<Msg> voPage = BeanPlusUtil.toBeanPage(page, Msg.class);
        // echoService.action(voPage);
        return R.success(voPage);
    }

    /**
     * 通知公告详情
     * @param wo
     * @param request
     * @return
     */
    @ApiOperation(value = "通知公告详情", notes = "通知公告详情")
    @PostMapping(value = "/noticeDetails")
    @RequestMapping(value = "noticeDetails",method = RequestMethod.POST, produces = "application/json")
    public R noticeDetails(@RequestBody WO wo ,HttpServletRequest request){

        // 在查询的通知公告列表打开公告的具体详情
        Long userId = WO.getUserId(request);
        Long msgId = wo.getDataId();
        // 输入几个筛选的参数：title，date等
        ArrayList<String> goalList = msgService.noticeDetailes(userId,msgId);
        return R.success(goalList);
    }

    /**
     * 通知公告未读数量
     * @param request,wo
     * @return
     */
    @ApiOperation(value = "通知公告未读数量", notes = "通知公告未读数量")
    @PostMapping(value = "/noticeUnreadNums")
    @RequestMapping(value = "noticeUnreadNums",method = RequestMethod.POST, produces = "application/json")
    public R noticeUnreadNums(HttpServletRequest request){
       // 只需要在公告列表中查询到消息“是否已读”属性为false
        Long userId = WO.getUserId(request);
        Integer unreadAmount = msgService.unreadAmount(false,userId);
        return R.success(unreadAmount);
    }

    /**
     * 通知公告已读数量
     * @param request,wo
     * @return
     */
    @ApiOperation(value = "通知公告已读数量", notes = "通知公告已读数量")
    @PostMapping(value = "/noticeReadedNums")
    @RequestMapping(value = "noticeReadedNums",method = RequestMethod.POST, produces = "application/json")
    public R noticeReadedNums(HttpServletRequest request){
        // 只需要在公告列表中查询到消息“是否已读”属性为true
        Long userId = WO.getUserId(request);
        System.out.println("==========================================="+userId);
        Integer readAmount = msgService.readAmount(true,userId);
        return R.success(readAmount);
    }
}