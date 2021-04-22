package com.hxq.dao;

import com.hxq.configtion.conf;
import com.hxq.service.IAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = conf.class)
public class managertest {
    IAccount iAccount;
    @Test
    public void test()
    {
        ApplicationContext ac=new AnnotationConfigApplicationContext(conf.class);
        iAccount= (IAccount)ac.getBean("Accountimp");
        iAccount.transfer("aaa","add",300);

    }

}
