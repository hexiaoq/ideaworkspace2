package jdbcutil;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcutil {
    public static Connection setcon() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("F:\\idea workspace\\01\\JDBC2(宋康红)\\config.properties"));
        String pwd=properties.getProperty("pwd");
        String user=properties.getProperty("user");
        String url=properties.getProperty("url");String driveclass=properties.getProperty("driveclass");

//driver对象  类加载时由静态模板块自动执行    类似于准备车
        Class.forName(driveclass);

        //connection   相当于开车门和人员上车
        Connection connection = DriverManager.getConnection(url, user, pwd) ;
        return connection;
    }


    static ComboPooledDataSource cpds;
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("F:\\idea workspace\\01\\JDBC2(宋康红)\\config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String pwd = properties.getProperty("pwd");
        String user = properties.getProperty("user");
        String drive = properties.getProperty("drive");
       cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(drive); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        cpds.setJdbcUrl(url);
        cpds.setUser(user);
        cpds.setPassword(pwd);

    }


    //方法2 利用c3p0数据池获得连接
    public static Connection setcon2() throws Exception {

        System.out.println(cpds);

        Connection conn = cpds.getConnection();

       return  conn;
    }


    static DataSource druid;
    static {
        Properties pros = new Properties();

        try {
            pros.load(new FileInputStream("F:\\idea workspace\\01\\JDBC2(宋康红)\\src\\druid.properties"));
         druid = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//方法3 利用阿里的druid数据池获得连接
    public static Connection setcon3() throws Exception {

        Connection conn = druid.getConnection();

        return  conn;
    }



    public static void closecon(Connection conn, Statement state){
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void closecon(Connection conn){

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void closecon(Connection conn, Statement state, ResultSet rs){
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
