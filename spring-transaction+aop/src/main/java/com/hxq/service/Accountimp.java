package com.hxq.service;

import com.hxq.dao.Iaccountdao;
import com.hxq.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Queue;

@Service("Accountimp")
public class Accountimp implements IAccount {

    @Autowired
    Iaccountdao dao;




    public List<Account> findall() {
        return dao.findall();
    }

    public Account findbyid(Integer id) {
        return dao.findbyid(id);
    }

    @Transactional
    public void update(Account account) {
        dao.update(account);
    }

    public void delete(Integer id) {
        dao.delete(id);

    }

    public void addaccount(Account account) {
         dao.addaccount(account);
    }

     @Transactional
    public void transfer(String sourcename, String targetname, float money) {
                 Account source=dao.findaccountbyname(sourcename);
                 Account target=dao.findaccountbyname(targetname);

                 source.setMoney(source.getMoney()-money);
                 int i=10/0;
                 target.setMoney(target.getMoney()+money);

                 dao.update(source);

                 dao.update(target);

    }
}
