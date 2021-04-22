package com.transation.demo.service;


import com.transation.demo.dao.dao;
import com.transation.demo.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("Accountimp")
public class Accountimp implements IAccount {

    @Autowired
    com.transation.demo.dao.dao dao;




    public List<Account> findall() {
        return dao.findall();
    }



  @Transactional
    public void update(Account account) {
        dao.update(account);
    }





     @Transactional
    public void transfer(String sourcename, String targetname, float money) {
        this.update(new Account(3,"ccc", (float) 500));
                 Account source=dao.findaccountbyname(sourcename);
                 Account target=dao.findaccountbyname(targetname);

                 source.setMoney(source.getMoney()-money);
                 int i=10/0;
                 target.setMoney(target.getMoney()+money);

                 dao.update(source);

                 dao.update(target);

    }
}
