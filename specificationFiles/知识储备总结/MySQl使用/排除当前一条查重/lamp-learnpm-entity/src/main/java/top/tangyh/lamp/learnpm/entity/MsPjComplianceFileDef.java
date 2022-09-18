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

/**
 * <p>
 * 项目合规文件定义实体类
 * </p>
 *
 * @author xucl
 * @date 2022-07-06
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("MS_PJ_COMPLIANCE_FILE_DEF")
@AllArgsConstructor
@Builder
public class MsPjComplianceFileDef extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 合规文件名称 
     */
     @TableField(value = "COMPLIANCE_FILE_NAME ", condition = LIKE)
    private String complianceFileName;
    /**
     * 说明 
     */
     @TableField(value = "ILLUSTRATE ", condition = LIKE)
    private String illustrate;
    /**
     * 是否有效 
     */
     @TableField(value = "IS_VALID ", condition = LIKE)
    private String isValid;
    /**
     * 会议执行环节 
     */
     @TableField(value = "MEETING_EXECUTION_LINK ", condition = LIKE)
    private String meetingExecutionLink;

}
