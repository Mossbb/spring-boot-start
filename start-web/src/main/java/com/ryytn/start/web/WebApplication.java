package com.ryytn.start.web;

import cn.hutool.extra.spring.EnableSpringUtil;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author yinxin
 * @since 2020-10-13
 */
@SpringBootApplication(scanBasePackages = "com.ryytn.start")
@MapperScan(basePackages = "com.ryytn.start.dao.mapper")
@EnableConfigurationProperties
@EnableSpringUtil
@EnableDubbo(scanBasePackages = {"com.ryytn.start.service.entrance"})
public class WebApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class, args);
  }
}
