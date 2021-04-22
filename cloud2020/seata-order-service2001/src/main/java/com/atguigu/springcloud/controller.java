package com.atguigu.springcloud;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.orderservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class controller {
    @Resource
    orderservice orderservice;

    @GetMapping("/order/creat")
    public CommonResult<Order> creat(Order order)
    {
        orderservice.creat(order);
        return new CommonResult<Order>(200,"创建成功",order);
    }
}
