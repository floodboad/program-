package top.tangyh.lamp.learnpm.pmProjectInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.tangyh.lamp.learnpm.entity.MsExpertInfo;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;

/**
 * 项目会议申请
 */

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor
public class PmProjectMeetingApplyInfo {
    // 项目会议申请
    private PmProjectMeetingApply pmProjectMeetingApply;
    private MsExpertInfo msExpertInfo;
}
