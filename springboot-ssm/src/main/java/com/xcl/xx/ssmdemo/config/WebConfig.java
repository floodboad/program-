package com.xcl.xx.ssmdemo.config;/**
 * @author xuchunlong
 * @create 2022-09-16-8:51
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: gfk
 * @create: 2022/9/16
 * @Description:
 * @FileName: WebConfig
 * @History:
 * @自定义内容：
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //不拦截的uri
        final String[] commonExclude = {"/error", "/files/**"};
        registry.addInterceptor(repeatSubmitInterceptor).excludePathPatterns(commonExclude);
    }
}