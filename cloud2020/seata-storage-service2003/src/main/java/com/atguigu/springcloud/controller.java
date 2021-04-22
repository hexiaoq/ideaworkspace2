package com.atguigu.springcloud;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Storage;
import com.atguigu.springcloud.service.storageservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class controller {
    @Resource
    storageservice storageservice;

    @PostMapping("/storage/decrease")
    public CommonResult<Storage> decrease(Long productId, Integer count)
    {
   storageservice.decrease(productId,count);
        return new CommonResult<Storage>(200,"修改成功");
    }
}
