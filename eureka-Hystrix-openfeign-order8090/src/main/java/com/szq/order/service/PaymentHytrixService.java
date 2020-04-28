package com.szq.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "hystrix-payment")
public interface PaymentHytrixService {

    @GetMapping("/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);

}
