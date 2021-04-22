package com.hxq.service;

import com.hxq.domain.Account;

import java.util.List;

public interface IAccount {
    public  List<Account> findall();

    public Account findbyid(Integer id);

    void update(Account account);

    void delete(Integer id);

    void addaccount(Account account);

    void transfer(String source,String target,float money);


}
