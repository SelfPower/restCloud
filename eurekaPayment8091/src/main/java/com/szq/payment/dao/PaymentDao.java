package com.szq.payment.dao;

import com.szq.entry.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentbyId(@Param("id") Long id);
}
