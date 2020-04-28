package com.szq.consumer.service.contoller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.szq.consumer.service.PaymentService;
import com.szq.entry.Payment;
import com.szq.result.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler ="blockHandler" )
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult<Payment> result=paymentService.paymentSQL(id);
        if(id==4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        }else if(result.getData()==null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }
    //本例是fallback
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }
    //本例是blockHandler
    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymetSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
