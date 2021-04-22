package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.MessageProviderImpl;
import com.atguigu.springcloud.service.service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class sendmessagecontroller {
    @Resource
    MessageProviderImpl service;

    @GetMapping("/sendmessage")
    public String send()
    {
       return service.send();
    }
}
