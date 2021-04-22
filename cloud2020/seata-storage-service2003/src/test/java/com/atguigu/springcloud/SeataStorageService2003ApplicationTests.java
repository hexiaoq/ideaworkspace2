package com.atguigu.springcloud;

import com.atguigu.springcloud.mapper.mymapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SeataStorageService2003ApplicationTests {
    @Resource
com.atguigu.springcloud.mapper.mymapper mymapper;
    @Test
    void contextLoads() {
        System.out.println(mymapper.selectById(1));
    }

}
