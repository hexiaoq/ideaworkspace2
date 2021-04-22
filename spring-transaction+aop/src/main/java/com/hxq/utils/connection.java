package com.hxq.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
/*
*获得连接的工具类,并保证同一个线程使用同一个连接,保持事务的一致性
*@ 何小强
*/
@Service("connection")
public class connection {
    //当前线程threadlocal相当于一个容器,可以存放连接等
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

@Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getthreadcon() {
        try {
            Connection con=threadLocal.get();
            if(con==null)
            {
                con=dataSource.getConnection();
                con.setAutoCommit(false);
                threadLocal.set(con);

            }
            return con;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }
    public void removeconn()
    {
        threadLocal.remove();
    }

}
