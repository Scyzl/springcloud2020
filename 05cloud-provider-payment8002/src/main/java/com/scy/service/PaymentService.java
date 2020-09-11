package com.scy.service;

import com.scy.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Scy
 * @Date 2020/9/10 17:24
 * @Version 1.0
 */
public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
