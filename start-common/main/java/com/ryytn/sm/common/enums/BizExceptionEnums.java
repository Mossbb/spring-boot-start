package com.ryytn.sm.common.enums;

/**
 * <p>异常枚举</p>
 *
 * @author yinxin
 * @since 2022/10/14
 */
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
    private Integer errorCode;
    /**
     * 错误key 多语言使用
     */
    private String errorKey;
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

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getCnMsg() {
        return cnMsg;
    }

    public void setCnMsg(String cnMsg) {
        this.cnMsg = cnMsg;
    }

    public String getEnMsg() {
        return enMsg;
    }

    public void setEnMsg(String enMsg) {
        this.enMsg = enMsg;
    }

    @Override
    public Integer getCode() {
        return getErrorCode();
    }

    @Override
    public String getKey() {
        return errorKey;
    }
}
