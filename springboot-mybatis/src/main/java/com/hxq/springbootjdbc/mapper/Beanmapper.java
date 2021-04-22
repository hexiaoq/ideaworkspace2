package com.hxq.springbootjdbc.mapper;

import com.hxq.springbootjdbc.pojo.bean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示这是mybatis的mapper类
@Mapper
@Repository
public interface Beanmapper {
    @Select("select * from user")
    //下列语句为一对一,即用一个表中的字段值去另一个表中查,相当于左外连接
    @Results(value = {
            @Result(id=true,column = "id",property = "id"),
            //pro后填要查的成员属性,col后是通过哪个属性去另一个表中查,select后为另一个表相对应的查询方法
            @Result(property = "customer",column = "id",one=@One(select = "com.hxq.dao.cusdao.findbyid",fetchType = FetchType.EAGER))
    })
    List<bean> findall();

    @Insert("insert into user(name,password,address,phone) values(#{name},#{password},#{address},#{phone})")
    void insert(bean user);
}
