package DAO2;

import BEAN.customer;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

class customerDAOimpTest {
   DAO2.customerDAOimp dao= new customerDAOimp();

    @org.junit.jupiter.api.Test
    void insert() throws Exception { DAO.customerDAOimp imp=new DAO.customerDAOimp();
     Connection conn = jdbcutil.jdbcutil.setcon();
     customer customer = new customer(23,"三上悠亚",null,"123@qq.com");
     dao.insert(conn,customer );

    }

    @org.junit.jupiter.api.Test
    void deleteById() throws Exception {
     Connection conn = jdbcutil.jdbcutil.setcon();

     dao.deleteById(conn, 23);

    }

    @org.junit.jupiter.api.Test
    void update() throws Exception {

     Connection conn = jdbcutil.jdbcutil.setcon3();
     customer customer = new customer(21,"三上",null,"123@qq.com");
     dao.update(conn, customer);
     Thread.sleep(15000);
    }

    @org.junit.jupiter.api.Test
    void getcustomerById() throws Exception {

     Connection conn = jdbcutil.jdbcutil.setcon2();
     customer customer = dao.getcustomerById(conn, 21);
     System.out.println(customer);
     Thread.sleep(15000);

    }

    @org.junit.jupiter.api.Test
    void getAll() throws Exception {
     Connection conn = jdbcutil.jdbcutil.setcon3();
     List<customer> list = dao.getAll(conn);
     list.forEach(System.out::println);
     Thread.sleep(15000);
    }

    @org.junit.jupiter.api.Test
    void getCount() {
    }

    @org.junit.jupiter.api.Test
    void getMaxBirth() {
    }
    @Test
 public boolean isAdditiveNumber(String num) {
  int len = num.length();
  if (len < 3) {
   return false;
  }
  int lenOfFirst = 1;
  int lenOfSecond = 1;
  while (lenOfFirst <= len / 2) {
   String strFirst = num.substring(0, lenOfFirst);
   if (lenOfFirst > 1 && strFirst.startsWith("0")) {
    break;
   }
   long firstNum = Long.valueOf(strFirst);
   while (lenOfSecond <= len / 2) {
    String strSecond = num.substring(lenOfFirst, lenOfFirst + lenOfSecond);
    if (lenOfSecond > 1 && strSecond.startsWith("0")) {
     break;
    }
    long secondNum = Long.valueOf(strSecond);
    long oriFirstNum = firstNum;
    long sum = firstNum + secondNum;
    int lenOfSum = String.valueOf(sum).length();
    int index = lenOfFirst + lenOfSecond;
    while (index + lenOfSum <= len) {
     long strSum = Long.valueOf(num.substring(index, index + lenOfSum));
     if (strSum != sum) {
      break;
     }
     if (index + lenOfSum == len) {
      return true;
     }
     firstNum = secondNum;
     secondNum = sum;
     index += lenOfSum;
     sum = firstNum + secondNum;
     lenOfSum = String.valueOf(sum).length();
    }
    firstNum = oriFirstNum;
    lenOfSecond++;
   }
   lenOfSecond = 1;
   lenOfFirst++;
  }
  return false;
 }
  
}