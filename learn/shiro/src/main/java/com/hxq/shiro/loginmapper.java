package com.hxq.shiro;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface loginmapper {
@Select("select id,name,password,email from t_user where name=#{name} and password=#{password}")
User finduserbynameandpd(User user);

@Select("insert into t_user(name,password,email) values(#{name},#{password},#{email})")
    void add(User user);
@Select("select * from t_user where name=#{name}")
    User finduserbyname(String name);
@Select("select password from t_user where name=#{name}")
    String findpwbyname(String name);

}
