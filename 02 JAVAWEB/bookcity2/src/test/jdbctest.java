package test;

import DAO.impl.Daoimp;
import com.alibaba.druid.util.JdbcUtils;
import org.junit.Test;
import pojo.User;
import utils.jdbcutils;

import java.sql.Connection;
import java.sql.SQLException;

/*
*test包为进行测试使用,此类为测试jdbc使用
*@ 何小强
*/
public class jdbctest {
@Test
    public void test() throws SQLException {

    System.out.println(jdbcutils.getcon());

}
/*
*测试增加用户
*@ 何小强
*/
@Test
    public void test2(){
    User user1 = new User(3, "何小强", "123@qq.com","sdjfalfl");
    Daoimp dao = new Daoimp();
    dao.adduser(user1);
}
/*
*测试根据用户名查找用户
*@ 何小强
*/
@Test
    public void test3(){
    Daoimp dao = new Daoimp();
    User user2 = dao.querybyusername("何小强");
    System.out.println(user2);
}
}
