package com.ryytn.start.job;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 通用测试类，用于测试工具方法等
 *
 * @author tony
 * @date 3/10/23
 */
@Slf4j
public class CommonTests {

    @Test
    public void testHutoolNetUtil() {
        String localhostStr = NetUtil.getLocalhostStr();
        System.out.println(localhostStr);
    }

}
