package com.hxq.demo.config;


import com.hxq.demo.component.loginhandler;
import com.hxq.demo.component.mylocaleresovler;
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
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("").setViewName("login");
                registry.addViewController("main.html").setViewName("dashboard");
            }
//注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new loginhandler()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "", "/user/login","/emp/list.html");

            }

        };
        return webMvcConfigurer;

    }

    @Bean
    public LocaleResolver localeResolver() {
        return new mylocaleresovler();

    }

}
