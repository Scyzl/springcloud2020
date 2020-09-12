package com.scy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2     // 开启swagger2
public class SwaggerConfig {

    // 配置Swagger的Docket的实例
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        // 获取项目的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Scy")
                .enable(flag)
                .select()
                // RequestHandlerSelectors: 配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.scy.controller"))
                // PathSelectors: 路径选择器，选择扫描antPattern的接口
//                .paths(PathSelectors.ant("/scy/**"))
                .build();
    }


    // 配置swagger的apiInfo信息
    private ApiInfo apiInfo() {

        Contact contact = new Contact("Scy", "https://blog.scy.com", "111.qq.com");
        return new ApiInfo(
                "Swagger-Api 文档",
                "api文档",
                "1.0",
                "https://blog.scy.com",
                contact,
                "Apache 2.0",
                "http://apache.org",
                new ArrayList()
        );
    }
}
