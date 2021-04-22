package DAO;

import BEAN.customer;

import java.sql.Connection;

class customerDAOimpTest {
   customerDAOimp dao= new customerDAOimp();

    @org.junit.jupiter.api.Test
    void insert() {

    }

    @org.junit.jupiter.api.Test
    void deleteById() {
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void getcustomerById() throws Exception {DAO.customerDAOimp imp=new DAO.customerDAOimp();
     Connection conn = jdbcutil.jdbcutil.setcon3();
     customer customer = dao.getcustomerById(conn, 21);
     System.out.println(customer);
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }

    @org.junit.jupiter.api.Test
    void getCount() {
    }

    @org.junit.jupiter.api.Test
    void getMaxBirth() {
    }
}