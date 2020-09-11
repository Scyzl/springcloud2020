package com.scy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Scy
 * @Date 2020/9/11 10:09
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer     // 配置 Eureka Server
public class EurekaServerMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7001.class, args);
    }
}
