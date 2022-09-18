package top.tangyh.lamp.learnpm.vo.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.SuperEntity;
import java.io.Serializable;

/**
 * <p>
 * 表单修改方法VO
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
@EqualsAndHashCode
@Builder
@ApiModel(value = "MsSecondarySubjectUpdateVO", description = "二级科目维护")
public class MsSecondarySubjectUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @NotNull(message = "请填写id", groups = SuperEntity.Update.class)
    private Long id;

    /**
     * 一级科目名称
     */
    @ApiModelProperty(value = "一级科目名称")
    @NotEmpty(message = "请填写一级科目名称")
    @Size(max = 300, message = "一级科目名称长度不能超过{max}")
    private String firstSubjectName;
    /**
     * 二级科目名称
     */
    @ApiModelProperty(value = "二级科目名称")
    @NotEmpty(message = "请填写二级科目名称")
    @Size(max = 300, message = "二级科目名称长度不能超过{max}")
    private String secondarySubjectName;
    /**
     * 二级科目编码
     */
    @ApiModelProperty(value = "二级科目编码")
    @NotEmpty(message = "请填写二级科目编码")
    @Size(max = 300, message = "二级科目编码长度不能超过{max}")
    private String secondarySubjectCode;
    /**
     * OA对照码
     */
    @ApiModelProperty(value = "OA对照码")
    @Size(max = 300, message = "OA对照码长度不能超过{max}")
    private String oaReferenceCode;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Size(max = 300, message = "名称长度不能超过{max}")
    private String name;

    @ApiModelProperty(value = "父节点")
    protected Long parentId;

    @ApiModelProperty(value = "排序号")
    protected Integer sortValue;

}
