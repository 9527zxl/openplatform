package com.openplatform.webmaster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.openplatform.webmaster.mapper")
public class OpenApiWebMasterApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenApiWebMasterApp.class,args);
    }
}
