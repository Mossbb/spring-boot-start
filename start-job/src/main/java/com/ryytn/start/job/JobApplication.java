package com.ryytn.start.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tony
 * @since 2020-10-13
 */
@SpringBootApplication(scanBasePackages = "com.ryytn")
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }
}
