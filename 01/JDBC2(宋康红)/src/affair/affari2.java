package affair;

import BEAN.user_table;
import jdbcutil.jdbcutil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
/**
 *配合test测试防止脏读的写提交权限
 *@何小强
 */

public class affari2 {
    //查询方法
    public static user_table getcus(Connection con, String sql, Object ...args) throws Exception {
        jdbcutil jdbcutil = new jdbcutil();

        PreparedStatement state =con.prepareStatement(sql);
        for (int i = 0; i <args.length ; i++) {
            state.setObject(i+1, args[i]);

        }
        ResultSet rs=state.executeQuery();

        ResultSetMetaData rm=rs.getMetaData();//获得原始数据
        int column=rm.getColumnCount();
        user_table cus=new user_table();
        if(rs.next())
        {
            for (int i = 0; i <column ; i++) {
                Object columnvalue= rs.getObject(i+1);

                //获得表的列名
                String columnname=rm.getColumnName(i+1);
                //获得表的别名 则用rm.getColumnLabel() 若没有取别名则获得列名  一般使用这个方法


                //由于参数类型不确定是动态的,无法使用set和构造器 创造对象 所以这里使用反射
                Field field = user_table.class.getDeclaredField(columnname);
                field.setAccessible(true);
                field.set(cus, columnvalue);

            }


        }
        state.close();

        return cus;
    }
    //修改方法
    @Test
    public void test() throws Exception {
        Connection conn = jdbcutil.setcon();
        conn.setAutoCommit(false);

        String sql="update user_table set balance=5000 where user=?";
        affari2.update(conn, sql, "CC");
        Thread.sleep(15000);
        System.out.println("修改结束");
        conn.commit();
    }
    public static void update(Connection conn,String sql,Object...args) throws Exception {
        PreparedStatement state = conn.prepareStatement(sql);
        for (int i = 0; i < args.length ; i++) {
            state.setObject(i+1, args[i]);

        }
        state.execute();
        state.close();

    }

    public static void main(String[] args) throws Exception {
        Connection conn = jdbcutil.setcon();
        //设置写提交权限,防止脏读
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        String sql="select balance from user_table where user=?";
        user_table us=getcus(conn, sql, "CC");
        System.out.println(us);

    }
}
