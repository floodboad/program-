package top.tangyh.lamp.learnpm.wemeetcontroller;

import com.alibaba.fastjson.JSON;
import com.tencentcloudapi.wemeet.models.layout.AddLayoutRequest;
import com.tencentcloudapi.wemeet.models.layout.QueryLayoutResponse;
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
import top.tangyh.lamp.learnpm.wemeetservice.LayoutManagerService;

import java.util.UUID;

/**
 * 腾讯会议布局管理
 *
 * @Author: 龙色波
 * @Date: 2022/7/8
 */
@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/wechat/wemeet/layoutmanager")
@Api(value = "meeting", tags = "布局管理")
public class LayoutManagerController {
    @Autowired
    private LayoutManagerService layoutManagerService;
    /**
     * 新增布局
     *
     * @param request 新增布局请求
     * @return 新增布局结果
     */
    @ApiOperation(value = "新增会议布局", notes = "新增会议布局")
    @PostMapping(value = "/addMeetingLayout")
    public R<QueryLayoutResponse> addMeetingLayout(@RequestBody AddLayoutRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " addMeetingLayout 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " addMeetingLayout 收到请求为空!");
        }
        try {
            QueryLayoutResponse response = layoutManagerService.addLayout(request);
            log.info(uuid + " addMeetingLayout 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 新增会议布局", e);
            return R.fail("新增会议布局");
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
