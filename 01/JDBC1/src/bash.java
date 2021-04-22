import java.sql.*;

public class bash {
    /**
     * bash处理 插入大量数据  bash处理时 最好用statement 否则太耗时
     *
     * @何小强
     */
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            long time = System.currentTimeMillis();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?characterEncoding=utf8&useSSL=false&serverTimezone = GMT", "root", "156437734");

            //设为手动提交
            conn.setAutoCommit(false);
            state = conn.createStatement();
            for (int i = 0; i < 20000; i++) {
                state.addBatch("insert into test(id,name) values("+ i +",'何小强" + i + "')");
            }
            state.executeBatch();
            conn.commit();//事务手动提交
            long time2 = System.currentTimeMillis();
            System.out.println("耗时---->" + (time2 - time));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {//关流  遵循后开的先关  并且要防止空指针异常
            if (state != null) {
                state.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }


}
