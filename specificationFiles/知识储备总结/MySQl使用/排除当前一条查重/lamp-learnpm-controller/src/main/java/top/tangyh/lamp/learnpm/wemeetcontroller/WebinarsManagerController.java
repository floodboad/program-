package top.tangyh.lamp.learnpm.wemeetcontroller;

import com.alibaba.fastjson.JSON;
import com.tencentcloudapi.wemeet.models.BaseResponse;
import com.tencentcloudapi.wemeet.models.webinars.CancelWebinarsRequest;
import com.tencentcloudapi.wemeet.models.webinars.CreateWebinarsRequest;
import com.tencentcloudapi.wemeet.models.webinars.CreateWebinarsResponse;
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
import top.tangyh.lamp.learnpm.wemeetservice.WebinarsManagerService;
import top.tangyh.lamp.wemeet.vo.CreateWebinarsVO;

import java.util.UUID;

/**
 * 腾讯网络研讨会管理
 *
 * @Author: 龙色波
 * @Date: 2022/7/8
 */
@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/wechat/wemeet/webinarsmanager")
@Api(value = "meeting", tags = "腾讯网络研讨会管理")
public class WebinarsManagerController {
    @Autowired
    private WebinarsManagerService webinarsManagerService;
    /**
     * 创建网络研讨会
     *
     * @param request 创建请求
     * @return 创建结果
     */
    @ApiOperation(value = "创建网络研讨会", notes = "创建网络研讨会")
    @PostMapping(value = "/createWebinars")
    public R<CreateWebinarsResponse> createWebinars(@RequestBody CreateWebinarsVO request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " createWebinars 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " createWebinars 收到请求为空!");
        }
        try {
            CreateWebinarsResponse response = webinarsManagerService.createWebinarsPack(request);
//            CreateWebinarsResponse response = webinarsManagerService.createWebinars(request);
            log.info(uuid + " createWebinars 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 创建网络研讨会失败", e);
            return R.fail("创建网络研讨会失败");
        }
    }
    /**
     * 创建网络研讨会(外部接口)
     *
     * @param request 创建请求
     * @return 创建结果
     */
    @ApiOperation(value = "创建网络研讨会(外部接口)", notes = "创建网络研讨会")
    @PostMapping(value = "/createWebinarsExternal")
    public R<CreateWebinarsResponse> createWebinarsExternal(@RequestBody CreateWebinarsRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " createWebinars 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " createWebinars 收到请求为空!");
        }
        try {
            CreateWebinarsResponse response = webinarsManagerService.createWebinars(request);
            log.info(uuid + " createWebinars 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 创建网络研讨会失败", e);
            return R.fail("创建网络研讨会失败");
        }
    }
    /**
     * 取消网络研讨会
     *
     * @param request 取消请求
     * @return 取消结果
     */
    @ApiOperation(value = "取消网络研讨会", notes = "取消网络研讨会")
    @PostMapping(value = "/cancelWebinars")
    public R<BaseResponse> cancelWebinars(@RequestBody CancelWebinarsRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " cancelWebinars 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " cancelWebinars 收到请求为空!");
        }
        try {
            BaseResponse response = webinarsManagerService.cancelWebinars(request);
            log.info(uuid + " cancelWebinars 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 取消网络研讨会失败", e);
            return R.fail("取消网络研讨会失败");
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
