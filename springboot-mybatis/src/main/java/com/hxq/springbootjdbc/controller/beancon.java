package com.hxq.springbootjdbc.controller;

import com.hxq.springbootjdbc.mapper.Beanmapper;
import com.hxq.springbootjdbc.pojo.bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class beancon {
    @Autowired
    Beanmapper beanmapper;

    @GetMapping("/beanfindall")
    public List<bean> findall()
    {
        return beanmapper.findall();

    }
    @GetMapping("/insert/{name}/{password}/{address}/{phone}")
    public void insert(@PathVariable String name,@PathVariable String password,
    @PathVariable String address,@PathVariable String phone)
    {
        bean bean=new bean(0,name,password,address,phone);
        beanmapper.insert(bean);

    }



}
