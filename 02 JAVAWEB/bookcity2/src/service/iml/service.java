package service.iml;

import pojo.User;

public interface service {
    /**
     * 注册业务
     */
    public void register(User user);

    /**
     *登陆
     * @return
     */
    public User login(User user);

    /**
     *
     * @param usernaem
     * @return 返回true则用户名存在不可以注册,返回false则用户名不存在可以注册
     */
    public boolean exsistusername(String usernaem);
}
