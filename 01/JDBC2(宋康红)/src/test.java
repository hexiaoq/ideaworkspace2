import jdbcutil.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class test {
    public static void main(String[] args) throws Exception {
        jdbcutil jdbcutil = new jdbcutil();
        Connection conn = jdbcutil.setcon();

        PreparedStatement state = conn.prepareStatement("insert into beauty set id=?,name=?");
        state.setObject(1, 21);
        state.setObject(2, "吉泽明步");

        state.execute();
        jdbcutil.closecon(conn, state);


    }
}
