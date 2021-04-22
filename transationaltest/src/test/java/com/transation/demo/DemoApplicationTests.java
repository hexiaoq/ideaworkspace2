package com.transation.demo;

import com.transation.demo.domain.Account;
import com.transation.demo.service.Accountimp;
import com.transation.demo.service.account2imp;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    Accountimp accountimp;
   @Resource
    account2imp accountimp2;

    @Test
    void contextLoads() {

//        accountimp.update(new Account(3,"ccc", (float) 300));
       accountimp.transfer("aaa","add",300);

    }

}
