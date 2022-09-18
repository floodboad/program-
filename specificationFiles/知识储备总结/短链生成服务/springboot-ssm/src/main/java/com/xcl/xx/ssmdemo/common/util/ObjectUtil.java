package com.xcl.xx.ssmdemo.common.util;/**
 * @author xuchunlong
 * @create 2022-09-10-8:36
 */

/**
 * @author: gfk
 * @create: 2022/9/10
 * @Description:
 * @FileName: ObjectUtil
 * @History:
 * @自定义内容：
 */
public class ObjectUtil {

    private ObjectUtil() {}

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isNotNull(Object o) {
        return o != null;
    }
}