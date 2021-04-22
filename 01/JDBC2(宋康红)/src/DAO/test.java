package DAO;

import BEAN.customer;
import jdbcutil.jdbcutil;

import java.sql.Connection;
import java.util.List;

/**
 *测试customers的封装的DAO方法
 *@何小强
 */
public class test {
    public static void main(String[] args) throws Exception {
        customerDAOimp imp=new customerDAOimp();
        Connection conn = jdbcutil.setcon();
        List<customer> list = imp.getAll(conn);
        list.forEach(System.out::println);

    }
}
