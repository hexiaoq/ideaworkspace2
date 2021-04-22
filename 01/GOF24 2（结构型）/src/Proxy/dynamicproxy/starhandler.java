package Proxy.dynamicproxy;
/**
 *动态代理
 * 固定套路，照抄把
 *@何小强
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class starhandler implements InvocationHandler {
    star realstar;

    public starhandler(star realstar) {
        this.realstar = realstar;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("真正的方法执行之前");
        System.out.println("签合同，安排时间");
        method.invoke(realstar,args);
        System.out.println("收钱");
        return null;

    }
}
