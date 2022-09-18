package top.tangyh.lamp.learnpm.wemeetcontroller;

import com.alibaba.fastjson.JSON;
import com.tencentcloudapi.wemeet.models.BaseResponse;
import com.tencentcloudapi.wemeet.models.meeting.*;
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
import top.tangyh.lamp.learnpm.wemeetservice.MeetingManagerService;

import java.util.UUID;

/**
 * 腾讯会议管理微信端
 *
 * @Author: 龙色波
 * @Date: 2022/6/30
 */
@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/wechat/wemeet/meetingmanager")
@Api(value = "meeting", tags = "腾讯会议管理")
public class MeetingManagerController {
    @Autowired
    private MeetingManagerService meetingManagerService;

    /**
     * 创建会议
     *
     * @param request 创建会议请求
     * @return 创建会议结果
     */
    @ApiOperation(value = "创建会议请求", notes = "创建会议请求")
    @PostMapping(value = "/createMeeting")
    public R<QueryMeetingDetailResponse> createMeeting(@RequestBody CreateMeetingRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " createMeeting 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " createMeeting 收到请求为空!");
        }
        try {
            QueryMeetingDetailResponse response = meetingManagerService.createMeeting(request);
            log.info(uuid + " createMeeting 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 创建会议失败", e);
            return R.fail("创建会议失败");
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

    /**
     * 通过会议ID查询会议
     *
     * @param request 查询会议请求
     * @return 创建会议结果
     */
    @ApiOperation(value = "通过会议ID查询会议", notes = "通过会议ID查询会议")
    @PostMapping(value = "/queryMeetingById")
    public R<QueryMeetingDetailResponse> queryMeetingById(@RequestBody QueryMeetingByIdRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " queryMeetingById 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " queryMeetingById 收到请求为空!");
        }
        try {
            QueryMeetingDetailResponse response = meetingManagerService.queryMeetingById(request);
            log.info(uuid + " queryMeetingById 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 通过会议ID查询会议失败", e);
            return R.fail("通过会议ID查询会议失败");
        }
    }

    /**
     * 通过会议CODE查询会议
     *
     * @param request 通过会议CODE查询会议请求
     * @return 通过会议CODE查询会议结果
     */
    @ApiOperation(value = "通过会议CODE查询会议请求", notes = "通过会议CODE查询会议请求")
    @PostMapping(value = "/queryMeetingByCode")
    public R<QueryMeetingDetailResponse> queryMeetingByCode(@RequestBody QueryMeetingByCodeRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " queryMeetingByCode 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " queryMeetingByCode 收到请求为空!");
        }
        try {
            QueryMeetingDetailResponse response = meetingManagerService.queryMeetingByCode(request);
            log.info(uuid + " queryMeetingByCode 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 通过会议CODE查询会议失败", e);
            return R.fail("通过会议CODE查询会议失败");
        }
    }


    /**
     * 取消会议
     *
     * @param request 取消会议请求
     * @return 取消会议结果
     */
    @ApiOperation(value = "取消会议请求", notes = "取消会议请求")
    @PostMapping(value = "/cancelMeeting")
    public R<BaseResponse> cancelMeeting(@RequestBody CancelMeetingRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " cancelMeeting 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " cancelMeeting 收到请求为空!");
        }
        try {
            BaseResponse response = meetingManagerService.cancelMeeting(request);
            log.info(uuid + " cancelMeeting 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 取消会议失败", e);
            return R.fail("取消会议失败");
        }
    }

    /**
     * 结束会议
     *
     * @param request 结束会议请求
     * @return 结束会议结果
     */
    @ApiOperation(value = "结束会议请求", notes = "结束会议请求")
    @PostMapping(value = "/dismissMeeting")
    public R<BaseResponse> dismissMeeting(@RequestBody DismissMeetingRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " dismissMeeting 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " dismissMeeting 收到请求为空!");
        }
        try {
            BaseResponse response = meetingManagerService.dismissMeeting(request);
            log.info(uuid + " dismissMeeting 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 结束会议失败", e);
            return R.fail("结束会议失败");
        }
    }


    /**
     * 修改会议
     *
     * @param request 修改会议请求
     * @return 修改会议结果
     */
    @ApiOperation(value = "修改会议请求", notes = "修改会议请求")
    @PostMapping(value = "/modifyMeeting")
    public R<QueryMeetingDetailResponse> modifyMeeting(@RequestBody ModifyMeetingRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " modifyMeeting 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " modifyMeeting 收到请求为空!");
        }
        try {
            QueryMeetingDetailResponse response = meetingManagerService.modifyMeeting(request);
            log.info(uuid + " modifyMeeting 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 修改会议失败", e);
            return R.fail("修改会议失败");
        }
    }


    /**
     * 查询参会成员列表
     *
     * @param request 查询参会成员列表请求
     * @return 查询参会成员列表结果
     */
    @ApiOperation(value = "查询参会成员列表请求", notes = "查询参会成员列表请求")
    @PostMapping(value = "/queryParticipants")
    public R<QueryParticipantsResponse> queryParticipants(@RequestBody QueryParticipantsRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " queryParticipants 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " queryParticipants 收到请求为空!");
        }
        try {
            QueryParticipantsResponse response = meetingManagerService.queryParticipants(request);
            log.info(uuid + " queryParticipants 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 查询参会成员列表失败", e);
            return R.fail("查询参会成员列表失败");
        }
    }


    /**
     * 查询用户的会议列表
     *
     * @param request 查询用户会议列表请求
     * @return 查询用户会议列表结果
     */
    @ApiOperation(value = "查询用户会议列表请求", notes = "查询用户会议列表请求")
    @PostMapping(value = "/queryUserMeetings")
    public R<QueryUserMeetingsResponse> queryUserMeetings(@RequestBody QueryUserMeetingsRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " queryUserMeetings 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " queryUserMeetings 收到请求为空!");
        }
        try {
            QueryUserMeetingsResponse response = meetingManagerService.queryUserMeetings(request);
            log.info(uuid + " queryUserMeetings 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 查询用户会议列表失败", e);
            return R.fail("查询用户会议列表失败");
        }
    }


    /**
     * 查询用户的已结束会议列表
     *
     * @param request 查询用户已结束会议列表
     * @return 结束会议列表
     */
    @ApiOperation(value = "查询用户已结束会议列表", notes = "查询用户已结束会议列表")
    @PostMapping(value = "/queryEndedMeetings")
    public R<QueryEndedMeetingsResponse> queryEndedMeetings(@RequestBody QueryEndedMeetingsRequest request) {
        String uuid = getLogUUID();
        if (request != null) {
            log.info(uuid + " queryEndedMeetings 收到请求:" + JSON.toJSONString(request));
        } else {
            log.info(uuid + " queryEndedMeetings 收到请求为空!");
        }
        try {
            QueryEndedMeetingsResponse response = meetingManagerService.queryEndedMeetings(request);
            log.info(uuid + " queryEndedMeetings 应答:" + JSON.toJSONString(response));
            return R.success(response);
        } catch (Exception e) {
            log.error(uuid + " 查询用户已结束会议列表失败", e);
            return R.fail("查询用户已结束会议列表失败");
        }
    }
}
