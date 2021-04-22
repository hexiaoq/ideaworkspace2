package com.atguigu.springcloud;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {
    @Bean
    @LoadBalanced
public RestTemplate gettemplate()
{
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate;

}

}
