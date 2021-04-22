package com.hxq.bookcity.bookcity.config;

import com.hxq.bookcity.bookcity.component.loginhandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class mymvcconfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            //注册视图解析器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("pages/client/index.jsp");
                registry.addViewController("/index").setViewName("pages/client/index.jsp");

            }

//注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new loginhandler()).addPathPatterns("/manager/page");

            }

        };
        return webMvcConfigurer;

    }


}
