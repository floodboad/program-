package top.tangyh.lamp.learnpm.pmProjectInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.poi.hpsf.Decimal;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanAllocation;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor

public class pmMeetingPlanAllocationInfo {

    // 会议分配
    private String pmMeetingPlanAllocationName; // 会议规划名称
    private String  pmpaname; // 规划负责人名称
    private String pmpaRole; // 角色：执行负责人
    private Integer pmpajihuasession;// 计划场次
    private Integer pmpayiwansession;//已完成场次
    private  Integer pmpajinxingsession; // 进行中场次
    private Integer pmpawerikaisession;// 未开展场次
    private Decimal pmpaGeneralBudget; // 总预算
    private Decimal pmpaExecutedbudget;// 已执行预算
    private Decimal pmpaSettledamount;//已结算金额
    private String pmpaexplain; // 说明
    List<PmProjectMeetingApplyInfo> ppmaList;   // 项目申请


}
