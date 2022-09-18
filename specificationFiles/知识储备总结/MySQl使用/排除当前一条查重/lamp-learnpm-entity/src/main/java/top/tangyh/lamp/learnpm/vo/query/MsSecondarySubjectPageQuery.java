package top.tangyh.lamp.learnpm.vo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import java.io.Serializable;


/**
 * <p>
 * 表单查询条件VO
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
@ApiModel(value = "MsSecondarySubjectPageQuery", description = "二级科目维护")
public class MsSecondarySubjectPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    /**
    * 一级科目名称
    */
    @ApiModelProperty(value = "一级科目名称")
    private String firstSubjectName;
    /**
    * 二级科目名称
    */
    @ApiModelProperty(value = "二级科目名称")
    private String secondarySubjectName;
    /**
    * 二级科目编码
    */
    @ApiModelProperty(value = "二级科目编码")
    private String secondarySubjectCode;
    /**
    * OA对照码
    */
    @ApiModelProperty(value = "OA对照码")
    private String oaReferenceCode;
    /**
    * 名称
    */
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "父节点")
    protected Long parentId;

    @ApiModelProperty(value = "排序号")
    protected Integer sortValue;


}
