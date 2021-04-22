package com.hxq.service;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("Account")
public class Account implements Iaccount {
    public void saveaccount() {
        System.out.println("执行了保存方法");
    }

    public void updateaccount(int i) {
        System.out.println("执行了更新方法");

    }

    public int addaccount() {
        System.out.println("执行了添加账号的方法");
        return 0;
    }
}
