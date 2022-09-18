package com.xcl.xx.ssmdemo.entity;/**
 * @author xuchunlong
 * @create 2022-09-09-22:59
 */


import lombok.Data;

/**
 * @author: gfk
 * @create: 2022/9/9
 * @Description:
 * @FileName: shortenRequest
 * @History:
 * @自定义内容：这个是封装的入参对象
 */
@Data
public class ShortenRequestVo {

    /**
     * 原始URL
     */
    private String url;

    /**
     * 算法，目前支持算法有(进制算法)
     * 默认为：进制算法
     */
    private String type = "DECIMAL";

    /**
     * 用户期望可变参数长度，参数最大值需要用户根据实际业务场景评估
     * 场景1：如果用户想转换几个链接，那么可以选择较短的参数长度
     * 场景2：如果用户的短连接无穷大，那么可以不指定参数长度，系统直接生成全局唯一
     * 默认不限制
     */
    private Integer length;

    /**
     * HTTP重定向状态码
     * 用户打开短连接时，需要重定向到原始的URL，该状态码用于告诉浏览器客户端如何重定向
     * 重定向状态码建议使用302，
     * 默认为302
     */
    private Integer httpStatusCode = 302;

    /**
     * 应用程序期望使用的域名
     */
    private String domain;

    /**
     * URL失效时间
     * 如果不传，则默认无限制
     */
    private String expireDate;
}