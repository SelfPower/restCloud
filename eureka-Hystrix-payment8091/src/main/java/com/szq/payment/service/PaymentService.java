package com.szq.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 提供两个方法
 *  正常访问
 *  延时访问
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   OK  "+id+"  哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
        int timeNumber=3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池： "+Thread.currentThread().getName()+"  Timeout: "+timeNumber+" 秒 "+id;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "调用支付接口超时或异常+ 线程池名："+Thread.currentThread().getName();
    }
}
