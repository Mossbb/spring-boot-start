package com.ryytn.start.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>异常枚举</p>
 *
 * @author yinxin
 * @since 2022/10/14
 */
@Getter
@AllArgsConstructor
public enum BaseBizExceptionEnums implements ErrorBaseEnum {
  /**
   * 【不允许设置其他code，自定义扩展ErrorBaseEnum的也只能使用这几个异常码】
   * 成功 - 0
   * 参数错误 - 100
   * 网络错误 - 200
   * 三方服务异常 - 300
   * 权限异常 - 400
   * 方法不支持 - 500
   * 已知业务异常 - 600（比如各种业务校验等）
   * 系统异常 - 999
   */
  SUCCESS(0),
  PARAMS_ERROR(100),
  NET_WORK_ERROR(200),
  REMOTE_SERVER_ERROR(300),
  AUTH_ERROR(400),
  METHOD_NOT_SUPPORT(500),
  BUSINESS_ERROR(600),
  SYSTEM_ERROR(999),
  ;

  /**
   * 错误码
   */
  private final Integer code;

  @Override
  public String getKey() {
    return this.name();
  }

}
