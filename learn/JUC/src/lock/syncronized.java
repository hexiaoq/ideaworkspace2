package lock;

public class syncronized {
    public static void main(String[] args) {
        ticket ticket1 = new ticket();
        new Thread(()->{for (int i = 0; i <50&&ticket.num>0 ; i++) ticket1.sale();},"A").start();
        new Thread(()->{for (int i = 0; i <50&&ticket.num>0 ; i++) ticket1.sale();},"B").start();
        new Thread(()->{for (int i = 0; i <50&&ticket.num>0 ; i++) ticket1.sale();},"C").start();


    }


}
class ticket{
    public static int  num=50;

    public synchronized void sale()
    {

            System.out.println(Thread.currentThread().getName()+"已卖出第"+num--+"张票"+"还剩"+num+"张票");
        try {
            this.wait(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
