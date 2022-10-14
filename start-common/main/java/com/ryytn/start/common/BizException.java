package com.ryytn.start.common;


import com.ryytn.start.common.enums.ErrorBaseEnum;

/**
 * <p>基础exception</p>
 *
 * @author yinxin
 * @since 2022/5/18
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = -8641213350581044979L;
    protected Integer errorCode;
    protected String errorKey;
    protected String errorMsg = "SYSTEM_ERROR";

    public BizException() {
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        errorMsg = message;
    }

    public BizException(String message) {
        super(message);
        errorMsg = message;
    }

    public BizException(Throwable cause) {
        super(cause);
        errorCode = 500;
        errorMsg = cause.getMessage();
    }

    public BizException(ErrorBaseEnum enums) {
        super(enums.getKey());
        errorCode = enums.getCode();
        errorKey = enums.getKey();
    }

    public BizException(Integer errorCode, String errorKey, String message) {
        super(message);
        this.errorKey = errorKey;
        this.errorCode = errorCode;
        errorMsg = message;
    }

    public Integer getCode() {
        return errorCode;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String toString() {
        return "BaseException [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
    }
}
