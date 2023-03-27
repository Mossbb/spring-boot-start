package com.ryytn.start.manager.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuxukang
 * @date 2023-03-24 17:25
 */
@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "dynamic")
public class DynamicConfig {

  private boolean serverUpgrading;

  private AdminInfo adminInfo;

  @Data
  public static class AdminInfo {
    private String account;
    private int role;
  }

}
