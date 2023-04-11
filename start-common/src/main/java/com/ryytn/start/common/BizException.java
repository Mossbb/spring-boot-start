package com.ryytn.start.common;


import com.ryytn.start.common.enums.ErrorBaseEnum;
import lombok.Getter;

/**
 * <p>基础exception</p>
 *
 * @author yinxin
 * @since 2022/5/18
 */
public class BizException extends RuntimeException {

  private static final long serialVersionUID = -8641213350581044979L;

  @Getter
  protected ErrorBaseEnum error;

  public BizException(ErrorBaseEnum error) {
    super(error.getKey());
    this.error = error;
  }

  public BizException(ErrorBaseEnum error, Throwable cause) {
    super(error.getKey(), cause);
    this.error = error;
  }

}
