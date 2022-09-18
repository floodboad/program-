package top.tangyh.lamp.learnpm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.*;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.Entity;

import java.util.Date;

import static com.baomidou.mybatisplus.annotation.SqlCondition.EQUAL;
import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;


/**
 * <p>
 * 审批流实例实体类
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "PM_APPROVAL_PROCESS_INSTANCE",autoResultMap = true)
@AllArgsConstructor
@Builder
public class PmApprovalProcessInstance extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 审批流配置ID 
     */
     @TableField(value = "PM_APPROVAL_PROCESS_CONFIG_ID ", condition = EQUAL)
    private Long pmApprovalProcessConfigId;
    /**
     * 业务类型 
     */
     @TableField(value = "BUSINESS_TYPE ", condition = LIKE)
    private String businessType;
    /**
     * 业务ID 
     */
     @TableField(value = "BUSINESS_ID ", condition = EQUAL)
    private Long businessId;
    /**
     * 待办人 
     */
     @TableField(value = "TO_DO_ID ",typeHandler = FastjsonTypeHandler.class, condition = LIKE)
    private String toDoId;
    /**
     * 流程名称 
     */
     @TableField(value = "PROCESS_NAME ", condition = LIKE)
    private String processName;
    /**
     * 备注 
     */
     @TableField(value = "REMARK ", condition = LIKE)
    private String remark;
    /**
     * 是否结束 
     */
     @TableField(value = "IS_END ", condition = LIKE)
    private String isEnd;
    /**
     * 结束时间 
     */
     @TableField(value = "END_TIME ", condition = LIKE)
    private Date endTime;
    /**
     * 业务信息 
     */
     @TableField(value = "BUSINESS_INFO ", condition = LIKE)
    private String businessInfo;
    /**
     * 标题
     */
     @TableField(value = "ATTRIBUTE1 ", condition = LIKE)
    private String attribute1;
    /**
     * 申请人ID
     */
     @TableField(value = "ATTRIBUTE2 ", condition = EQUAL)
    private String attribute2;
    /**
     * 申请人名称
     */
     @TableField(value = "ATTRIBUTE3 ", condition = LIKE)
    private String attribute3;
    /**
     * 扩展字段4 
     */
     @TableField(value = "ATTRIBUTE4 ", condition = LIKE)
    private String attribute4;
    /**
     * 扩展字段5 
     */
     @TableField(value = "ATTRIBUTE5 ", condition = LIKE)
    private String attribute5;
    /**
     * 扩展字段6 
     */
     @TableField(value = "ATTRIBUTE6 ", condition = LIKE)
    private String attribute6;
    /**
     * 扩展字段7 
     */
     @TableField(value = "ATTRIBUTE7 ", condition = LIKE)
    private String attribute7;
    /**
     * 扩展字段8 
     */
     @TableField(value = "ATTRIBUTE8 ", condition = LIKE)
    private String attribute8;
    /**
     * 扩展字段9 
     */
     @TableField(value = "ATTRIBUTE9 ", condition = LIKE)
    private String attribute9;
    /**
     * 扩展字段10 
     */
     @TableField(value = "ATTRIBUTE10 ", condition = LIKE)
    private String attribute10;

}
