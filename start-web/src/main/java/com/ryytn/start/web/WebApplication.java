package com.ryytn.start.web;

import cn.hutool.extra.spring.EnableSpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author yinxin
 * @since 2020-10-13
 */
@SpringBootApplication(scanBasePackages = "com.ryytn.start")
@MapperScan(basePackages = "com.ryytn.start.dao")
@EnableConfigurationProperties
@EnableSpringUtil
public class WebApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class, args);
  }
}
