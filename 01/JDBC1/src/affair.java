import java.sql.*;

public class affair {
    /**
     *事务操作  事务必须全部完成成功否则会回滚
     *@何小强
     */
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement state=null;PreparedStatement state2=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            long time=System.currentTimeMillis();
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?characterEncoding=utf8&useSSL=false&serverTimezone = GMT", "root", "156437734");
             conn.setAutoCommit(false);
            state=conn.prepareStatement("insert into test set id=1,name='hxq'");
            state.execute();
            System.out.println("chegngong1");
            Thread.sleep(6000);



            state2=conn.prepareStatement("insert into test set id=2,name='xiaohao'");
            state2.execute();
            System.out.println("chenggong2");
conn.commit();
            long time2=System.currentTimeMillis();
            System.out.println("耗时---->"+(time2-time));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {//关流  遵循后开的先关  并且要防止空指针异常
            if(rs!=null)
            {
                rs.close();
            }
            if(state!=null)
            {
                state.close();
            }
            if(conn!=null)
            {
                conn.close();
            }

        }

    }
}
