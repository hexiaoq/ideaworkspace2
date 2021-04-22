package singleton;

/**
 * 单例模式中的饿汉模式
 */

public class singleton1 {
private static singleton1  instance=new singleton1();
//类初始化时，立即加载对象，天然线程安全  但此对象可能用不到造成资源浪费（没有延时加载的优势）
    private singleton1(){};

    public static singleton1 getInstance(){
        return instance;
    }

}
