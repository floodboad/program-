package top.tangyh.lamp.learnpm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.Entity;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;
import java.util.Date;


/**
 * <p>
 * 基础表更新操作记录实体类
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("MS_UPDATE_OPERATION_RECORD")
@AllArgsConstructor
@Builder
public class MsUpdateOperationRecord extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 操作人员id 
     */
     @TableField(value = "OPERATOR_ID ", condition = LIKE)
    private Long operatorId;
    /**
     * 操作人员姓名 
     */
     @TableField(value = "OPERATOR_NAME ", condition = LIKE)
    private String operatorName;
    /**
     * 操作类型 
     */
     @TableField(value = "OPERATOR_TYPE ", condition = LIKE)
    private String operatorType;
    /**
     * 更新表名称 
     */
     @TableField(value = "UPDATE_TABLE_NAME ", condition = LIKE)
    private String updateTableName;
    /**
     * 更新表id 
     */
     @TableField(value = "UPDATE_TABLE_ID ", condition = LIKE)
    private Long updateTableId;
    /**
     * 操作描述 
     */
     @TableField(value = "OPERATOR_DESC ", condition = LIKE)
    private String operatorDesc;
    /**
     * 操作时间 
     */
     @TableField(value = "OPERATOR_TIME ", condition = LIKE)
    private Date operatorTime;
    /**
     * ip地址 
     */
     @TableField(value = "IP ", condition = LIKE)
    private String ip;
    /**
     * 所在单位 
     */
     @TableField(value = "UNIT ", condition = LIKE)
    private String unit;
    /**
     * 扩展字段1 
     */
     @TableField(value = "ATTRIBUTE1 ", condition = LIKE)
    private String attribute1;
    /**
     * 扩展字段2 
     */
     @TableField(value = "ATTRIBUTE2 ", condition = LIKE)
    private String attribute2;
    /**
     * 扩展字段3 
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
