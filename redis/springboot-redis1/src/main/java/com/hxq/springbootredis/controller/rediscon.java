package com.hxq.springbootredis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxq.springbootredis.pojo.person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class rediscon {
    @RequestMapping("/redis")
    @ResponseBody
    public String redis() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String s = objectMapper.writeValueAsString(new person("hxq", 11, "nan"));

        return   s;
    }
}
