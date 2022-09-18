package top.tangyh.lamp.learnpm.wechat;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分配
 */
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
public class Allocation implements Serializable {


    // 负责人id
    private Long defUserId;

    /**
     * 负责人人姓名
     */

    private String PrincipalName;
    /**
     * 负责人手机
     */

    private String PrincipalPhone;
    // 分配
    // 项目规划id
    private Long pmProjectMeetingPlanningId;
    // 地址
    private String address;
    // 要求
    private String require;

    // 分配场次

    private Integer number;
}
