package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Storage;
import com.atguigu.springcloud.mapper.mymapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class storageservice {
    @Resource
    mymapper mymapper;

    public void decrease(Long productId, Integer count)
    {
        System.out.println("修改库存中");
        QueryWrapper<Storage> wrapper=new QueryWrapper<>();
        wrapper.ge("productId",productId);
        Storage storage = mymapper.selectOne(wrapper);
        mymapper.updateById(new Storage(storage.getId(),productId,storage.getTotal(),storage.getUsed()+count,storage.getResidue()-count));
        System.out.println("修改库存成功");
    }

}
