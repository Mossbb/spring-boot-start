package com.ryytn.sm.common;

import java.io.Serializable;

/**
 * <p>基础result</p>
 *
 * @author yinxin
 * @since 2022/10/14
 */
public class Result<T> implements Serializable {
    private Boolean success;
    private T data;
    private Long total;
    private Integer responseCode;
    private String message;

    public Result() {
    }

    public static <T> Result<T> buildSuccess(T data) {
        Result<T> result = new Result();
        result.setResponseCode(200);
        result.setSuccess(Boolean.TRUE);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> buildSuccess(T data, Long total) {
        Result<T> result = new Result();
        result.setResponseCode(200);
        result.setSuccess(Boolean.TRUE);
        result.setData(data);
        result.setTotal(total);
        return result;
    }

    public static <T> Result<T> buildSuccess() {
        Result<T> result = new Result();
        result.setResponseCode(200);
        result.setSuccess(Boolean.TRUE);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> buildFail(Integer code, String msg) {
        Result<T> result = new Result();
        result.setSuccess(Boolean.FALSE);
        result.setMessage(msg);
        result.setResponseCode(code);
        result.setData(null);
        return result;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
