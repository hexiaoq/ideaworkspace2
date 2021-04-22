package com.hxq.springbootjdbc.controller;

import com.hxq.springbootjdbc.mapper.cusmapper;
import com.hxq.springbootjdbc.pojo.cus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class cuscon {
    @Autowired
    cusmapper cusmapper;

    @GetMapping("/findall")
    public List<cus> findall()
    {
        return cusmapper.findall();
    }
    @GetMapping("/find/{id}")
    public cus find(@PathVariable Integer id)
    {
        return cusmapper.findbyid(id);
    }

}
