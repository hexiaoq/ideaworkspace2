import com.hxq.configtion.conf;
import com.hxq.dao.Accountdaoimp;
import com.hxq.domain.Account;
import com.hxq.factoty.proxyfactory;
import com.hxq.service.Accountimp;
import com.hxq.service.IAccount;
import com.hxq.service.account2imp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class daotest {
    proxyfactory factory;
    IAccount iAccount;
    Accountimp accountimp;
    Accountdaoimp accountdao;
    account2imp accountimp2;



    @Before
   public void test()
    {
        ApplicationContext ac=new AnnotationConfigApplicationContext(conf.class);
//     factory = ac.getBean("proxyfactory", proxyfactory.class);
//     iAccount=factory.getiAccount();
     accountdao=ac.getBean("Accountdaoimp",Accountdaoimp.class);
     accountimp=ac.getBean("Accountimp",Accountimp.class);
     accountimp2=ac.getBean("account2imp", account2imp.class);





    }
    @Test
    public void test2()
    {

        System.out.println(accountdao.findaccountbyname("aaa"));

    }
//    @Test
//    public void testtransfer()
//    {
//        iAccount.transfer("aaa","add",300);
//
//        System.out.println(iAccount.findall());
//    }
    @Test
    public void after()
    {    accountimp.update(new Account(3,"ccc", (float) 500));
        accountimp.transfer("aaa","add",300);


        System.out.println(accountimp.findall());
    }
}
