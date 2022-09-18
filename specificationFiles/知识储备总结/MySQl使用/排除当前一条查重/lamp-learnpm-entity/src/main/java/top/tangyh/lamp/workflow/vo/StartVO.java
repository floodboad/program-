package top.tangyh.lamp.workflow.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * 启动流程vo
 *
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StartVO {
    /**
     * 标题
     */
    private String title;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 业务ID
     */
    private Long businessId;
    /**
     * 待办人列表，JSON格式
     */
    private String toDoId;
    /**
     * 流程名称
     */
    private String processName;
    /**
     * 业务信息
     */
    private String businessInfo;
    /**
     * 申请人id
     */
    private Long applicantId;
    /**
     * 申请人姓名
     */
    private String applicantName;
}
