package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Storage;
import com.atguigu.springcloud.mapper.mymapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class storageservice {
    @Resource
    mymapper mymapper;

    public void decrease(Long productId, Integer count)
    {
        System.out.println("修改库存中");

        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Storage storage= mymapper.selectById(productId);
        mymapper.updateById(new Storage(storage.getId(),productId,storage.getTotal(),storage.getUsed()+count,storage.getResidue()-count));
        System.out.println("修改库存成功");
    }

}
