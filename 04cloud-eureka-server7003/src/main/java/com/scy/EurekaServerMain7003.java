package com.scy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Scy
 * @Date 2020/9/11 16:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7003.class, args);
    }
}
