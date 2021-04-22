package Apche;

import BEAN.customer;
import jdbcutil.jdbcutil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

/**
 *使用apche公司提供的增删改查jar包,实现增删改操作
 *@何小强
 */
public class apche {
    @Test
    public  void test()  {

        Connection conn = null;
        try {  QueryRunner query = new QueryRunner();
            conn = jdbcutil.setcon3();
            String sql="update  customers set name=?,email=?,birth=? where id=?";
            query.update(conn, sql, "明日花绮罗","123@qq.com","1996-06-08",21);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcutil.closecon(conn, null, null);
        }


    }
    /**
     *测试查询数据
     *@何小强
     */
    @Test
    public  void test1()  {
        Connection conn = null;
        try {
            conn = jdbcutil.setcon3();
            QueryRunner queryRunner = new QueryRunner();
            String sql="select id,name,email,birth from customers where name=?";
            //数据处理类,所获取数据是什么就使用什么数据处理类
            BeanHandler<customer> cus = new BeanHandler<customer>(customer.class);
            customer c = queryRunner.query(conn, sql, cus, "明日花绮罗");
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcutil.closecon(conn);
        }



    }
    /**
     *查询多条数据
     *@何小强
     */
    @Test
    public  void test2()  {
        Connection conn = null;
        try {
            conn = jdbcutil.setcon3();
            QueryRunner queryRunner = new QueryRunner();
            String sql="select id,name,email,birth from customers where id>?";
            BeanListHandler<customer> handler = new BeanListHandler<customer>(customer.class);
            List<customer> list = queryRunner.query(conn, sql, handler, 10);
            list.forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcutil.closecon(conn);
        }



    }
}
