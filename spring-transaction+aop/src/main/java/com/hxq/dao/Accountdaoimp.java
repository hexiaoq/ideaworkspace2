package com.hxq.dao;

import com.hxq.domain.Account;
import com.hxq.utils.connection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("Accountdaoimp")
public class Accountdaoimp implements Iaccountdao {

    @Autowired
   private QueryRunner runner;

    @Autowired
    private connection connection;


    public List<Account> findall() {
        try {
            return runner.query(connection.getthreadcon(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account findbyid(Integer id) {
        try {
            return runner.query(connection.getthreadcon(),"select * from account where id=?",new BeanHandler<Account>(Account.class),id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Account account) {
        try {
            runner.update(connection.getthreadcon(),"update account set name=?,money=? where id=? ",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Integer id) {
        try {
            runner.update(connection.getthreadcon(),"delete from account  where id=? ",id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addaccount(Account account) {
        try {
            runner.update(connection.getthreadcon(),"insert into account(id,name,money) values (?,?,?)",account.getId(),account.getName(),account.getMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Account findaccountbyname(String name) {
        try {
            return runner.query(connection.getthreadcon(),"select * from account where name=?", new BeanHandler<Account>(Account.class), name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
