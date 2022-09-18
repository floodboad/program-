package com.xcl.xx.ssmdemo.dao.pojo;/**
 * @author xuchunlong
 * @create 2022-09-10-7:12
 */



import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author: gfk
 * @create: 2022/9/10
 * @Description:
 * @FileName: ShortUrl
 * @History:
 * @自定义内容：这个是操作数据库表数据的实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_short_url")
public class ShortUrl {

    private Long id;

    /**
     * 原始URL
     */
    private String originUrl;

    /**
     * 短连接URL
     */
    private String shortUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 过期时间
     */
    private Date expireTime;

}