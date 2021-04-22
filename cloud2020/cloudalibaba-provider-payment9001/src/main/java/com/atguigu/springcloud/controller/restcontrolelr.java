package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restcontrolelr {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/nacos/{id}")
    public String get(@PathVariable("id") Integer id)
    {
        return "你好啊!nacos"+id+"\t"+port;
    }

}
