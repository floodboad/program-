package top.tangyh.lamp.learnpm.wemeetservice;

import com.google.gson.reflect.TypeToken;
import com.tencentcloudapi.wemeet.common.exception.WemeetSdkException;
import com.tencentcloudapi.wemeet.models.BaseResponse;
import com.tencentcloudapi.wemeet.models.meeting.*;

/**
 * 腾讯会议--会议管理接口
 * @author 龙色波
 * @date 2022-06-30
 */
 public interface MeetingManagerService {
    /**
     * 创建会议
     */
     QueryMeetingDetailResponse createMeeting(CreateMeetingRequest request) throws WemeetSdkException ;

    /**
     * 通过会议ID查询会议
     */
     QueryMeetingDetailResponse queryMeetingById(QueryMeetingByIdRequest request) throws WemeetSdkException;

    /**
     * 通过会议CODE查询会议
     */
     QueryMeetingDetailResponse queryMeetingByCode(QueryMeetingByCodeRequest request) throws WemeetSdkException;

    /**
     * 取消会议
     */
     BaseResponse cancelMeeting(CancelMeetingRequest request) throws WemeetSdkException;

    /**
     * 结束会议
     */
     BaseResponse dismissMeeting(DismissMeetingRequest request) throws WemeetSdkException ;

    /**
     * 修改会议
     */
     QueryMeetingDetailResponse modifyMeeting(ModifyMeetingRequest request) throws WemeetSdkException ;

    /**
     * 查询参会成员列表
     */
     QueryParticipantsResponse queryParticipants(QueryParticipantsRequest request) throws WemeetSdkException ;

    /**
     * 查询用户的会议列表
     */
    QueryUserMeetingsResponse queryUserMeetings(QueryUserMeetingsRequest request) throws WemeetSdkException ;

    /**
     * 查询用户的已结束会议列表
     */
     QueryEndedMeetingsResponse queryEndedMeetings(QueryEndedMeetingsRequest request) throws WemeetSdkException ;
}
