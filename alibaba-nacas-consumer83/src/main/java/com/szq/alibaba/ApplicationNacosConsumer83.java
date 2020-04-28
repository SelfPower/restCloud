package com.szq.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationNacosConsumer83 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationNacosConsumer83.class);
    }
}
