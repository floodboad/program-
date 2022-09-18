package com.xcl.xx.ssmdemo.entity.IntoParam;/**
 * @author xuchunlong
 * @create 2022-09-16-18:28
 */

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: gfk
 * @create: 2022/9/16
 * @Description:
 * @FileName: WPage
 * @History:
 * @自定义内容：
 */
@ToString(callSuper = true)
@Data
@RequiredArgsConstructor
public class WPage extends WO implements Serializable {
    private static final long serialVersionUID=-143235004546L;
    /**
     * page查询参数
     */
    private PageParams pageParams;
}