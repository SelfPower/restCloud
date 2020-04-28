package com.szq.eurekaOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationRun8090 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8090.class);
    }
}
