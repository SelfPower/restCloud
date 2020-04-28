package com.szq.consumer.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationRunConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunConsumer8802.class);
    }
}
