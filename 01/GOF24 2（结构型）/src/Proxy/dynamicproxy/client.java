package Proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class client {
    public static void main(String[] args) {
        star realstar=new realstar();
        starhandler handler=new starhandler(realstar);

        star proxy=(star)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{star.class},handler);//类加载器，所要实现的接口，处理器
        proxy.football();
    }
}
