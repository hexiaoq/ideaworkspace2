package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lock {
    public static void main(String[] args) {
        ticket2 ticket1 = new ticket2();
        new Thread(()->{for (int i = 0; i <50&& ticket2.num>0 ; i++) ticket1.sale();},"A").start();
        new Thread(()->{for (int i = 0; i <50&& ticket2.num>0 ; i++) ticket1.sale();},"B").start();
        new Thread(()->{for (int i = 0; i <50&& ticket2.num>0 ; i++) ticket1.sale();},"C").start();

    }


}
class ticket2{
    public static int  num=50;
   Lock lock= new ReentrantLock();

    public  void sale()
    {lock.lock();


        try {
            System.out.println(Thread.currentThread().getName()+"已卖出第"+num--+"张票"+"还剩"+num+"张票");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

}
