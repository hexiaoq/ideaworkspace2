package normalmethod1;

import BEAN.customer;
import jdbcutil.jdbcutil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *封装查询的通用方法    列名动态调用
 *@何小强
 */

/*
 * 针对于表的字段名与类的属性名不相同的情况：
 * 1. 必须声明sql时，使用类的属性名来命名字段的别名
 * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
 *    获取列的别名。
 *  说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
 *
 *
 */

public class method {
    public customer getcus(String sql, Object ...args) throws Exception {
        jdbcutil jdbcutil = new jdbcutil();
        Connection con = jdbcutil.setcon();
        PreparedStatement state =con.prepareStatement(sql);
        for (int i = 0; i <args.length ; i++) {
            state.setObject(i+1, args[i]);

        }
        ResultSet rs=state.executeQuery();

        ResultSetMetaData rm=rs.getMetaData();//获得原始数据
        int column=rm.getColumnCount();
        customer cus=new customer();
        if(rs.next())
        {
            for (int i = 0; i <column ; i++) {
            Object columnvalue= rs.getObject(i+1);

            //获得表的列名
             String columnname=rm.getColumnName(i+1);
           //获得表的别名 则用rm.getColumnLabel() 若没有取别名则获得列名  一般使用这个方法


              //由于参数类型不确定是动态的,无法使用set和构造器 创造对象 所以这里使用反射
                Field field = customer.class.getDeclaredField(columnname);
                field.setAccessible(true);
                field.set(cus, columnvalue);

            }


        }
        jdbcutil.closecon(con, state);

        return cus;
    }

    public static void main(String[] args) throws Exception {
        method method = new method();
        String sql="select id,name,email from customers where id=?";
        System.out.println(method.getcus(sql,1));

        String sql2="select id,name,email from customers where name=?";
        System.out.println(method.getcus(sql2, "周杰伦"));
    }


}
