package com.szq.consumer.service;

import com.szq.entry.Payment;
import com.szq.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback =PaymentFallbackService.class )
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
   CommonResult<Payment> paymentSQL(@PathVariable(value = "id") Long id);
}
