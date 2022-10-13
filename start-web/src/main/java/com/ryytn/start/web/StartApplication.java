package com.ryytn.start.web;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;

/**
 * @author yinxin
 * @since 2020-10-13
 */
@SpringBootApplication(scanBasePackages = "com.ryytn",
        exclude = {DataSourceAutoConfiguration.class,
                DruidDataSourceAutoConfigure.class,
                TransactionAutoConfiguration.class})
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
