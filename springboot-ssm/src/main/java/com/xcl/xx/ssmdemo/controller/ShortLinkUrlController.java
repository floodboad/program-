package com.xcl.xx.ssmdemo.controller;/**
 * @author xuchunlong
 * @create 2022-09-09-23:08
 */


import com.xcl.xx.ssmdemo.annotion.RepeatSubmit;
import com.xcl.xx.ssmdemo.dao.pojo.ShortenRequest;
import com.xcl.xx.ssmdemo.entity.MinUrlReqVo;
import com.xcl.xx.ssmdemo.service.ShortLinkUrlService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: gfk
 * @create: 2022/9/9
 * @Description:
 * @FileName: ShortLinkUrlController
 * @History:
 * @自定义内容：
 */
@Controller
@RequestMapping("/")
@Slf4j
public class ShortLinkUrlController {

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @Resource
    private ShortLinkUrlService shortLinkUrlService;

    /**
     * 生成短连接
     * https://leetcode.cn/problem-list/xb9nqhhg/?page=3-->https://leetcode.cn/FWSc3ki8mY
     * @param generateRequest 生成短连接
     * @return 短连接 https: //leetcode.cn/UJGrK9O6wE
     *
     * 访问参数：
     * {
     * "url": "https://leetcode.cn/problem-list/xb9nqhhg/?page=4",
     * "type": "DECIMAL",
     * "length": "",
     * "httpStatusCode": "",
     * "domain": "",
     * "expireDate": ""
     * }
     */

    @RequestMapping(value = "/shorten", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String generate(@RequestBody ShortenRequest generateRequest) {
        String shortUrl = shortLinkUrlService.shorten(generateRequest);
        return shortUrl;
    }

    /**
     * 重定向到原始URL
     * https://leetcode.cn/FWSc3ki8mY-->https://leetcode.cn/problem-list/xb9nqhhg/?page=3
     * @param minUrlReqVo 短连接参数
     *
     *  访问参数：
     *   {
     * "minUrl": "https://leetcode.cn/UJFx0rf5VC"
     * }
     *
     *    返回值：    https: //leetcode.cn/problem-list/xb9nqhhg/?page=3
     */
    @ResponseBody
    @RequestMapping(value = "/origin",method = RequestMethod.POST,produces = "application/json")
    public String redirect(@RequestBody MinUrlReqVo minUrlReqVo ) {
        String param = minUrlReqVo.getMinUrl();
        log.info("拿到的入参是："+param);
        String OriginUrl = shortLinkUrlService.getSkipUrl(param);
        response.setHeader(OriginUrl,"302");
        return  OriginUrl;
        //return "redirect:" + OriginUrl;
    }

    @ResponseBody
    @RequestMapping(value = "/testIntercept",method = RequestMethod.POST,produces = "application/json")
    @RepeatSubmit
    public String testIntercept(@RequestBody MinUrlReqVo minUrlReqVo) {
        String param = minUrlReqVo.getMinUrl();
        log.info("拿到的入参是："+param);
        String OriginUrl = shortLinkUrlService.getSkipUrl(param);
        return  OriginUrl;
        //return "redirect:" + OriginUrl;
    }
}