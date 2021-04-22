package blobtest;

import jdbcutil.jdbcutil;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *存图片到数据库
 *@何小强
 */
public class test1 {
    public static void main(String[] args) throws Exception {
        Connection conn = jdbcutil.setcon();
        String sql="insert into customers set id=?,name=?,photo=?";
        PreparedStatement state = conn.prepareStatement(sql);
          state.setInt(1, 22);
          state.setString(2, "he2");
        FileInputStream is=new FileInputStream("he.jpg");
          state.setBlob(3, is);
          state.execute();
          jdbcutil.closecon(conn, state);


    }
}
