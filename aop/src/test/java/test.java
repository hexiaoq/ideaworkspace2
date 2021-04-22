import com.hxq.service.Account;
import com.hxq.service.Iaccount;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    Iaccount account;

    @Before
    public void before()
    {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        account=(Iaccount) ac.getBean("Account");

    }
   @Test
    public void test()
    {
        account.saveaccount();
        account.addaccount();
        account.updateaccount(1);

    }
}
