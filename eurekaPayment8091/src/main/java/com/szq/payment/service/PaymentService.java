package com.szq.payment.service;

import com.szq.entry.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentbyId(@Param("id") Long id);
}
