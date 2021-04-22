package com.hxq.bookcity.bookcity.conctroller;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.hxq.bookcity.bookcity.Service.loginservice;
import com.hxq.bookcity.bookcity.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class login {
    @Autowired
    loginservice loginservice;

    @GetMapping("/jsp")
    public String jsp()
    {
        return "test";
    }
    @PostMapping("/login")
   public  void login(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        request.getSession().setAttribute("username",user.getName());
        if(loginservice.login(user)==null)
        {
            System.out.println("输入的账户或者密码错误");
            request.setAttribute("wrong","输入的账户或者密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);


        }
        else {

            System.out.println("登陆成功");
            session.setAttribute("loginuser",user.getName());
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);

        }




    }
    @GetMapping("/register")
    public void register(User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
        String attribute =(String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String code=request.getParameter("code");
        Thread.sleep(5000);
        if(code.equals(attribute)&&attribute!=null)
        {
            if(loginservice.exsistusername(user))
            {
                request.setAttribute("wrong","用户已存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
                System.out.println("用户已存在");}
            else {
                loginservice.register(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
                System.out.println("注册成功");
            }
        }

        else {
            if(attribute!=null){
                request.setAttribute("wrong","验证码错误");
                System.out.println("验证码错误");
                request.setAttribute("name",name);
                request.setAttribute("email",email);
            }
            else {request.setAttribute("wrong","请勿重复提交");
                System.out.println("请勿重复提交");}


            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session)
    {
        //1.销毁session中的用户信息
        session.invalidate();

        //2.重新重定向到首页
        return "redirect:/index.jsp";
    }



}
