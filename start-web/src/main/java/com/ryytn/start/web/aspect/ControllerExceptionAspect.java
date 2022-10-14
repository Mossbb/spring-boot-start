package com.ryytn.start.web.aspect;

import com.ryytn.start.common.BizException;
import com.ryytn.start.common.Result;
import com.ryytn.start.common.dto.RequestContextDTO;
import com.ryytn.start.common.enums.BizExceptionEnums;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <p>controller全局异常处理</p>
 *
 * @author yinxin
 * @since 2022/10/14
 */
@Component
@Aspect
@Slf4j
public class ControllerExceptionAspect {
    @Pointcut("execution(* com.ryytn.start.web.controller..*(..))")
    public void aspect() {
    }

    @Around("aspect()")
    public Object handle(ProceedingJoinPoint pjp) {
        RequestContextDTO contextDTO = getContextDTO(pjp.getArgs());
        try {
            StopWatch started = StopWatch.createStarted();
            Result returnObj = (Result) pjp.proceed();
            MethodSignature signature = (MethodSignature) pjp.getSignature();

            ControllerExceptionAspect.log.info("request end,method:{},spendTime:{}", signature.getMethod().getName(), started.getTime());
            started.stop();
            return returnObj;
        } catch (Throwable e) {
            return handlerException(pjp, e);
        }
    }

    private RequestContextDTO getContextDTO(Object[] args) {
        if (args == null || args.length <= 0) {
            return null;
        }
        return Arrays.stream(args)
                .filter(o -> o instanceof RequestContextDTO)
                .map(o -> (RequestContextDTO) o)
                .findFirst()
                .orElse(null);
    }

    private Result handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result result = null;
        String errorMessage = BizExceptionEnums.NET_WORK_ERROR.getErrorMsg();
        Integer errorCode = BizExceptionEnums.NET_WORK_ERROR.getErrorCode();
        if (e instanceof BizException) {
            BizException bizException = (BizException) e;
            errorMessage = bizException.getErrorMsg();
            errorCode = bizException.getCode();
        }
        result = Result.buildFail(errorCode, errorMessage);
        ControllerExceptionAspect.log.error("controller execute,signature:{},error:{},stackTrace:{}", pjp.getSignature(), e, e.getStackTrace());
        return result;
    }
}
