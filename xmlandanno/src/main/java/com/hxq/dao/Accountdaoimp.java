package com.hxq.dao;

import com.hxq.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Repository("Accountdaoimp")
public class Accountdaoimp implements Iaccountdao {

    @Autowired
JdbcTemplate jdbcTemplate;




    public List<Account> findall() {
        try {
            return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account findbyid(Integer id) {
        try {
            return jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),id).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Account account) {
        try {
            jdbcTemplate.update("update account set name=?,money=? where id=? ",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Integer id) {
        try {
            jdbcTemplate.update("delete from account  where id=? ",id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addaccount(Account account) {
        try {
            jdbcTemplate.update("insert into account(id,name,money) values (?,?,?)",account.getId(),account.getName(),account.getMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Account findaccountbyname(String name) {
        try {
            return jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), name).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
