package com.hxq.demo.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
//自定义区域信息解析器
public class mylocaleresovler implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale locale=Locale.getDefault();
        String s=httpServletRequest.getParameter("l");
        if(!StringUtils.isEmpty(s))
        {
            String[] s1 = s.split("_");
            locale=new Locale(s1[0],s1[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
