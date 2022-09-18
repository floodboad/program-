package com.xcl.xx.ssmdemo.annotion;/**
 * @author xuchunlong
 * @create 2022-09-16-8:45
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: gfk
 * @create: 2022/9/16
 * @Description:
 * @FileName: RepeatSubmit
 * @History:
 * @自定义内容：
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatSubmit {
    /**
     * 默认失效时间5秒
     */
    long seconds() default 5;
}