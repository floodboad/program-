package top.tangyh.lamp.learnpm.wemeetservice;

import com.tencentcloudapi.wemeet.common.exception.WemeetSdkException;
import com.tencentcloudapi.wemeet.models.BaseResponse;
import com.tencentcloudapi.wemeet.models.webinars.*;
import top.tangyh.lamp.wemeet.vo.CreateWebinarsVO;

import java.io.IOException;

/**
 * 腾讯会议--网络研讨会接口
 * @author 龙色波
 * @date 2022-07-08
 */
public interface WebinarsManagerService {
    /**
     * 创建网络研讨会
     * @param request
     * @return
     * @throws WemeetSdkException
     */
    CreateWebinarsResponse createWebinars(CreateWebinarsRequest request) throws WemeetSdkException;
    /**
     * 修改网络研讨会
     * @param request
     * @return
     * @throws WemeetSdkException
     */
    UpdateWebinarsResponse updateWebinars(UpdateWebinarsRequest request) throws WemeetSdkException;
    /**
     * 修改网络研讨会嘉宾列表
     */
    UpdateWebinarsGuestResponse updateWebinarsGuest(UpdateWebinarsGuestRequest request) throws WemeetSdkException;
    /**
     * 修改网络研讨会报名设置
     */
    UpdateWebinarsEnrollmentSettingResponse updateWebinarsEnrollmentSetting(UpdateWebinarsEnrollmentSettingRequest request) throws  WemeetSdkException;
    /**
     * 创建网络研讨会打包版（内部含创建网络研讨会，修改网络研讨会等)
     * @param request
     * @return
     */
    CreateWebinarsResponse createWebinarsPack(CreateWebinarsVO request) throws WemeetSdkException, IOException;

    /**
     * 取消网络研讨会
     * @param request
     * @return
     * @throws WemeetSdkException
     */
    BaseResponse cancelWebinars(CancelWebinarsRequest request) throws WemeetSdkException;
}
