package top.tangyh.lamp.learnpm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import static com.baomidou.mybatisplus.annotation.SqlCondition.EQUAL;
import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;
import top.tangyh.basic.base.entity.TreeEntity;


/**
 * <p>
 * 实体类
 * 二级科目维护
 * </p>
 *
 * @author zuihou
 * @date 2022-06-17 11:55:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@TableName("ms_secondary_subject")
public class MsSecondarySubject extends TreeEntity<MsSecondarySubject, Long> {
    private static final long serialVersionUID = 1L;

    /**
     * 一级科目名称
     */
    @TableField(value = "`FIRST_SUBJECT_NAME`", condition = LIKE)
    private String firstSubjectName;
    /**
     * 二级科目名称
     */
    @TableField(value = "`SECONDARY_SUBJECT_NAME`", condition = LIKE)
    private String secondarySubjectName;
    /**
     * 二级科目编码
     */
    @TableField(value = "`SECONDARY_SUBJECT_CODE`", condition = LIKE)
    private String secondarySubjectCode;
    /**
     * OA对照码
     */
    @TableField(value = "`OA_REFERENCE_CODE`", condition = LIKE)
    private String oaReferenceCode;
    /**
     * 名称
     */
    @TableField(value = "`NAME`", condition = LIKE)
    private String name;



}
