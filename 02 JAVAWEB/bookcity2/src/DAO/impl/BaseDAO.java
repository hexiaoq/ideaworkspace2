package DAO.impl;

import com.alibaba.druid.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.jdbcutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public  abstract class  BaseDAO {

    private QueryRunner queryRunner=new QueryRunner();


    public void update(String sql,Object...args){
        try {
            Connection conn = jdbcutils.getcon();
            queryRunner.update(conn,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public<T> T getone(String sql,Class<T> user,Object...args)
    {  Connection conn = jdbcutils.getcon();
        try {

            return queryRunner.query(conn,sql,new  BeanHandler<T>(user),args);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        finally {
            jdbcutils.closecon(conn,null,null);
        }
        return null;


    }
    public<T> List<T> getmany(String sql, Class<T> user, Object...args)
    {  Connection conn = jdbcutils.getcon();
        try {

            return queryRunner.query(conn,sql,new BeanListHandler<T>(user),args);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        finally {
            jdbcutils.closecon(conn,null,null);
        }
        return null;


    }
    public Object getvalue(String sql,Object...args)
    {
        Connection conn = jdbcutils.getcon();
        try {
            return queryRunner.query(sql,new ScalarHandler(),args);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        finally {
            jdbcutils.closecon(conn,null,null);
        }
        return null;

    }
}

