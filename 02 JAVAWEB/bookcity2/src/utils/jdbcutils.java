package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcutils {
static DataSource druid;
    static{
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("F:\\idea workspace\\02 JAVAWEB\\bookcity2\\druid.properties"));

            druid= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static Connection getcon() {
        Connection conn = null;
        try {
            conn = druid.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;

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
