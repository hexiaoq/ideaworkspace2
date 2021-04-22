package method2;

import BEAN.customer;
import BEAN.order1;
import jdbcutil.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *查询一条记录   动态调用表,完成对不同表的通用查询
 *@何小强
 */
public class method2 {
    public <T> T getlist(Class<T> clazz, String sql, Object... args) throws Exception {
        jdbcutil util = new jdbcutil();
        Connection conn = util.setcon();
        PreparedStatement state = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            state.setObject(i + 1, args[i]);

        }
        ;
        ResultSet rs = state.executeQuery();
        ResultSetMetaData rm = rs.getMetaData();
        T t = clazz.newInstance();
        int column = rm.getColumnCount();
        if (rs.next()) {
            for (int i = 0; i < column; i++) {
                Object columnvalue = rs.getObject(i + 1);
                String colunmLable = rm.getColumnLabel(i + 1);

                Field field = clazz.getDeclaredField(colunmLable);
                field.setAccessible(true);
                field.set(t, columnvalue);

            }



        } util.closecon(conn, state);
        return t;


    }

    public static void main(String[] args) throws Exception {
        method2 m=new method2();
        String sql="select id,name,birth from customers  where id=? ";
        customer cus=null;
        System.out.println(cus=m.getlist(customer.class, sql,6));


        String sql2="select * from order1 where order_id=? ";
        System.out.println(m.getlist(order1.class, sql2, 2));

    }
}

