package com.hxq.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

//切面 包含所有增强代码
@Component("transactionmanager")
@Aspect
//@EnableAspectJAutoProxy
public class transactionmanager {
//   @Pointcut("execution(* com.hxq.service.*.*(..))")
    private void pt1(){};
    @Autowired
    private connection connection;

    @Before("pt1()")
    public void  begintransaction()
    {
        try {
            connection.getthreadcon().setAutoCommit(false);
            System.out.println("事务管理");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @AfterReturning("pt1()")
    public void  commit()
    {
        try {
            connection.getthreadcon().commit();
            System.out.println("事务管理");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @AfterThrowing("pt1()")
    public void  rollback()
    {
        try {
            connection.getthreadcon().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @After("pt1()")
    public void  release()
    {
        try {
            //此处的关闭只是将连接放回连接池中,该线程依然还有连接,所以需要将线程和连接解绑
            connection.getthreadcon().close();
            connection.removeconn();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
