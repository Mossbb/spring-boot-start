package com.ryytn.start.web.controller;

import com.alibaba.fastjson2.JSON;
import com.ryytn.start.common.Result;
import com.ryytn.start.common.enums.RedisKeyEnum;
import com.ryytn.start.manager.config.DynamicConfig;
import java.time.Duration;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yinxin
 * @since 2020-10-14
 */
@Controller
@Slf4j
public class TestController {

  @Value("${common}")
  private String test;

  @Resource
  private Environment environment;

  @Resource
  private DynamicConfig dynamicConfig;

  @Resource
  private RedisTemplate<String, Object> redisTemplate;

  @RequestMapping("/test/status")
  @ResponseBody
  public Result<String> doTest(HttpServletRequest request, HttpServletResponse response) {
    Boolean setSuccess = redisTemplate.boundValueOps(
        RedisKeyEnum.TEST_STRING.getFinalKey("developer", "tony"))
      .setIfAbsent(30, Duration.ofMinutes(1));
    log.info("【commonConfig】{}【serverUpgrading】{}【dynamicConfig】{}【adminInfo】{}【setSuccess】{}",
      test,
      environment.getProperty("dynamic.serverUpgrading", Boolean.class),
      dynamicConfig.isServerUpgrading(),
      JSON.toJSONString(dynamicConfig.getAdminInfo()),
      setSuccess
    );
    return Result.buildSuccess("OK");
  }
}
