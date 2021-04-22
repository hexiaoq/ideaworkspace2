package observer;
/**
 *观察者模式  利用jdk提供的父类和接口 便捷实现
 * subject为博主发布内容,observer作为订阅者(观察者)接收到subject做出的改变
 *@何小强
 */

public class client {
    public static void main(String[] args) {
        subject s=new subject();
        observer o1=new observer();
        observer o2=new observer();
        observer o3=new observer();
        s.addObserver(o1);
        s.addObserver(o2);
        s.addObserver(o3);

        s.setState(100);

        o1.getMystate();
        o2.getMystate();
        o3.getMystate();

    }



}
