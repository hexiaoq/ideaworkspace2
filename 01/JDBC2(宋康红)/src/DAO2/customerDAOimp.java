package DAO2;

import BEAN.customer;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class customerDAOimp extends BaseDAO<customer> implements customerDAO {

    @Override
    public void insert(Connection conn, customer cust) {
      String sql="insert into customers set id=?,name=?,email=?,birth=?";
      update(conn, sql, cust.getId(),cust.getName(), cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
     String sql="delete from customers where id=?";
     update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, customer cust) {
       String sql="update customers set name=?,email=?,birth=? where id=?";
       update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth(), cust.getId());
    }

    @Override
    public customer getcustomerById(Connection conn, int id) {
        String sql="select id,name,email,birth from customers where id=?";
        customer cus = getInstance(conn,  sql, id);
        return cus;
    }

    @Override
    public List<customer> getAll(Connection conn) {
        String sql="select id,name,email,birth from customers ";
        List<customer> forList = getForList(conn, sql);
        return forList;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql="select count(*) from customers where id>? ";
        long l=getValue(conn, sql);
        return l;

    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql="select max(birth) from customers ";
        Date l=getValue(conn, sql);
        return  l;

    }
    @Test
    public void test() throws Exception {
        DAO2.customerDAOimp imp=new DAO2.customerDAOimp();
        Connection conn = jdbcutil.jdbcutil.setcon();
        List<customer> list = imp.getAll(conn);
        list.forEach(System.out::println);
    }
}
