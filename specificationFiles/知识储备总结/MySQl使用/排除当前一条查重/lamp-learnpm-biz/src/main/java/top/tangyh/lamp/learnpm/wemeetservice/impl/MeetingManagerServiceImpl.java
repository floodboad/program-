package top.tangyh.lamp.learnpm.wemeetservice.impl;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencentcloudapi.wemeet.client.MeetingClient;
import com.tencentcloudapi.wemeet.client.UserClient;
import com.tencentcloudapi.wemeet.common.RequestSender;
import com.tencentcloudapi.wemeet.common.exception.WemeetSdkException;
import com.tencentcloudapi.wemeet.common.profile.HttpProfile;
import com.tencentcloudapi.wemeet.models.BaseResponse;
import com.tencentcloudapi.wemeet.models.meeting.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.utils.DateUtils;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.wemeetservice.MeetingManagerService;

import java.util.Date;

/**
 * 腾讯会议--会议管理实现
 * @author 龙色波
 * @date 2022-06-30
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MeetingManagerServiceImpl implements MeetingManagerService {
    /**
     * 初始化全局会议client
     */
    private   MeetingClient meetingClient;
    /**
     * 初始化全局用户client
     */
    private   UserClient userClient;
    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    private HttpProfile profile;
    /**
     * 应用ID
     */
    @Value(value = "${lamp.wemeet.appid}")
    private String appId;
    /**
     * SDK ID
     */
    @Value(value = "${lamp.wemeet.sdkid}")
    private String sdkId;
    /**
     * 请求域名  固定为 https://api.meeting.qq.com
     */
    @Value(value="${lamp.wemeet.host}")
    private String host;
    /**
     * 申请的安全凭证密钥对中的 SecretId
     */
    @Value(value="${lamp.wemeet.secretid}")
    private String secretId;
    /**
     * 申请的安全凭证密钥对中的 SecretKey
     */
    @Value(value="${lamp.wemeet.secretkey}")
    private String secretKey;
    /**
     * 是否开启请求日志，开启后会打印请求和返回的详细日志 Debug 1--表示开启 0--不开启
     */
    @Value(value="${lamp.wemeet.debug}")
    private String debug;
    /**
     * 设置请求超时时间,单位为秒 推荐为3s
     */
    @Value(value="${lamp.wemeet.readtimeout}")
    private int readTimeout;
    /**
     * 设置连接超时时间,单位为秒  推荐为1s
     */
    @Value(value="${lamp.wemeet.conntimeout}")
    private int connTimeout;
    /**
     * 缺省的userId 创建会议缺省id，如果没传，则默认填这个
     */
    @Value(value="${lamp.wemeet.defaultUserId}")
    private String defaultUserId;
    /**
     * 缺省的用户的终端设备类型 默认为1---pc
     */
    @Value(value="${lamp.wemeet.defaultInstanceId}")
    private int defaultInstanceId;



    /**
     * 初始化
     */
    private void init() {
        if(profile==null) {
            profile = new HttpProfile();
            // 腾讯会议分配给三方开发应用的 App ID。企业管理员可以登录 腾讯会议官网，单击右上角【用户中心】
            // 在左侧菜单栏中的【企业管理】>【高级】>【restApi】中进行查看。
            profile.setAppId(appId);
            // 用户子账号或开发的应用 ID，企业管理员可以登录 腾讯会议官网，单击右上角【用户中心】
            // 在左侧菜单栏中的【企业管理】>【高级】>【restApi】中进行查看（如存在 SdkId 则必须填写，早期申请 API 且未分配 SdkId 的客户可不填写）。
            profile.setSdkId(sdkId);
            // 请求域名
            profile.setHost(host);
            // 申请的安全凭证密钥对中的 SecretId，传入请求header，对应X-TC-Key
            profile.setSecretId(secretId);
            // 申请的安全凭证密钥对中的 Secretkey，用户签名计算
            profile.setSecretKey(secretKey);
            // 是否开启请求日志，开启后会打印请求和返回的详细日志
            profile.setDebug(DSConstant.DICTIONARY_RM_YES_NOT_1.equals(debug));
            // 设置请求超时时间，单位s
            profile.setReadTimeout(readTimeout);
            // 设置获取连接超时时间，单位s
            profile.setConnTimeout(connTimeout);

            // 初始化全局sender，也可以方法级别实例化
            RequestSender sender = new RequestSender(profile);
            // 自定义拦截器，可以忽略
//        sender.addInterceptors(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) {
//                // TODO return null; 用户自定义实现
//
//            }
//        });
            // 实例化client
            meetingClient = new MeetingClient(sender);
            userClient = new UserClient(sender);
        }
    }

    /**
     * 创建会议
     */
    @Override
    public QueryMeetingDetailResponse createMeeting(CreateMeetingRequest request) throws WemeetSdkException {
        //log.info("appId:"+appId);
        //初始化
        init();
        log.info("request json:"+ JSON.toJSONString(request));
        //将开始和结束时间 转换为时间戳格式
        String startTimeFmt ;
        //如果没有传秒，直接后面带:00
        if(!StringUtils.isEmpty(request.getStartTimeFmt())) {
            startTimeFmt = request.getStartTimeFmt().trim();
            if(startTimeFmt.length()==16) {
              startTimeFmt = startTimeFmt+":00";
            }
            Date startTime =DateUtils.parse(startTimeFmt,DateUtils.DEFAULT_DATE_TIME_FORMAT);
            request.setStartTime(String.valueOf(startTime.getTime()/1000));
        }
        //结束时间
        String endTimeFmt ;
        //如果没有传秒，直接后面带:00
        if(!StringUtils.isEmpty(request.getEndTimeFmt())) {
            endTimeFmt = request.getEndTimeFmt().trim();
            if(endTimeFmt.length()==16) {
                endTimeFmt = endTimeFmt+":00";
            }
            Date endTime =DateUtils.parse(endTimeFmt,DateUtils.DEFAULT_DATE_TIME_FORMAT);
            request.setEndTime(String.valueOf(endTime.getTime()/1000));
        }
        //如果没传userId,则使用默认defautUserId
        if(StringUtils.isEmpty(request.getUserId())){
            request.setUserId(defaultUserId);
        }
        //如果没有传Instanceid,则使用默认defaultInstanceId
        if(request.getInstanceId()==null||request.getInstanceId()==0){
            request.setInstanceId(defaultInstanceId);
        }
        return meetingClient.createMeeting(request);
    }
    /**
     * 通过会议ID查询会议
     */
    @Override
    public QueryMeetingDetailResponse queryMeetingById(QueryMeetingByIdRequest request) throws WemeetSdkException {
        //初始化
        init();
        return meetingClient.queryMeetingById(request);
    }
    /**
     * 通过会议CODE查询会议
     */
    @Override
    public QueryMeetingDetailResponse queryMeetingByCode(QueryMeetingByCodeRequest request) throws WemeetSdkException {
        //初始化
        init();
        return meetingClient.queryMeetingByCode(request);
    }
    /**
     * 取消会议
     */
    @Override
    public BaseResponse cancelMeeting(CancelMeetingRequest request) throws WemeetSdkException {
        //初始化
        init();
        return meetingClient.cancelMeeting(request);
    }
    /**
     * 结束会议
     */
    @Override
    public BaseResponse dismissMeeting(DismissMeetingRequest request) throws WemeetSdkException {
        //初始化
        init();
        return meetingClient.dismissMeeting(request);
    }
    /**
     * 修改会议
     */
    @Override
    public QueryMeetingDetailResponse modifyMeeting(ModifyMeetingRequest request) throws WemeetSdkException {
        //初始化
        init();
        return meetingClient.modifyMeeting(request);
    }
    /**
     * 查询参会成员列表
     */
    @Override
    public QueryParticipantsResponse queryParticipants(QueryParticipantsRequest request) throws WemeetSdkException {
        //初始化
        init();
        return meetingClient.queryParticipants(request);
    }
    /**
     * 查询用户的会议列表
     */
    @Override
    public QueryUserMeetingsResponse queryUserMeetings(QueryUserMeetingsRequest request) throws WemeetSdkException {
        //初始化
        init();
        return meetingClient.queryUserMeetings(request);
    }
    /**
     * 查询用户的已结束会议列表
     */
    @Override
    public QueryEndedMeetingsResponse queryEndedMeetings(QueryEndedMeetingsRequest request) throws WemeetSdkException {
        //初始化
        init();
        return meetingClient.queryEndedMeetings(request);
    }
}
