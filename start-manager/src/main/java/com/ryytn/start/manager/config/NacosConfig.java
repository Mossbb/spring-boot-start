package com.ryytn.start.manager.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.ryytn.start.manager.listener.NacosCommonConfigListener;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * NacosConfig
 *
 * @author tony
 * @date 3/27/23
 */
@Configuration
@Slf4j
public class NacosConfig implements InitializingBean {

  @Resource
  private NacosCommonConfigListener nacosCommonConfigListener;
  @Resource
  private NacosConfigManager nacosConfigManager;

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("【info】开始设置自定义Nacos配置变更监听器...");
    nacosConfigManager.getConfigService().addListener("common.yaml", "common", nacosCommonConfigListener);
  }
}
