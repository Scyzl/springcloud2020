package com.scy.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author Scy
 * @Date 2020/9/12 9:21
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @ApiOperation("业务模拟")
    @RequestMapping("/payment/consul")
    public String paymentConsul() {
        return "Spring Cloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
