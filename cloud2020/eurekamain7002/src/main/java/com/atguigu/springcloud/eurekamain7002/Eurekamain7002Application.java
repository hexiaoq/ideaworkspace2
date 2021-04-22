package com.atguigu.springcloud.eurekamain7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class Eurekamain7002Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekamain7002Application.class, args);
    }

}
