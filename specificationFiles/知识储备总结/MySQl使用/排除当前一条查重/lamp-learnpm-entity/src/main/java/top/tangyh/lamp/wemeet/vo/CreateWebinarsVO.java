package top.tangyh.lamp.wemeet.vo;

import com.tencentcloudapi.wemeet.models.webinars.Guest;
import com.tencentcloudapi.wemeet.models.webinars.CreateWebinarsRequest;

import com.tencentcloudapi.wemeet.models.webinars.UpdateWebinarsEnrollmentSettingRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 网络研讨会vo
 *
 **/
@Data
@NoArgsConstructor
public class CreateWebinarsVO {
    /**
     * 网络研讨会主要信息
     */
    private CreateWebinarsRequest createWebinarsRequest;
    /**
     * 背景图片 URL
     */
    private String imageUrl;
    /**
     * 报名设置
     */
    private UpdateWebinarsEnrollmentSettingRequest updateWebinarsEnrollmentSettingRequest;
    /**
     * 嘉宾列表
     */
    /**
     * 嘉宾列表
     */
    private List<Guest> guests;
}
