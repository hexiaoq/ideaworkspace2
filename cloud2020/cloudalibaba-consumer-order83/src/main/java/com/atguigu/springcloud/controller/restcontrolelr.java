package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class restcontrolelr {
    @Value("${service-url.nacos-user-service}")
    private String url;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String get(@PathVariable("id") Integer id)
    {
        return restTemplate.getForObject(url+"/payment/nacos/"+id,String.class);
    }

}
