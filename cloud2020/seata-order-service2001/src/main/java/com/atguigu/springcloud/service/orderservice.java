package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.mapper.mymapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Slf4j
@Service
public class orderservice {
    @Resource
    private com.atguigu.springcloud.mapper.mymapper mymapper;
    @Resource
    private StorageService storageService;
//    @Resource
//    private AccountService accountService;

    @GlobalTransactional(name="hxq's ex",rollbackFor = Exception.class)
    public void creat(Order order)
    {
        log.info("开始创建订单");
        mymapper.insert(order);
        System.out.println(order);
        log.info("开始调用库存");
        storageService.decrease(order.getProductId(),order.getCount());

//        log.info("开始支付");
//        accountService.decrease(order.getUserId(),order.getMoney());

        UpdateWrapper<Order> wrapper=new UpdateWrapper<>();
        wrapper.eq("id",order.getId()).set("status",1);
       log.info("修改订单号");
        mymapper.update(order,wrapper);

        log.info("订单结束,完成一次交易,哈哈哈");



    }
}
