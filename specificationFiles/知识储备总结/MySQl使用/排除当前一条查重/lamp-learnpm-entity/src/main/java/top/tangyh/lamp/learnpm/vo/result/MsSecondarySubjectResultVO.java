package top.tangyh.lamp.learnpm.vo.result;

import cn.hutool.core.map.MapUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.TreeEntity;
import top.tangyh.basic.interfaces.echo.EchoVO;
import java.io.Serializable;

/**
 * <p>
 * 表单查询方法返回值VO
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
@ApiModel(value = "MsSecondarySubjectResultVO", description = "二级科目维护")
public class MsSecondarySubjectResultVO extends TreeEntity<MsSecondarySubjectResultVO, Long> implements Serializable, EchoVO {

    private static final long serialVersionUID = 1L;

    private Map<String, Object> echoMap = MapUtil.newHashMap();

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
