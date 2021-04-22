package forkjoin;

import java.util.concurrent.RecursiveTask;

public class task extends RecursiveTask<Long> {
    private long being;
    private long end;
    public task(long begin,long end) {
        this.being=begin;
        this.end=end;
    }

    @Override
    protected Long compute() {
        long sum=0;
        if(end-being<10000)
        {
            for (long i = being; i <=end; i++) {
                sum=sum+i;



            }
            return sum;

        }
        else{long middle=(being+end)/2;
            task task1 = new task(being, middle);
            task1.fork();
            task task2= new task(middle+1,end);
            task2.fork();
            return task1.join()+task2.join();

        }

    }
}
