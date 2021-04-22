package blobtest;

import jdbcutil.jdbcutil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *从数据库中取图片
 *@何小强
 */
public class test2 {
    public static void main(String[] args) throws Exception {
        Connection  conn= jdbcutil.setcon();
        String sql="select * from customers where id=16  ";
        PreparedStatement state = conn.prepareStatement(sql);


        ResultSet rs = state.executeQuery();
        if (rs.next())
        {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            Blob blob = rs.getBlob(5);
            InputStream is=blob.getBinaryStream() ;
            byte[] b=new byte[1024];
            FileOutputStream fo=new FileOutputStream(new File("朱茵.jpg"));
            int len;
            while((len=is.read(b))!=-1)
            {fo.write(b, 0, len);


            }
            is.close();
            fo.close();
           jdbcutil.closecon(conn, state, rs);
        }

    }
}
