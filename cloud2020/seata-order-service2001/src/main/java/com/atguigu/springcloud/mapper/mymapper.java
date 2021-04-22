package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
public interface mymapper extends BaseMapper<Order> {

}
