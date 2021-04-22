import java.sql.*;

/**
 *连接数据库 和preparestatement 注入sql语句
 *
 *@何小强
 */

public class db {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement state=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            long time=System.currentTimeMillis();
       conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?characterEncoding=utf8&useSSL=false&serverTimezone = GMT", "root", "156437734");

            String sql="select * from beauty where id>?";//?为占位符,可以防止恶意的sql注入
             state=conn.prepareStatement(sql);
            state.setObject(1, 10);
            rs=state.executeQuery();//显示结果用executeQuery  增删改用 execute
  while(rs.next())
  {
      System.out.println(rs.getInt(1)+rs.getString(2));
  }
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
