package com.hxq.service;


import com.hxq.dao.Iaccountdao;
import com.hxq.domain.Account;
import com.hxq.utils.connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class account2imp implements IAccount2 {
    @Autowired
    private com.hxq.utils.connection connection;
    @Autowired
    Iaccountdao dao;

    @Transactional
    @Override
    public void update(Account account) {
        dao.update(account);
        account.setMoney(account.getMoney()-100);
        dao.update(account);

        try {
            connection.getthreadcon().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
