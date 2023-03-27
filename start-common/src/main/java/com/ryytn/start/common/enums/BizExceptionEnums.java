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
public enum BizExceptionEnums implements ErrorBaseEnum {
  /**
   * 【不允许设置其他code，自定义扩展ErrorBaseEnum的也只能使用这几个异常码】 成功 - 0 参数错误 - 100 网络错误 - 200 三方服务异常 - 300 权限异常 -
   * 400 已知业务异常 - 500（比如各种校验等） 系统异常 - 999
   */
  SUCCESS(0, "成功", "Success"),
  PARAMS_ERROR(100, "参数错误，请重新确认", "Parameter error, please reconfirm"),
  NET_WORK_ERROR(200, "网络错误，请稍后重试", "Network error. Please try again later."),
  REMOTE_SERVER_ERROR(300, "三方服务异常，请稍后重试",
      "Three-party service is abnormal. Please try again later."),
  AUTH_ERROR(400, "权限异常，请找管理员确认",
      "Permission exception, please check with the administrator"),
  BUSINESS_ERROR(500, "业务异常，请找相关产品确认",
      "Business exception, please find the relevant product to confirm"),
  SYSTEM_ERROR(999, "系统异常，请稍后重试", "The system is abnormal, please try again later"),
  ;

  /**
   * 错误码
   */
  private final Integer code;
  /**
   * 中文错误信息
   */
  private final String cnMsg;
  /**
   * 英文错误信息
   */
  private final String enMsg;

  @Override
  public String getKey() {
    return this.name();
  }

  @Override
  public String getDefaultMsg() {
    return getCnMsg();
  }

  public String getEnMsg() {
    return enMsg;
  }
}
