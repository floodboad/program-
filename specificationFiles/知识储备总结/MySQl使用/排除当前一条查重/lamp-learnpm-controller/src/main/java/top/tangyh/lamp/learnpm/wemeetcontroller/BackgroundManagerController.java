package top.tangyh.lamp.learnpm.wemeetcontroller;

import com.alibaba.fastjson.JSON;
import com.tencentcloudapi.wemeet.models.background.AddBackgroundRequest;
import com.tencentcloudapi.wemeet.models.background.QueryBackgroundResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tangyh.basic.base.R;
import top.tangyh.lamp.learnpm.wemeetservice.BackgroundManagerService;

import java.util.UUID;

/**
 * 腾讯会议背景管理
 *
 * @Author: 龙色波
 * @Date: 2022/7/8
 */
@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/wechat/wemeet/backgroundmanager")
@Api(value = "meeting", tags = "背景管理")
public class BackgroundManagerController {
    @Autowired
    private BackgroundManagerService backgroundManagerService;
    /**
     * 新增会议背景
     *
     * @param request 新增会议背景请求
     * @return 新增会议背景结果
     */
    @ApiOperation(value = "新增会议背景", notes = "新增会议背景")
    @PostMapping(value = "/addMeetingBackground")
    public R<QueryBackgroundResponse> addMeetingBackground(@RequestBody AddBackgroundRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " addMeetingBackground 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " addMeetingBackground 收到请求为空!");
        }
        try {
            QueryBackgroundResponse response = backgroundManagerService.addBackground(request);
            log.info(uuid + " addMeetingBackground 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 新增会议背景失败", e);
            return R.fail("新增会议背景失败");
        }
    }

    /**
     * 构造日志uuid
     *
     * @return
     */
    private String getLogUUID() {
        return UUID.randomUUID().toString();
    }
}
