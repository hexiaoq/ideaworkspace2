package singleton;

/**
 * 单例模式中的懒汉模式
 */

public class singleton2 {
private static singleton2 instance;
//类初始化时，不立即加载对象 （延时加载的优势）
    private singleton2(){};//私有构造器
    public static synchronized singleton2 getInstance(){//synchronized保证线程安全，但这样调用效率低
        if(null==instance)
            instance=new singleton2();

        return instance;
    }

}
