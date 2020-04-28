package com.szq.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationRunSentinelSevice8401 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunSentinelSevice8401.class);
    }
}
