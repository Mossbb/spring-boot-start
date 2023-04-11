package com.ryytn.start.service.action;

import static com.ryytn.start.common.constants.BaseConstants.DEFAULT_MAX_LOG_LENGTH;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.ryytn.start.common.BizException;
import com.ryytn.start.common.enums.BaseBizExceptionEnums;
import com.ryytn.start.manager.config.DynamicConfig;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xuxukang
 * @create 2021/9/17 上午11:12
 */
@Component
public abstract class AbstractAction<Req, Resp> {

  private static final Log log = Log.get();

  @Autowired
  private DynamicConfig dynamicConfig;

  /**
   * 某个方法具体调用逻辑
   *
   * @param request service请求对象
   * @return Resp
   */
  protected abstract Resp doInvoke(Req request);

  /**
   * 获取业务逻辑action name
   *
   * @return String
   */
  protected abstract String actionName();

  /**
   * 业务前置校验
   *
   * @param request 业务请求对象
   */
  protected void preCheck(Req request) {
    // ignore
  }

  /**
   * 抽象模板
   *
   * @param request service请求对象
   * @return Resp
   */
  public Resp invoke(Req request) {
    String actionName = this.getClass().getSimpleName();
    String reqStr = StrUtil.subPre(JSON.toJSONString(request), DEFAULT_MAX_LOG_LENGTH);
    String respStr = null;
    Throwable exception = null;
    long intervalMs = 0L;

    try {
      if (dynamicConfig.isServerUpgrading()) {
        throw new BizException(BaseBizExceptionEnums.SYSTEM_ERROR);
      }

      preCheck(request);

      // 可以加before listener
      TimeInterval timeInterval = new TimeInterval();
      Resp resp = ((AbstractAction<Req, Resp>) SpringUtil.getBean(this.getClass())).doInvoke(
          request);

      intervalMs = timeInterval.intervalMs();
      respStr = StrUtil.subPre(JSON.toJSONString(resp), DEFAULT_MAX_LOG_LENGTH);
      // 可以加after listener

      return resp;
    } catch (Exception e) {
      exception = e;
      throw e;
    } finally {
      if (Objects.nonNull(exception)) {
        log.error(exception,
            "\n┏━━━━━━━━━━━━━━━━━━━━━━━ Action Handler(start) ━━━━━━━━━━━━━━━━━━━━━\n"
                + "┣ Action：[{}]\n"
                + "┣ 参数：[{}]\n"
                + "┣ 时间：[{}(ms)]\n"
                + "┣ 结果：[{}]\n"
                + "┣ 异常：[{}]\n"
                + "┗━━━━━━━━━━━━━━━━━━━━━━━ Action Handler(end) ━━━━━━━━━━━━━━━━━━━━━",
            actionName, reqStr, intervalMs, null, exception.getMessage());
      } else {
        log.info("\n┏━━━━━━━━━━━━━━━━━━━━━━━ Action Handler(start) ━━━━━━━━━━━━━━━━━━━━━\n"
                + "┣ Action：[{}]\n"
                + "┣ 参数：[{}]\n"
                + "┣ 时间：[{}(ms)]\n"
                + "┣ 结果：[{}]\n"
                + "┗━━━━━━━━━━━━━━━━━━━━━━━ Action Handler(end) ━━━━━━━━━━━━━━━━━━━━━",
            actionName, reqStr, intervalMs, respStr);
      }
    }
  }
}
