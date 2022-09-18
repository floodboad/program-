package top.tangyh.lamp.learnpm.wemeetservice;

import com.tencentcloudapi.wemeet.common.exception.WemeetSdkException;
import com.tencentcloudapi.wemeet.models.layout.AddLayoutRequest;
import com.tencentcloudapi.wemeet.models.layout.QueryLayoutResponse;

/**
 * 腾讯会议--布局管理接口
 * @author 龙色波
 * @date 2022-07-08
 */
public interface LayoutManagerService {
    /**
     * 增加会议布局
     * @param request 增加布局请求
     * @return
     * @throws WemeetSdkException
     */
    QueryLayoutResponse addLayout(AddLayoutRequest request) throws WemeetSdkException;
}
