package com.scy.dao;

import com.scy.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Scy
 * @Date 2020/9/10 17:09
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
