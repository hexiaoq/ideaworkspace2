package singleton;

import java.io.Serializable;

/**
 * 单例模式中的静态内部类模式
 */

public class singleton3 implements Serializable {//为实现反序列化所加接口 ，可删除
    private static  class is{
        private static final singleton3 instance=new singleton3();
    };//使用静态内部类，类初始化时不会立即加载对象（延时加载）


    private singleton3(){};
    public static singleton3 getInstance(){

        return is.instance;
    }

}
