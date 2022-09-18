package top.tangyh.lamp.learnpm.wechat;

import lombok.*;

import java.io.Serializable;

/**
 * 修改负责人，执行人
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor

public  class PmMeetingupdateproject implements Serializable {





    private static final long serialVersionUID = 1L;


    /**
     * 会议规划id
     */

    private Long pmProjectMeetingPlanningId;

    //负责人id
    private Long nowPrincipaId;

    /**
     * 现负责人人姓名
     */

    private String nowPrincipalName;
    /**
     * 现负责人手机
     */

    private String nowPrincipalPhone;
    /**
     * 调整原因
     */

    private String adjustReason;
    // 会议规划分配id
    private Long pmMeetingPlanAllocationId;






}