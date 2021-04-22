package com.hxq.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    loginservice loginservice;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("到了授权页面");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        User principal= (User) subject.getPrincipal();
        info.addStringPermission(principal.getEmail());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        System.out.println("到了验证页面");

                UsernamePasswordToken token= (UsernamePasswordToken)Token;
        User user = loginservice.exsistusername(token.getUsername());
        if(user==null)
        {
            return null;
        }


        return new SimpleAuthenticationInfo(user,user.getName(),"");
    }
}
