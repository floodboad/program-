package top.tangyh.lamp.learnpm.pmProjectInfo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)



@AllArgsConstructor

// 将项目信息展示
public class PmProjectInfo {



    // 项目信息

    private String pmProjectName; // 项目名称
    private String ppjihuasession; // 计划场次
    private String ppfuzesession;// 负责场次
    private String  ppyiwansession; // 已完成场次
    private Integer ppjinxingseession;// 进行中场次
    private Integer ppweikaisession; // 未开展场次
    private BigDecimal ppGeneralBudhet; // 总预算
    private BigDecimal ppExecutedbudget; // 已执行预算
    private BigDecimal ppSettledamount;// 已结算金额

    List<PmProjectmeetingPlanningInfo> ppmpList; // 会议规划内容




}
