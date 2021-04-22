package com.atguigu.springcloud;

import com.atguigu.springcloud.mapper.mymapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SeataOrderService2001ApplicationTests {
    @Resource
    private mymapper mymapper;

    @Test
    void contextLoads() {
        System.out.println(mymapper.selectById(12));
    }

}
