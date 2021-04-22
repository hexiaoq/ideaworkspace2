package com.hxq.dao;

import com.hxq.configtion.conf;
import com.hxq.factoty.proxyfactory;
import com.hxq.service.Accountimp;
import com.hxq.service.IAccount;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    IAccount accountimp;
    @Test
    public void test()
    {
        ApplicationContext ac=new AnnotationConfigApplicationContext(conf.class);
        accountimp=(IAccount)ac.getBean("Accountimp");
        accountimp.transfer("aaa","add",300);
        System.out.println(accountimp.findall());
    }
}
