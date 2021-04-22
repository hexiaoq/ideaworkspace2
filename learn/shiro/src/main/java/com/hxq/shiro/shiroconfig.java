package com.hxq.shiro;
import org.apache.shiro.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class shiroconfig {
    @Bean
    public ShiroFilterFactoryBean factoryBean(@Qualifier("manager") DefaultWebSecurityManager manage){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(manage);
        Map<String,String> FilterMap=new LinkedHashMap();
        FilterMap.put("/update","authc");
        FilterMap.put("/down","authc");
        //必须在字段中拥有指定的权限
        FilterMap.put("/update","perms[update]");
        FilterMap.put("/down","perms[down]");
        bean.setLoginUrl("/tologin");
        bean.setUnauthorizedUrl("/tonoau");

        bean.setFilterChainDefinitionMap(FilterMap);
        return bean;
    }
    @Bean(name="manager")
    public DefaultWebSecurityManager getsecurity(@Qualifier("userRealm") UserRealm userRealm)
    {
        org.apache.shiro.web.mgt.DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    @Bean
    public UserRealm userRealm()
    {
        return new UserRealm();
    }

}
