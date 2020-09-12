package com.scy.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Scy
 * @Date 2020/9/10 22:03
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced       // 配置负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
