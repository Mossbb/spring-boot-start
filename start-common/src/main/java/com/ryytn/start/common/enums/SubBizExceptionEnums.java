package com.ryytn.start.common.enums;

import static com.ryytn.start.common.enums.BaseBizExceptionEnums.PARAMS_ERROR;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * SubBizExceptionEnums
 *
 * @author tony
 * @date 4/10/23
 */
@Getter
@AllArgsConstructor
public enum SubBizExceptionEnums implements ErrorBaseEnum {

  USER_NAME_NOT_BLANK(PARAMS_ERROR),
  ;

  private final BaseBizExceptionEnums parentCode;

  @Override
  public Integer getCode() {
    return parentCode.getCode();
  }

  @Override
  public String getKey() {
    return this.name();
  }

  public static ErrorBaseEnum getByKey(String key) {
    SubBizExceptionEnums exceptionEnums = CollectionUtil.findOne(ListUtil.of(SubBizExceptionEnums.values()),
      o -> o.name().equalsIgnoreCase(key));
    return Objects.nonNull(exceptionEnums) ? exceptionEnums : null;
  }
}
