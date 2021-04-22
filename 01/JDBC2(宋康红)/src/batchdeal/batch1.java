package batchdeal;

import jdbcutil.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class batch1 {
    public static void main(String[] args) throws Exception {
        Connection conn = jdbcutil.setcon();
        long time1 = System.currentTimeMillis();
        String sql = "insert into goods(id) values(?)";
        PreparedStatement state = conn.prepareStatement(sql);

        //设置为手动提交可以增加一定的效率
        conn.setAutoCommit(false);
        for (int i = 0; i < 100000; i++) {
            state.setInt(1, i);
            //攒sql 坚决不能再括号中加sql  浪费了将近1个小时的时间找错误
            state.addBatch();
            if (i % 500 == 0) {
                state.executeBatch();
                state.clearBatch();
            }


        }
        conn.commit();


        long time2 = System.currentTimeMillis();
        System.out.println("执行时间:----->" + (time2 - time1));
        jdbcutil.closecon(conn, state);

    }
}
