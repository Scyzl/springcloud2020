package com.scy.controller;

import com.scy.entities.CommonResult;
import com.scy.entities.Payment;
import com.scy.service.PaymentFeignService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Scy
 * @Date 2020/9/12 15:56
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @ApiOperation("根据id查询")
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        return paymentFeignService.getById(id);
    }

    @ApiOperation("调用超时业务")
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon: 客户端一般默认等待1s
        return paymentFeignService.paymentFeignTimeout();

    }
}
