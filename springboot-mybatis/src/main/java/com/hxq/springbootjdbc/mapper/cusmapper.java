package com.hxq.springbootjdbc.mapper;

import com.hxq.springbootjdbc.pojo.cus;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface cusmapper {
    @Select("select * from customers")
    //当实体类中的的属性名和数据库中字段名不一致时可以使用以下方法对应
    @Results(id = "cusmap" ,value = {
            @Result(id=true,column = "id",property = "cusid"),
            @Result(column = "name",property = "cusname"),
            @Result(column = "email",property = "cusemail"),
    })
    List<cus> findall();

    //使用上一个方法的映射,避免代码重复冗余
    @ResultMap( "cusmap")
    @Select("select * from customers where id=#{id}")
    cus findbyid(int id);
}
