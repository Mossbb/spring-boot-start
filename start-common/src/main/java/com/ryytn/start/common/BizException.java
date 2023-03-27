package com.ryytn.start.common;


import cn.hutool.core.util.StrUtil;
import com.ryytn.start.common.enums.BizExceptionEnums;
import com.ryytn.start.common.enums.ErrorBaseEnum;

/**
 * <p>基础exception</p>
 *
 * @author yinxin
 * @since 2022/5/18
 */
public class BizException extends RuntimeException {

  private static final long serialVersionUID = -8641213350581044979L;

  protected ErrorBaseEnum error;

  public BizException(ErrorBaseEnum error) {
    super(error.getDefaultMsg());
    this.error = error;
  }

  public BizException(Throwable throwable) {
    super(BizExceptionEnums.SYSTEM_ERROR.getDefaultMsg(), throwable);
    this.error = BizExceptionEnums.SYSTEM_ERROR;
  }

  public BizException(ErrorBaseEnum error, String msg) {
    super(StrUtil.isBlank(msg) ? error.getDefaultMsg() : msg);
    this.error = error;
  }

  public BizException(ErrorBaseEnum error, String msg, Throwable cause) {
    super(StrUtil.isBlank(msg) ? error.getDefaultMsg() : msg, cause);
    this.error = error;
  }

  public Integer getErrorCode() {
    return error.getCode();
  }

  public String getErrorKey() {
    return error.getKey();
  }

  public String getErrorMsg() {
    return error.getDefaultMsg();
  }

}
