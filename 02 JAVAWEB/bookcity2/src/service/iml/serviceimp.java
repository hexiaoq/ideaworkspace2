package service.iml;

import DAO.impl.Daoimp;
import pojo.User;

public class serviceimp implements service {
   private  Daoimp dao=new Daoimp();
    @Override
    public void register(User user) {
        dao.adduser(user);
    }

    @Override
    public User login(User user) {
       return dao.queryBynameandpwd(user.getName(),user.getPassword());

    }

    @Override
    public boolean exsistusername(String usernaem) {
        if(dao.querybyusername(usernaem)==null)
            return false;
        else
            return true;
    }
}
