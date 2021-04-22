package FactotyMethod;

/**
 * 测试工厂方法模式
 */
public class client {
    public static void main(String[] args) {
        car c1=new audifactory().produce();
        car c2=new bydfactory().produce();
        car c3=new benzifactory().produce();

        c1.run();
        c2.run();
        c3.run();
    }
}
