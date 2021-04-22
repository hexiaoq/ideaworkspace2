package locks8;

/**
 * static方法的synchoronized锁的是Class类的当前类对象,所以即使方法的调用者是两个不同的对象,也是同一把锁
 * 此外两个普通方法的锁也是同一把锁,当调用a方法获得锁时,调用b方法需要等待锁的释放
 */
public class staticlock {
    public static void main(String[] args) {
        phone phone1=new phone();
        phone phone2=new phone();
        new Thread(()->{phone1.sendms();},"a").start();
        new Thread(()->{phone2.call();},"b").start();
    }
}
class phone{
    public static synchronized void sendms()
    { try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        System.out.println(Thread.currentThread().getName()+"发短信");

    }
    public static synchronized void call()

    {
        System.out.println(Thread.currentThread().getName()+"打电话");
    }
}
