import com.hxq.service.Accountimp;
import com.hxq.service.IAccount;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test()
    {
        IAccount account;
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
                account=  ac.getBean("Accountimp",IAccount.class);
                account.transfer("aaa","add",200f);

    }
}
