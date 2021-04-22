package DAO.impl;

import pojo.User;

public class Daoimp extends BaseDAO implements DAO {
    @Override
    public User querybyusername(String username) {
        String sql="select id,name,password,email from t_user where name=?";
        return getone(sql,User.class,username);

    }

    @Override
    public User queryBynameandpwd(String username, String password) {
        String sql="select id,name,password,email from t_user where name=? and password=?";
        return getone(sql,User.class,username,password);
    }

    @Override
    public void  adduser(User user) {
        String sql="insert into t_user(name,password,email) values(?,?,?)";
       update(sql,user.getName(),user.getPassword(),user.getEmail());
    }
}
