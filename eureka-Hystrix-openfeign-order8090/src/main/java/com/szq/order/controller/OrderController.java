package com.szq.order.controller;

import com.szq.order.service.PaymentHytrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentHytrixService paymentHytrixService;

    @GetMapping("/order/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHytrixService.paymentInfo_OK(id);
    }

    @GetMapping("/order/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentHytrixService.paymentInfo_Timeout(id);
    }
}
