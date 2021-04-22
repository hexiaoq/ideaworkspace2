package simpleFactory;

/**
 * 测试简单工厂模式下创建对象
 */
public class client {
    public static void main(String[] args) {
       car c1=factory.factory("奥迪") ;
       car c2=factory.factory("比亚迪");
       c1.run();
       c2.run();
    }
}
