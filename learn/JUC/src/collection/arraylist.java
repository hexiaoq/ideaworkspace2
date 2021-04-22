package collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/**
 * 不安全的list实现  和解决方法
 */
public class arraylist {
    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();       //不安全
//        List<String> list=new Vector<>();
//        List<String> list=Collections.synchronizedList();
        CountDownLatch countDownLatch=new CountDownLatch(200);
        List<String> list=new CopyOnWriteArrayList<>();
        long time1=System.currentTimeMillis();
        for (int i = 0; i <200; i++) {
            new Thread(()->{list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list.size());
                countDownLatch.countDown();

            }).start();

        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long time2 = System.currentTimeMillis();
            System.out.println("耗时" + (time2 - time1));




    }
}
