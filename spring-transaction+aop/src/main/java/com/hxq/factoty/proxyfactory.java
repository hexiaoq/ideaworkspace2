package com.hxq.factoty;

import com.hxq.service.IAccount;
import com.hxq.utils.transactionmanager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Service("proxyfactory")
public class proxyfactory {
    @Autowired
    private IAccount iAccount;

    @Autowired
    private transactionmanager managet;

    public final void setiAccount(IAccount iAccount) {
        this.iAccount = iAccount;
    }

    public final void  setManaget(transactionmanager managet) {
        this.managet = managet;
    }

    public IAccount  getiAccount() {
        return (IAccount)Proxy.newProxyInstance(iAccount.getClass().getClassLoader(), iAccount.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object reval=null;
                try {
                    managet.begintransaction();
                    reval=method.invoke(iAccount,args);
                    managet.commit();
                    return reval;
                } catch (Exception e) {
                    managet.rollback();
                    throw new RuntimeException(e);

                } finally {
                    managet.release();
                }
            }
        });
    }
}
