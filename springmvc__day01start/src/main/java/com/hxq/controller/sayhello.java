package com.hxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sayhello {
    @RequestMapping("/sayhello")
    public String sayhello()
    {
        System.out.println("hello");
        return" success";
    }
}
