package top.tangyh.lamp.learnpm.wechatcontroller;/**
 * @author xuchunlong
 * @create 2022-06-21-12:18
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.lamp.learnpm.wechat.WO;
import top.tangyh.lamp.learnpm.wechatsevice.MessageAmountService;
import top.tangyh.lamp.msg.entity.MsgReceive;
import top.tangyh.lamp.msg.service.MsgReceiveService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: xucl
 * @create: 2022/6/21
 * @Description: 消息数量
 * @FileName: MessageAmountController
 * @History:
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/wechat/MessageAmount")
@Api(value = "MessageAmount", tags = "消息数量")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class MessageAmountController {

    @Autowired
    private MsgReceiveService msgReceiveService;
    /**
     * 我的消息数量
     * @param request
     * @return
     */
    @ApiOperation(value = "我的消息数量", notes = "我的消息数量")
    @PostMapping(value = "/MessageAmountMine")
    @RequestMapping(value = "MessageAmountMine",method = RequestMethod.POST, produces = "application/json")
    public R MessageAmountMine(HttpServletRequest request) {

        // 调用通过id获取消息的数量
        Long userId = WO.getUserId(request);
        int messageAmount = msgReceiveService.getAmountByUserId(userId);
        return R.success(messageAmount);
    }
}