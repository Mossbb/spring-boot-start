package com.ryytn.start.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yinxin
 * @since 2020-10-13
 */
@SpringBootApplication(scanBasePackages = "com.ryytn")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
