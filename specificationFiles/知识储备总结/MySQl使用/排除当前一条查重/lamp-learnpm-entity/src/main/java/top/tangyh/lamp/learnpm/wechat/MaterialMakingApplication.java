package top.tangyh.lamp.learnpm.wechat;

import lombok.*;

/**
 * 物料制作申请
 */

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor
public class MaterialMakingApplication {

// 会议申请id
    private Long PmPRojectMeetingApplyID;
    // 发起人电话
    private String phone;

    // 地址
    private String adress;
   // 制作要求
    private String materalrequer;

    // 会议材料
    private  String meetingMateral;

     // 费用id
    private Long  msBudgeSubjectId;

}
