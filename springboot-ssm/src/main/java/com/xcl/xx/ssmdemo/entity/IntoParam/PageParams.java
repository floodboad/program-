package com.xcl.xx.ssmdemo.entity.IntoParam;/**
 * @author xuchunlong
 * @create 2022-09-16-18:29
 */

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: gfk
 * @create: 2022/9/16
 * @Description:
 * @FileName: PageParams
 * @History:
 * @自定义内容：
 */
@Data
@NoArgsConstructor
public class PageParams {

    private int current;
    private int size ;
}