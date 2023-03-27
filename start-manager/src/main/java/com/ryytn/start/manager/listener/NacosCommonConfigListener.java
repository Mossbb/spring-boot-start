package com.ryytn.start.manager.listener;

import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.nacos.api.config.ConfigChangeEvent;
import com.alibaba.nacos.client.config.listener.impl.AbstractConfigChangeListener;
import java.util.concurrent.Executor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * NacosConfigListener
 *
 * @author tony
 * @date 3/27/23
 */
@Component
@Slf4j
public class NacosCommonConfigListener extends AbstractConfigChangeListener {

  @Override
  public Executor getExecutor() {
    return ThreadUtil.newFixedExecutor(4, "nacos-common-config-listener-",
      true);
  }

  @Override
  public void receiveConfigChange(ConfigChangeEvent event) {
    event.getChangeItems().forEach(
      configChangeItem -> log.info("【key】{}【old】{}【new】{}", configChangeItem.getKey(),
        configChangeItem.getOldValue(),
        configChangeItem.getNewValue()));
  }

}
