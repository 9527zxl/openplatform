package com.openplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OpenApiCacheApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenApiCacheApp.class,args);
    }
}
