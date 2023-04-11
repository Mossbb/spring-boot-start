package com.ryytn.start.common;

import com.ryytn.start.common.enums.ErrorBaseEnum;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>基础result</p>
 * <p>分页result可以使用{@link cn.hutool.db.PageResult}</p>
 *
 * @author yinxin
 * @since 2022/10/14
 */
@Data
public class Result<T> implements Serializable {

  private Boolean success;
  private T data;
  private Long total;
  private Integer code;
  private String message;
  /**
   * 实际业务异常码 {@link ErrorBaseEnum#getKey()}
   */
  private String subCode;

  public Result() {
  }

  public static <T> Result<T> buildSuccess(T data) {
    Result<T> result = new Result<>();
    result.setCode(200);
    result.setSuccess(Boolean.TRUE);
    result.setData(data);
    return result;
  }

  public static <T> Result<T> buildSuccess(T data, Long total) {
    Result<T> result = new Result<>();
    result.setCode(200);
    result.setSuccess(Boolean.TRUE);
    result.setData(data);
    result.setTotal(total);
    return result;
  }

  public static <T> Result<T> buildSuccess() {
    Result<T> result = new Result<>();
    result.setCode(200);
    result.setSuccess(Boolean.TRUE);
    result.setData(null);
    return result;
  }

  public static <T> Result<T> buildFail(ErrorBaseEnum error) {
    Result<T> result = new Result<>();
    result.setSuccess(Boolean.FALSE);
    result.setCode(error.getCode());
    result.setSubCode(error.getKey());
    result.setData(null);
    return result;
  }
}
