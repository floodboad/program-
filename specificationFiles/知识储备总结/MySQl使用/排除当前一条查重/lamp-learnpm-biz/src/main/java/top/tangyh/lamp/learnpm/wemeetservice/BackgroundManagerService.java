package top.tangyh.lamp.learnpm.wemeetservice;

import com.tencentcloudapi.wemeet.common.exception.WemeetSdkException;
import com.tencentcloudapi.wemeet.models.background.AddBackgroundRequest;
import com.tencentcloudapi.wemeet.models.background.QueryBackgroundResponse;

import java.io.IOException;

/**
 * 腾讯会议--背景管理接口
 * @author 龙色波
 * @date 2022-07-08
 */
public interface BackgroundManagerService {
    /**
     * 增加会议背景
     * @param request
     * @return
     * @throws WemeetSdkException
     */
    QueryBackgroundResponse addBackground(AddBackgroundRequest request) throws WemeetSdkException, IOException;
}
