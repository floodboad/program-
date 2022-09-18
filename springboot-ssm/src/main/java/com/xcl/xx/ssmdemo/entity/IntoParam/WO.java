package com.xcl.xx.ssmdemo.entity.IntoParam;/**
 * @author xuchunlong
 * @create 2022-09-16-18:27
 */

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author: gfk
 * @create: 2022/9/16
 * @Description:
 * @FileName: WO
 * @History:
 * @自定义内容：
 */
@RequiredArgsConstructor
@ToString
public class WO implements Serializable {
    private static final long serialVersionUID=1435423155009356L;

    /**
     * 一次只能传入一条，各种Id，用于查询单体详情 例: projectId = XXX;
     */
    private String dataId;

    /**
     * 数据(JSON字符串,用于转java对象,或者其他数据）
     */
    private String data;

    /**
     * 获取userId
     * @param request
     * @return userId Long类型
     */
    public static Long getUserId(HttpServletRequest request){
        String userId = request.getHeader("userId");
        return Long.parseLong(userId);
    }

    /**
     * 获取手机号
     * @param request
     * @return
     */
    public static String getPhone(HttpServletRequest request){
        String phone = request.getHeader("userPhone");
        return phone;
    }

    public Long getDataId(){
        return Long.parseLong(dataId);
    }

    public String getData(){
        return data;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public void setData(String data) {
        this.data = data;
    }
}