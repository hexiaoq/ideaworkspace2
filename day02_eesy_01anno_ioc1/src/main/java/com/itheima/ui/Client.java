package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl2;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *

     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\zhy\\Desktop\\bean.xml");
        //2.根据id获取Bean对象
        AccountServiceImpl as  = (AccountServiceImpl) ac.getBean("accountService");
        AccountDaoImpl2 ad=(AccountDaoImpl2)ac.getBean("accountDao2") ;
        System.out.println(as);
        System.out.println(ad);
        as.saveAccount();
        System.out.println(as.accountDao);




        //--------BeanFactory----------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as  = (IAccountService)factory.getBean("accountService");
//        System.out.println(as);
    }
}
