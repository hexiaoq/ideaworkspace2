package PC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @hxq
 * 使用lock锁实现顺序唤醒的生产者和消费者问题,精准通知某线程
 */
public class lockmethod {
    public static void main(String[] args) {
        pc pc=new pc();
        new Thread(()->{ for (int i = 0; i <10 ; i++) pc.produce1();},"A").start();
        new Thread(()->{for (int i = 0; i <10 ; i++) pc.produce2();},"B").start();
        new Thread(()->{for (int i = 0; i <10 ; i++) pc.consume();},"C").start();
    }

}
class pc{
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();
    private static int num=0;


    public void produce1()
    {
        lock.lock();
        try {
            while(num!=0)
            {
                condition1.await();
            }
            num=1;
            System.out.println(Thread.currentThread().getName()+"已生产,仓库剩余"+num);
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
    public void produce2()
    {
        lock.lock();
        try {
            while(num!=1)
            {
                condition2.await();
            }
            num=2;
            System.out.println(Thread.currentThread().getName()+"已生产,仓库剩余"+num);
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
    public void consume()
    {
        lock.lock();
        try {
            while(num!=2)
            {
                condition3.await();
            }
            num=0;
            System.out.println(Thread.currentThread().getName()+"已消费,仓库剩余"+num);
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }



}
