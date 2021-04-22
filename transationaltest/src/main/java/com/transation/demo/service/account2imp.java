package com.transation.demo.service;


import com.transation.demo.dao.dao;
import com.transation.demo.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class account2imp implements IAccount2 {

    @Autowired
    dao dao;

    @Transactional
    @Override
    public void update(Account account) {
        dao.update(account);
        account.setMoney(account.getMoney()-100);
        dao.update(account);


    }
}
