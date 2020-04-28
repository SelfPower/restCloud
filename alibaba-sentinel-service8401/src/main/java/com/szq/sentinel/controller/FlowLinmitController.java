package com.szq.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLinmitController {
    /**
     * Qps为1内成功访问
     * @return
     */
    @GetMapping("/testA")
    public String testA(){
        return "____testA";
    }

    @GetMapping("/testB")
    @SentinelResource(value = "testB",blockHandler = "test_Handler")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"...哈哈testB");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "______testB";
    }
    @GetMapping("/testC")
    public String testC(){
        return "____testC";
    }
    @GetMapping("/testD")
    public String testD(){
        return "____testD";
    }
    @GetMapping("/testE")
    public String testE(){
        return "____testE";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealtest_Handler")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "-------testHotKey哈哈哈";
    }

    public String dealtest_Handler(String p1, String p2, BlockException e) {
        return "-------testHotKey_______error"+e.getMessage();
    }

    public String test_Handler(BlockException e){
        return "操作失败,"+e.getMessage();
    }

}
