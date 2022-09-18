package top.tangyh.lamp.learnpm.wemeetservice.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencentcloudapi.wemeet.client.WebinarsClient;
import com.tencentcloudapi.wemeet.common.RequestSender;
import com.tencentcloudapi.wemeet.common.constants.WemeetConstants;
import com.tencentcloudapi.wemeet.common.exception.WemeetSdkException;
import com.tencentcloudapi.wemeet.common.profile.HttpProfile;
import com.tencentcloudapi.wemeet.models.BaseResponse;
import com.tencentcloudapi.wemeet.models.background.AddBackgroundRequest;
import com.tencentcloudapi.wemeet.models.background.BackgroundImage;
import com.tencentcloudapi.wemeet.models.background.QueryBackgroundResponse;
import com.tencentcloudapi.wemeet.models.webinars.*;
import com.tencentcloudapi.wemeet.util.MD5Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.utils.DateUtils;
import top.tangyh.lamp.dfhcglock.utils.HttpClientUtil;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.wemeetservice.BackgroundManagerService;
import top.tangyh.lamp.learnpm.wemeetservice.WebinarsManagerService;
import top.tangyh.lamp.wemeet.vo.CreateWebinarsVO;

import java.io.IOException;
import java.util.*;

/**
 * 腾讯会议--网络研讨会实现
 * @author 龙色波
 * @date 2022-07-08
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WebinarsManagerServiceImpl implements WebinarsManagerService {
    /**
     * 初始化全局网络研讨会client
     */
    private WebinarsClient webinarsClient;

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
    @Autowired
    private BackgroundManagerService backgroundManagerService;

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
            webinarsClient = new WebinarsClient(sender);
        }
    }
    @Override
    public CreateWebinarsResponse createWebinars(CreateWebinarsRequest request) throws WemeetSdkException {
        //init();
        if(request.getHeaders()==null){
            Map<String, String> map = new HashMap<>();
            request.setHeaders(map);
        }
        if(request.getParams()==null){
            Map<String, String> map = new HashMap<>();
            request.setParams(map);
        }
        log.info("createWebinars CreateWebinarsRequest:"+JSON.toJSONString(request));
        //将开始和结束时间 转换为时间戳格式
        String startTimeFmt ;
        //如果没有传秒，直接后面带:00
        if(!StringUtils.isEmpty(request.getStartTimeFmt())) {
            startTimeFmt = request.getStartTimeFmt().trim();
            if(startTimeFmt.length()==16) {
                startTimeFmt = startTimeFmt+":00";
            }
            Date startTime = DateUtils.parse(startTimeFmt,DateUtils.DEFAULT_DATE_TIME_FORMAT);
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
        return webinarsClient.createWebinars(request);
    }

    @Override
    public UpdateWebinarsResponse updateWebinars(UpdateWebinarsRequest request) throws WemeetSdkException {
        //将开始和结束时间 转换为时间戳格式
        String startTimeFmt ;
        //如果没有传秒，直接后面带:00
        if(!StringUtils.isEmpty(request.getStartTimeFmt())) {
            startTimeFmt = request.getStartTimeFmt().trim();
            if(startTimeFmt.length()==16) {
                startTimeFmt = startTimeFmt+":00";
            }
            Date startTime = DateUtils.parse(startTimeFmt,DateUtils.DEFAULT_DATE_TIME_FORMAT);
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
        return webinarsClient.updateWebinars(request);
    }

    @Override
    public UpdateWebinarsGuestResponse updateWebinarsGuest(UpdateWebinarsGuestRequest request) throws WemeetSdkException {
        return webinarsClient.updateWebinarsGuest(request);
    }

    @Override
    public UpdateWebinarsEnrollmentSettingResponse updateWebinarsEnrollmentSetting(UpdateWebinarsEnrollmentSettingRequest request) throws WemeetSdkException {
        return webinarsClient.updateWebinarsEnrollmentSetting(request);
    }

    @Override
    public CreateWebinarsResponse createWebinarsPack(CreateWebinarsVO request) throws WemeetSdkException, IOException {
        //初始化profile
        init();
        //1.创建网络研讨会
        CreateWebinarsRequest createWebinarsRequest = new CreateWebinarsRequest();
        BeanUtil.copyProperties(request.getCreateWebinarsRequest(), createWebinarsRequest);
        CreateWebinarsResponse createWebinarsResponse = createWebinars(createWebinarsRequest);
        log.info("createWebinarsResponse :"+ JSON.toJSONString(createWebinarsResponse));
        //3.修改网络研讨会报名设置
        if(WemeetConstants.admission_type_1== createWebinarsRequest.getAdmissionType()) {
            UpdateWebinarsEnrollmentSettingRequest updateWebinarsEnrollmentSettingRequest;
            updateWebinarsEnrollmentSettingRequest = request.getUpdateWebinarsEnrollmentSettingRequest();
            updateWebinarsEnrollmentSettingRequest.setInstanceId(createWebinarsRequest.getInstanceId());
            updateWebinarsEnrollmentSettingRequest.setUserId(createWebinarsRequest.getUserId());
            updateWebinarsEnrollmentSettingRequest.setMeetingId(createWebinarsResponse.getMeetingId());
            //强行设置为不收集
            updateWebinarsEnrollmentSettingRequest.setIsCollectQuestion(WemeetConstants.IS_COLLECT_QUESTION_1);
            //问题列表设置为空
            updateWebinarsEnrollmentSettingRequest.setQuestionList(null);
            //uri设置为空
            updateWebinarsEnrollmentSettingRequest.setUri(null);
            UpdateWebinarsEnrollmentSettingResponse updateWebinarsEnrollmentSettingResponse = updateWebinarsEnrollmentSetting(updateWebinarsEnrollmentSettingRequest);
            log.info("updateWebinarsEnrollmentSettingResponse:" + JSON.toJSONString(updateWebinarsEnrollmentSettingResponse));
        }
        //4.修改网络研讨会嘉宾列表
        UpdateWebinarsGuestRequest updateWebinarsGuestRequest = new UpdateWebinarsGuestRequest();
        updateWebinarsGuestRequest.setGuests(request.getGuests());
        updateWebinarsGuestRequest.setInstanceId(createWebinarsRequest.getInstanceId());
        updateWebinarsGuestRequest.setUserId(createWebinarsRequest.getUserId());
        updateWebinarsGuestRequest.setMeetingId(createWebinarsResponse.getMeetingId());
        updateWebinarsGuestRequest.setUri(null);
        UpdateWebinarsGuestResponse updateWebinarsGuestResponse = this.updateWebinarsGuest(updateWebinarsGuestRequest);
        log.info("updateWebinarsGuestResponse:"+JSON.toJSONString(updateWebinarsGuestResponse));
        //5.添加背景图片,同时设置默认背景
        AddBackgroundRequest addBackgroundRequest = new AddBackgroundRequest();

        addBackgroundRequest.setInstanceId(createWebinarsRequest.getInstanceId());
        addBackgroundRequest.setUserId(createWebinarsRequest.getUserId());
        addBackgroundRequest.setMeetingId(createWebinarsResponse.getMeetingId());
        addBackgroundRequest.setDefaultImageOrder(1);
        List<BackgroundImage> imageList = new ArrayList<>();
        BackgroundImage backgroundImage = new BackgroundImage();
        backgroundImage.setImageUrl(request.getImageUrl());
        backgroundImage.setImageMd5(MD5Util.md5Bytes(HttpClientUtil.downUrl(request.getImageUrl())));
        imageList.add(backgroundImage);
        addBackgroundRequest.setImageList(imageList);
        addBackgroundRequest.setUri(null);
        QueryBackgroundResponse addBackgroundResponse = backgroundManagerService.addBackground(addBackgroundRequest);
        log.info("addBackgroundResponse:"+JSON.toJSONString(addBackgroundResponse));
        return createWebinarsResponse;
    }

    @Override
    public BaseResponse cancelWebinars(CancelWebinarsRequest request) throws WemeetSdkException {
        init();
        log.info("收到取消会议请求:"+JSON.toJSONString(request));
        //meeting_id不能为空
        if(StringUtils.isEmpty(request.getMeetingId())){
            throw new WemeetSdkException("会议id必填!");
        }
        //如果没传userId,则使用默认defautUserId
        if(StringUtils.isEmpty(request.getUserId())){
            request.setUserId(defaultUserId);
        }
        //如果没有传Instanceid,则使用默认defaultInstanceId
        if(request.getInstanceId()==null||request.getInstanceId()==0){
            request.setInstanceId(defaultInstanceId);
        }
        //如果没传取消原因代码，则使用默认审批不通过
        if(request.getReasonCode()==null||request.getReasonCode()==0){
            request.setReasonCode(DSConstant.REASON_CODE_ADUIT_NO_PASS_1);
        }

        return  webinarsClient.cancelWebinars(request);
    }
}
