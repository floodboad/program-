package com.xcl.xx.ssmdemo.constant;/**
 * @author xuchunlong
 * @create 2022-09-10-8:27
 */

/**
 * @author: gfk
 * @create: 2022/9/10
 * @Description:  错误编码
 * @FileName: ErrorCode
 * @History:
 * @自定义内容：
 */
public enum ErrorCode {
    SUCCESS(0, "成功"),
    SYSTEM_ERROR(1, "系统错误"),
    BAD_PARAMETER(2, "参数错误（bad parameter）"),
    URL_IN_DB(3,"数据库里找到这条数据");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}