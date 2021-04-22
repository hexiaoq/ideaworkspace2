package affair;

import jdbcutil.jdbcutil;

import java.sql.Connection;

public class test {
    public static void main(String[] args) throws Exception {
        Connection conn = jdbcutil.setcon();
        conn.setAutoCommit(false);

        String sql="update user_table set balance=5000 where user=?";
        affari2.update(conn, sql, "CC");
        Thread.sleep(15000);
        System.out.println("修改结束");
        conn.commit();
    }
}
