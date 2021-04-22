package com.hxq.shiro;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginservice {
    @Autowired
    loginmapper loginmapper;
    public User login(User user)
    {return loginmapper.finduserbynameandpd(user);

    }
    public void  register(User user)
    {
        loginmapper.add(user);
    }
    public User exsistusername(String name)
    {
        if(loginmapper.finduserbyname(name)!=null)
        {
            return loginmapper.finduserbyname(name);
        }
        else return null;
    }
    public String exsitps(String name)
    {
        if(loginmapper.findpwbyname(name)!=null)
        {
            return loginmapper.findpwbyname(name);
        }
        else return null;


    }
}
