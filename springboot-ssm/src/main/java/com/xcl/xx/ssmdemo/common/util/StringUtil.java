package com.xcl.xx.ssmdemo.common.util;/**
 * @author xuchunlong
 * @create 2022-09-12-16:18
 */

/**
 * @author: gfk
 * @create: 2022/9/12
 * @Description:
 * @FileName: StringUtil
 * @History:
 * @自定义内容：
 */
public class StringUtil {
    private StringUtil() {}

    public static final String EMPTY = "";

    public static boolean isEmpty(String str) {
        return str == null || EMPTY.equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}