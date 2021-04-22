package DAO;

import BEAN.customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class customerDAOimp extends BaseDAO implements  customerDAO {
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
       String sql="update customers set id=?,name=?,email=?,birth=?";
       update(conn, sql, cust.getId(),cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public customer getcustomerById(Connection conn, int id) {
        String sql="select id,name,email,birth from customers where id=?";
        customer cus = getInstance(conn, customer.class, sql, id);
        return cus;
    }

    @Override
    public List<customer> getAll(Connection conn) {
        String sql="select id,name,email,birth from customers ";
        List<customer> forList = getForList(conn, customer.class, sql);
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
}
