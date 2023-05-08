package com.ryytn.start.web.controller;

import com.alibaba.fastjson2.JSON;
import com.ryytn.start.common.Result;
import com.ryytn.start.common.enums.RedisKeyEnum;
import com.ryytn.start.manager.config.DynamicConfig;
import com.ryytn.start.manager.dto.request.UserAddOrUpdateReq;
import com.ryytn.start.service.entrance.UserService;
import java.time.Duration;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinxin
 * @since 2020-10-14
 */
@RestController
@Slf4j
@Validated
public class TestController {

  @Value("${common}")
  private String test;

  @Resource
  private Environment environment;

  @Resource
  private DynamicConfig dynamicConfig;

  @Resource
  private RedisTemplate<String, Object> redisTemplate;

  @Autowired
  private UserService userService;

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

  @PostMapping("/test/user/post")
  public Result<Boolean> doPostUser(@Validated @Valid @RequestBody UserAddOrUpdateReq req) {
    boolean b = userService.addOrUpdateUser(req);
    return Result.buildSuccess(b);
  }
}
