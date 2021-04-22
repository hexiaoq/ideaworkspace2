package DAO.impl;

import pojo.User;

public interface DAO {
    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    public User querybyusername(String username);
    /**
     * 根据用户名和密码查找
     */
    public User queryBynameandpwd(String username,String password);
    /**
     * 增加用户
     */
    public void adduser(User user);
}
