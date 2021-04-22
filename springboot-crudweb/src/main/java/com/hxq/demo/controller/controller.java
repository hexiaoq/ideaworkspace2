package com.hxq.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello()
    {
        return "hello springboot";
    }
    @RequestMapping("/success")
    public String success()
    {
        return "success";
    }


}
