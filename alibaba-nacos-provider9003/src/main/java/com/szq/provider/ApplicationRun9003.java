package com.szq.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationRun9003 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun9003.class);
    }
}
