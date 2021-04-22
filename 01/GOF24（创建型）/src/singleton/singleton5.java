package singleton;

/**
 * 单例模式中的饿汉模式 并防止反射破解
 */

public class singleton5 {
private static singleton5 instance=new singleton5();
//类初始化时，立即加载对象，天然线程安全  但此对象可能用不到造成资源浪费（没有延时加载的优势）
    private singleton5(){
        if(instance!=null)
            throw new RuntimeException();//一旦instance被建立 就无法再建立新的instance对象；
    };

    public static singleton5 getInstance(){
        return instance;
    }

}
