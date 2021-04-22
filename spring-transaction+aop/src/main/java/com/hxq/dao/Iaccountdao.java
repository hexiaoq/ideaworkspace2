package com.hxq.dao;

import com.hxq.domain.Account;

import java.util.List;

public interface Iaccountdao {
    public List<Account> findall();

    public Account findbyid(Integer id);

    void update(Account account);

    void delete(Integer id);

    void addaccount(Account account);

    Account findaccountbyname(String name);

}
