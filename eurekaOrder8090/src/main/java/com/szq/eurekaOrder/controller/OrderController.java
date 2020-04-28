package com.szq.eurekaOrder.controller;

import com.szq.entry.Payment;
import com.szq.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://localhost:8091";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "payment/discovery")
    public Object discovery(){
        List<String> services=discoveryClient.getServices();
        for(String element : services){
            log.info("********element:"+element);
        }

        List<ServiceInstance> instances=discoveryClient.getInstances("eurekaPayment8091");
        for(ServiceInstance instance :instances){
            log.debug(instance.getServiceId()+"\t"+instance.getPort()+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/order/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("沈志强=========");
        return restTemplate.postForObject(PAYMENT_URL+"payment/create",payment,CommonResult.class);
    }

}
