package com.xcl.xx.ssmdemo.service;
/**
 * @author xuchunlong
 * @create 2022-09-09-23:19
 */



import com.xcl.xx.ssmdemo.common.util.NumericConvertUtils;
import com.xcl.xx.ssmdemo.common.util.ObjectUtil;
import com.xcl.xx.ssmdemo.config.SnowFlake;
import com.xcl.xx.ssmdemo.constant.ErrorCode;
import com.xcl.xx.ssmdemo.dao.mysql.ShortUrlMapper;
import com.xcl.xx.ssmdemo.dao.pojo.ShortUrl;
import com.xcl.xx.ssmdemo.dao.pojo.ShortenRequest;
import com.xcl.xx.ssmdemo.exception.UrlException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * @author: gfk
 * @create: 2022/9/9
 * @Description: 以 https://leetcode.cn/problem-list/xb9nqhhg/?page=3 为例做短链生成   协议、主机、端口、路径。资源类型、存放资源的主机域名、资源文件名
 *                  https://leetcode.cn/FWSc3ki8mY
 * @FileName: ShortLinkUrlServiceImpl
 * @History:
 * @自定义内容：
 */
@Service
@Slf4j
public class ShortLinkUrlService  {

    @Resource
    private ShortUrlMapper shortUrlMapper;
    private  int count = 111111;

    @Transactional(rollbackFor = Throwable.class)
    public String shorten(ShortenRequest request) {
        // 采取域名（不加密/不转化）+ 之后的url转化
        String url = request.getUrl();
        // 获取域名
        int index = url.indexOf("/");
        index=url.indexOf("/", index+1);
        index=url.indexOf("/", index+1);
        String domainName = url.substring(0,index);
        String sourcePath = url.substring(index+1,url.length());
        // 拼接完整短链接
        StringBuilder sb = new StringBuilder();
        sb.append(domainName);
        // 生成短链接
        SnowFlake snowFlake = new SnowFlake(0,0);
        String shortUrl = String.valueOf(NumericConvertUtils.toOtherNumberSystem(snowFlake.nextId(),62));
        log.info("获取到短链接:"+shortUrl);
        sb.append("/");
        sb.append(shortUrl);
        String endShortUrl = sb.toString();
        // 检验长连接与生成的短链接是否库中重复
        ArrayList<ShortUrl> shortUrlList = shortUrlMapper.selectByOriginUrl(request.getUrl());
        if (ObjectUtil.isNotNull(shortUrlList)) {
            for (int i = 0; i < shortUrlList.size() - 1; ++i) {
                if (url.equals(shortUrlList.get(i).getOriginUrl()) && endShortUrl.equals(shortUrlList.get(i).getShortUrl())) {
                    log.info("数据库中存在相同的长连接与短链接的映射");
                    throw new UrlException(ErrorCode.URL_IN_DB);
                }
            }
        }
        count++;
        ShortUrl shortUrl1 = shortUrlFill(endShortUrl,url,count);
        shortUrlMapper.saveShortUrl(shortUrl1);
        return sb.toString();
    }


    public String getSkipUrl(String param) {
        // https://leetcode.cn/FWSc3ki8mY
        ShortUrl shortUrl = shortUrlMapper.getOriginUrl(param);
        log.info("拿到短链接对应的原始链接映射："+shortUrl);
        String url = shortUrl.getOriginUrl();
        log.info("拿到短链接对应的原始链接："+url);
        return url;
    }

    private ShortUrl shortUrlFill(String minUrl,String url,int id){
        ShortUrl shortUrl = new ShortUrl();

        // 获取一个星期以后的时间
        Date date ;
        SimpleDateFormat df;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.WEEK_OF_YEAR,
                calendar.get(Calendar.WEEK_OF_YEAR) + 1);
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("一个星期以后的时间：" + df.format(calendar.getTime()));
        try {
            date = df.parse(df.format(new Date()));
            shortUrl.setCreateTime(date);
            date = df.parse(df.format(calendar.getTime()));
            shortUrl.setExpireTime(date);
            shortUrl.setOriginUrl(url);
            shortUrl.setShortUrl(minUrl);
            shortUrl.setId(Long.valueOf(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return shortUrl;
    }

}