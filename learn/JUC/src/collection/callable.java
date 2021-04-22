package collection;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 适配器模式的应用,使用callable创建线程
 */
public class callable {
    static int i=1;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask=new FutureTask(new mythread());
        new Thread(futureTask,"a").start();
        System.out.println(futureTask.get());

    }
}
class mythread implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception {
        System.out.println("新的线程调用");
        return 1024 ;
    }
}
