import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class fun implements Runnable
{

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0)
                System.out.println(i+"----"+Thread.currentThread().getName());
        }
    }
}

public class threadpool {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(10);
        service.submit(new fun());
        service.submit(new fun());

//        List list=new ArrayList();
//        list.add(1);
//        list.add(3);
//        list.add(6);
//        list.replaceAll(-);
        ArrayList list=new ArrayList<>();


    }
}
