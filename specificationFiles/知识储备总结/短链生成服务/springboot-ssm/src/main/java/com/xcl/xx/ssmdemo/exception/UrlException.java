package com.xcl.xx.ssmdemo.exception;/**
 * @author xuchunlong
 * @create 2022-09-10-8:31
 */


import com.xcl.xx.ssmdemo.constant.ErrorCode;

/**
 * @author: gfk
 * @create: 2022/9/10
 * @Description:
 * @FileName: UrlException
 * @History:
 * @自定义内容：
 */
public class UrlException extends RuntimeException {

    private final ErrorCode errorCode;

    public UrlException(ErrorCode errorCode) {
        this(errorCode, null);
    }

    public UrlException(ErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}