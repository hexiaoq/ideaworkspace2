package singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程环境下测4个单例模式的效率
 * @何小强
 */

public class client4 {
    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();
        int threadnum=10;
       final CountDownLatch countDownLatch=new CountDownLatch(threadnum);

        for (int i = 0; i <threadnum; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    Object o = singleton1.getInstance();

                }
                countDownLatch.countDown();//当一个线程调用此方法，threadnum会自动减一直到为0
            }).start();}
            countDownLatch.await();//阻塞线程，直到计数为0
            long end = System.currentTimeMillis();

            System.out.println("总耗时"+(end-start));


    }
}
