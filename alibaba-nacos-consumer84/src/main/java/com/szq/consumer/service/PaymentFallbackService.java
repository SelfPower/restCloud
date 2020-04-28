package com.szq.consumer.service;

import com.szq.entry.Payment;
import com.szq.result.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"调用链路失败！！--PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
