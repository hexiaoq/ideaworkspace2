package com.transation.demo.dao;

import com.transation.demo.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface dao {
    @Select("select * from account")
    public List<Account> findall();

   @Update("update account set name=#{name},money=#{money} where id=#{id} ")
    public void update(Account account);
    @Select("select * from account where name=#{name}")
    public Account findaccountbyname(String name);

}
