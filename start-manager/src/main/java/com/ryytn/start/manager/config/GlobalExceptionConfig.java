package com.ryytn.start.manager.config;

import static com.ryytn.start.common.enums.BaseBizExceptionEnums.METHOD_NOT_SUPPORT;
import static com.ryytn.start.common.enums.BaseBizExceptionEnums.PARAMS_ERROR;
import static com.ryytn.start.common.enums.BaseBizExceptionEnums.SYSTEM_ERROR;

import cn.hutool.log.Log;
import com.ryytn.start.common.BizException;
import com.ryytn.start.common.Result;
import com.ryytn.start.common.enums.ErrorBaseEnum;
import com.ryytn.start.common.enums.SubBizExceptionEnums;
import com.ryytn.start.common.utils.MessageUtil;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * RestControllerAdvice.
 *
 * @author xuxukang
 */
@RestControllerAdvice
public class GlobalExceptionConfig {

  private static final Log log = Log.get(GlobalExceptionConfig.class);

  @ExceptionHandler(Exception.class)
  public Result<String> serverExceptionHandler(final Exception exception,
    HttpServletRequest request) {
    log.error("【buildFail】handle web global exception【reqUri】{}", exception,
      request.getRequestURI());

    ErrorBaseEnum errorBaseEnum = SYSTEM_ERROR;

    if (exception instanceof BizException) {
      BizException bizException = (BizException) exception;
      errorBaseEnum = bizException.getError();
    } else if (exception instanceof IllegalStateException
      || exception instanceof IllegalArgumentException
      || exception instanceof ValidationException
      || exception instanceof HttpMessageConversionException) {
      errorBaseEnum = PARAMS_ERROR;
    } else if (exception instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException ex = (MethodArgumentNotValidException) exception;
      errorBaseEnum = PARAMS_ERROR;
      FieldError fieldbuildFail = ex.getBindingResult().getFieldError();
      if (Objects.nonNull(fieldbuildFail)) {
        ErrorBaseEnum byKey = SubBizExceptionEnums.getByKey(fieldbuildFail.getDefaultMessage());
        errorBaseEnum = Objects.nonNull(byKey) ? byKey : errorBaseEnum;
      }
    } else if (exception instanceof HttpRequestMethodNotSupportedException) {
      errorBaseEnum = METHOD_NOT_SUPPORT;
    }

    Result<String> result = Result.buildFail(errorBaseEnum);
    try {
      result.setMessage(MessageUtil.getMessage(errorBaseEnum.getKey()));
    } catch (NoSuchMessageException e) {
      // ignore
    }
    return result;
  }

}
