package com.scy.controller;

import com.scy.entities.CommonResult;
import com.scy.entities.Payment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Scy
 * @Date 2020/9/10 21:54
 * @Version 1.0
 */
@Slf4j
@Api(tags = "Order控制器")
@RestController
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";       // 单机版
public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SEVICE";     // 集群版

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation("保存")
    @PostMapping("/consumer/payment/save")
    public CommonResult<Payment> save(Payment payment) {
        log.info(payment.toString());
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
