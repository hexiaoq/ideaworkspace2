package com.atguigu.springcloud;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class controller {
    @Value("${config.info}")
    private String port;

    @GetMapping("/getinfo")
    public String getinfo()
    {
        return "端口号:"+port;
    }

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey")
    public String hotkey(@RequestParam(value = "p1", required=false)String p1,
                         @RequestParam(value = "p2",required = false) String p2){
        return "执行成功"+p1+" "+p2;

    }

}
