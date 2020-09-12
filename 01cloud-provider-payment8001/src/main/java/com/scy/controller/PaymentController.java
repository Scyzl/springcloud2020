package com.scy.controller;

import com.scy.entities.CommonResult;
import com.scy.entities.Payment;
import com.scy.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @ApiOperation("保存")
    @PostMapping("/payment/save")
    public CommonResult save(@ApiParam("支付") @RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info(payment.toString());
        log.info("======插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "数据插入成功！serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "数据插入失败！serverPort: " + serverPort, null);
        }
    }

    @ApiOperation("根据id查询")
    @GetMapping("/payment/get/{id}")
    public CommonResult getById(@PathVariable("id") @ApiParam("ID") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("======查询结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功！serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有查询记录，查询id：" + id + "，serverPort: " + serverPort, null);
        }
    }

    @ApiOperation("查看服务清单列表")
    @GetMapping("/payment/discovery")
    public Object discovery() {
        // 获取服务清单列表
        List<String> services = discoveryClient.getServices();      // get all known service IDs
        for (String service : services) {
            log.info("======service: " + service);
            // 获得服务的信息
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("======" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
            }
        }

        return this.discoveryClient;
    }

    @ApiOperation("模拟耗时复杂业务")
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }
}
