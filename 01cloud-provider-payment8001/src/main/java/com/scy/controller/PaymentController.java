package com.scy.controller;

import com.scy.entities.CommonResult;
import com.scy.entities.Payment;
import com.scy.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Scy
 * @Date 2020/9/10 20:01
 * @Version 1.0
 */
@Slf4j
@Api(tags = "Payment控制器")
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @ApiOperation("保存")
    @PostMapping("/payment/save")
    public CommonResult save(@ApiParam("支付") @RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info(payment.toString());
        log.info("======插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "数据插入成功！", result);
        } else {
            return new CommonResult(444, "数据插入失败！", null);
        }
    }

    @ApiOperation("根据id查询")
    @GetMapping("/payment/get/{id}")
    public CommonResult getById(@PathVariable("id") @ApiParam("ID") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("======查询结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功！", payment);
        } else {
            return new CommonResult(444, "没有查询记录，查询id：" + id, null);
        }
    }
}
