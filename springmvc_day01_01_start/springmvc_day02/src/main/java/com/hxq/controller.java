package com.hxq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
@Controller("controller")
public class controller {
    @RequestMapping("test")
    public String test()
    {
        System.out.println("执行方法成功");
        return "success";
    }

}
