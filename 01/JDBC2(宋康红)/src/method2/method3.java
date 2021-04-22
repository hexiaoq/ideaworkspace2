package method2;

import BEAN.customer;
import jdbcutil.jdbcutil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 *查询多条记录   动态调用表,完成对不同表的通用查询
 *@何小强
 */
public class method3 {
    public <T> ArrayList<T> getlist(Class<T> clazz, String sql, Object... args) throws Exception {
        jdbcutil util = new jdbcutil();
        Connection conn = util.setcon();
        PreparedStatement state = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            state.setObject(i + 1, args[i]);

        }
        ;
        ResultSet rs = state.executeQuery();
        ResultSetMetaData rm = rs.getMetaData();

        int column = rm.getColumnCount();
        ArrayList<T> arrayList=new ArrayList<>();
        while (rs.next()) {
            T t = clazz.newInstance();
            for (int i = 0; i < column; i++) {
                Object columnvalue = rs.getObject(i + 1);
                String colunmLable = rm.getColumnLabel(i + 1);

                Field field = clazz.getDeclaredField(colunmLable);
                field.setAccessible(true);
                field.set(t, columnvalue);

            }
            arrayList.add(t);


        } util.closecon(conn, state);
        return arrayList;


    }

    public static void main(String[] args) throws Exception {
        method3 m1=new method3();
        String sql="select id,name,birth from customers  where id>?";
        ArrayList<customer> list=m1.getlist(customer.class, sql, 3);
       list.forEach(System.out::println);

        }




    }



