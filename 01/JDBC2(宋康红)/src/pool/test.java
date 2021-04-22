package pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class test {
    @Test
    public void test() {

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test?&rewriteBatchedStatements=true&characterEncoding=utf8&useSSL=false&serverTimezone = GMT");
        cpds.setUser("root");
        cpds.setPassword("156437734");
        System.out.println(cpds);


    }

    //方式二:配置文件
    @Test
    public void test2() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("F:\\idea workspace\\01\\JDBC2(宋康红)\\config.properties"));
        String url = properties.getProperty("url");
        String pwd = properties.getProperty("pwd");
        String user = properties.getProperty("user");
        String drive = properties.getProperty("drive");
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(drive); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        cpds.setJdbcUrl(url);
        cpds.setUser(user);
        cpds.setPassword(pwd);
        Connection conn = cpds.getConnection();

        System.out.println(conn);


    }

    //方式3 使用xml文件配置
    //不知道原因 不能使用
    @Test
    public void test3() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
    @Test
    public void test4() throws Exception {
        Properties pros = new Properties();

        pros.load(new FileInputStream("F:\\idea workspace\\01\\JDBC2(宋康红)\\src\\druid.properties"));

        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}