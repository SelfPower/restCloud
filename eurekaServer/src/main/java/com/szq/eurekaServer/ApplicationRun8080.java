package com.szq.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ApplicationRun8080 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8080.class);
    }
}
