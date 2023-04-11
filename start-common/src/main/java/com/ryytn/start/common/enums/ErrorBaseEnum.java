package com.ryytn.start.common.enums;

/**
 * <p>基础错误</p>
 *
 * @author yinxin
 * @since 2022/10/14
 */
public interface ErrorBaseEnum {

  /**
   * @return 错误码
   */
  Integer getCode();

  /**
   * @return 错误标志
   */
  String getKey();

}
