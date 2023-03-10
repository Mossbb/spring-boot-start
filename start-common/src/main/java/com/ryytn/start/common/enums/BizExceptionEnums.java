package com.ryytn.start.common.enums;

import lombok.Getter;

/**
 * <p>异常枚举</p>
 *
 * @author yinxin
 * @since 2022/10/14
 */
@Getter
public enum BizExceptionEnums implements ErrorBaseEnum {
    /**
     * 系统基础错误 0-200
     */
    NET_WORK_ERROR(0, "NET_WORK_ERROR", "网络错误,请稍后重试", "网络错误,请稍后重试", "network error, please try again later"),
    PARAMS_ERROR(100, "PARAMS_ERROR", "参数错误", "参数错误", "params error"),
    ;

    BizExceptionEnums(Integer errorCode, String errorKey, String errorMsg) {
        this.errorCode = errorCode;
        this.errorKey = errorKey;
        this.errorMsg = errorMsg;
    }

    BizExceptionEnums(Integer errorCode, String errorKey, String errorMsg, String cnMsg, String enMsg) {
        this.errorCode = errorCode;
        this.errorKey = errorKey;
        this.errorMsg = errorMsg;
        this.cnMsg = cnMsg;
        this.enMsg = enMsg;
    }

    BizExceptionEnums(Integer errorCode, String errorKey, String cnMsg, String enMsg) {
        this.errorCode = errorCode;
        this.errorKey = errorKey;
        this.cnMsg = cnMsg;
        this.enMsg = enMsg;
    }

    /**
     * 错误码
     */
    private final Integer errorCode;
    /**
     * 错误key 多语言使用
     */
    private final String errorKey;
    /**
     * 错误消息
     */
    private String errorMsg;
    /**
     * 中文错误消息
     */
    private String cnMsg;
    /**
     * 英文错误消息
     */
    private String enMsg;


    @Override
    public Integer getCode() {
        return getErrorCode();
    }

    @Override
    public String getKey() {
        return errorKey;
    }
}
