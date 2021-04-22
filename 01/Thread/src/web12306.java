public class web12306 {
    public static void main(String[] args) {
        websystem system=new websystem();
        new Thread(system,"何小强").start();
        new Thread(system,"熊昊宇").start();
        new Thread(system,"熊昊辰").start();
    }
}
class websystem implements Runnable{
public boolean flag=true;
public int ticketnum=100;
    @Override
    public void run() {
        while(flag)
        {
           buyticket();
        }




    }
    public void buyticket(){

      synchronized (this) {if(ticketnum<=0)
        {
            flag=false;
            System.out.println("票已售空");
            return;
        }
        else
        {
            ticketnum--;
            System.out.println(Thread.currentThread().getName()+"抢票成功"+"------>"+"当前余票为"+ticketnum);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
}