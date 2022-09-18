package com.xcl.xx.ssmdemo.dao.mysql;/**
 * @author xuchunlong
 * @create 2022-09-10-7:29
 */



import com.xcl.xx.ssmdemo.dao.pojo.ShortUrl;

import java.util.ArrayList;

/**
 * @author: gfk
 * @create: 2022/9/10
 * @Description:短链表  Mapper接口
 * @FileName: ShortUrlMapper
 * @History:
 * @自定义内容：
 */
public interface ShortUrlMapper {

    // 数据库查重
    ArrayList<ShortUrl> selectByOriginUrl(String originUrl1);
    // 生成短链持久化
    void saveShortUrl(ShortUrl shortUrl);
    // 通过短连接获取原始url访问
    ShortUrl getOriginUrl(String param);
}