package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//手写自旋锁,实现简易ribbon
@Component
public class lbimp implements loadBlance{
    private AtomicInteger atomicInteger =new AtomicInteger(0);

    private final int increasment()
    {
        int current;
        int expect;
        do{
           current= atomicInteger.get();
           expect=current+1;

        }
        while (!atomicInteger.compareAndSet(current,expect));
        System.out.println("访问次数"+expect);
        return atomicInteger.get();


    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index=increasment()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
