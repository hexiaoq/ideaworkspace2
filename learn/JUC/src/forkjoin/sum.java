package forkjoin;

import java.util.stream.LongStream;
//结论:对于两核的电脑还是最原始的方式一效率高 >.< 很是无奈

public class sum {
    public static void main(String[] args) {
        long begin=0;
        long end= 10000000000L;
        long t1=System.currentTimeMillis();
long sum=0;
        for (long i = begin; i <=end ; i++) {
            sum=sum+i;


        }


        System.out.println(sum);
//        方式1 -5340232216128654848
//6298

//        task task = new task(begin,end);
//        System.out.println(task.compute());
        //方式二 -5340232216128654848
        //12474

//        System.out.println(LongStream.rangeClosed(begin, end).parallel().reduce(0,Long::sum));
//        方式三 -5340232216128654848
//6446
        long t2=System.currentTimeMillis();
        System.out.println(t2 - t1);

    }
}
