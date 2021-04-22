package affair;

import jdbcutil.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class affair {
    public static void update(Connection conn,String sql,Object...args) throws Exception {
        PreparedStatement state = conn.prepareStatement(sql);
        for (int i = 0; i < args.length ; i++) {
            state.setObject(i+1, args[i]);

        }
        state.execute();
        state.close();

    }

    public static void main(String[] args)  {
        Connection conn=null;
        try {conn = jdbcutil.setcon();
            conn.setAutoCommit(false);
            String sql1="update user_table set balance=900 where user=?";
            update(conn, sql1, "AA");


            String sql2="update user_table set balance=1100 where user=?";
            update(conn, sql2, "BB");
            conn.commit();
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();//出现异常则回滚,保证如果再次conmit 之前更改的数据也不会提交上去
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            jdbcutil.closecon(conn);

        }



    }
}
