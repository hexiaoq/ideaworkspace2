package com.transation.demo.service;



import com.transation.demo.domain.Account;

import java.util.List;

public interface IAccount {
    public  List<Account> findall();



    void update(Account account);





    void transfer(String source,String target,float money);


}
