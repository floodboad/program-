package top.tangyh.lamp.learnpm.wemeetservice.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencentcloudapi.wemeet.client.BackgroundClient;
import com.tencentcloudapi.wemeet.common.RequestSender;
import com.tencentcloudapi.wemeet.common.exception.WemeetSdkException;
import com.tencentcloudapi.wemeet.common.profile.HttpProfile;
import com.tencentcloudapi.wemeet.models.background.AddBackgroundRequest;
import com.tencentcloudapi.wemeet.models.background.BackgroundImage;
import com.tencentcloudapi.wemeet.models.background.QueryBackgroundResponse;
import com.tencentcloudapi.wemeet.util.MD5Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.lamp.dfhcglock.utils.HttpClientUtil;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.wemeetservice.BackgroundManagerService;

import java.io.IOException;

/**
 * 腾讯会议--背景管理实现
 * @author 龙色波
 * @date 2022-07-08
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BackgroundManagerServiceImpl implements BackgroundManagerService {
    /**
     * 背景Client
     */
    private BackgroundClient backgroundClient;
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
            backgroundClient = new BackgroundClient(sender);
        }
    }
    @Override
    public QueryBackgroundResponse addBackground(AddBackgroundRequest request) throws WemeetSdkException, IOException {
        //初始化profile
        init();
        //增加MD5
        for(BackgroundImage backgroundImage:request.getImageList()){
            String md5;
            md5 = MD5Util.md5Bytes(HttpClientUtil.downUrl(backgroundImage.getImageUrl()));
            backgroundImage.setImageMd5(md5);
        }
        return backgroundClient.addMeetingBackground(request);
    }
}
