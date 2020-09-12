package com.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Scy
 * @Date 2020/9/12 14:01
 * @Version 1.0
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();        // 随机访问
    }

}
