package com.hxq.utils;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


//这个就是切面
@EnableAspectJAutoProxy
@Component("logger")
@Aspect
public class logger {
    //该注解指定哪些方法需要被增强
    @Pointcut("execution(* com.hxq.service.*.*(..))")
    private void pt1(){};
//    @Pointcut("execution(* com.hxq.service.*.*(..))")
//    private void pt2(){
//
//    };

    //增强代码
    @Before("pt1()")
    public void log()
    {
        System.out.println("执行方法前记录日志");
    }

    @After("pt1()")
    public void log2(){
        System.out.println("执行方法后销毁日志");
    }
}
