package com.hxq.service;

import com.hxq.dao.Iaccountdao;
import com.hxq.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("Accountimp")
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
public class Accountimp implements IAccount {

    @Autowired
    Iaccountdao dao;



    public List<Account> findall() {
        return dao.findall();
    }

    public Account findbyid(Integer id) {
        return dao.findbyid(id);
    }

    public void update(Account account) {
        dao.update(account);
    }

    public void delete(Integer id) {
        dao.delete(id);

    }

    public void addaccount(Account account) {
         dao.addaccount(account);
    }


    //需要的是读写型事务配置
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public void transfer(String sourcename, String targetname, float money) {
                 Account source=dao.findaccountbyname(sourcename);
                 Account target=dao.findaccountbyname(targetname);

                 source.setMoney(source.getMoney()-money);
                 target.setMoney(target.getMoney()+money);

                 dao.update(source);
                 dao.update(target);

    }
}
