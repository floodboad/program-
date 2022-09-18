package top.tangyh.lamp.learnpm.pmProjectInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.poi.hpsf.Decimal;

import java.util.List;

@RequiredArgsConstructor
@Data

@ToString(callSuper = true)
@AllArgsConstructor
public class PmProjectmeetingPlanningInfo {


    // 会议规划
    private String pmProjectmeetingPlanningName; // 会议规划名称
    private String  ppmpname; // 规划负责人名称
    private String ppmpRole; // 角色：规划负责人
    private Integer ppmpjihuasession;// 计划场次
    private Integer ppmpyiwansession;//已完成场次
    private  Integer ppmpjinxingsession; // 进行中场次
    private Integer ppmpwerikaisession;// 未开展场次
    private Decimal ppmpGeneralBudget; // 总预算
    private Decimal ppmpExecutedbudget;// 已执行预算
    private Decimal ppmpSettledamount;//已结算金额
    private String explain; // 说明

    List<pmMeetingPlanAllocationInfo> ppaList; // 会议分配

}
