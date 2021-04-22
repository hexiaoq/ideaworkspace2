package Servlet.register;

import com.google.gson.Gson;
import pojo.User;
import service.iml.serviceimp;
import utils.webutils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
*将多个用户servlet整合到一起,并通过反射减少ifesle代码冗余
*@ 何小强
*/
public class userServlet extends HttpServlet {
    private service.iml.serviceimp service=new serviceimp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    //使用json实现页面不跳转的提示用户名是否存在
    protected void ajaxexistname(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String username = request.getParameter("username");
        boolean exsistusername = service.exsistusername(username);
        Map map= new HashMap();
        map.put("exsistusername",exsistusername);
        Gson gson=new Gson();
        String info=gson.toJson(map);
        response.getWriter().write(info);


    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //1.销毁session中的用户信息
        request.getSession().invalidate();

        //2.重新重定向到首页
        response.sendRedirect(request.getContextPath());


    }
    protected void regist(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String attribute =(String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String code=request.getParameter("code");
Thread.sleep(5000);
        User user = new User();
        utils.webutils.copypartobean(request.getParameterMap(), user);
        if(code.equals(attribute)&&attribute!=null)
        {
            if(service.exsistusername(name))
            {
                request.setAttribute("wrong","用户已存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
                System.out.println("用户已存在");}
            else {
                service.register(user);
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
    protected void login(HttpServletRequest request,HttpServletResponse response) throws Exception{
        User user = new User();
        webutils.copypartobean(request.getParameterMap(), user);
        String username = request.getParameter("name");
        if(service.login(user)==null)
        {
            System.out.println("输入的账户或者密码错误");
            request.setAttribute("wrong","输入的账户或者密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);

        }
        else {
            Cookie cookie=new Cookie("username",username);
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            //保存用户登录后的信息
            request.getSession().setAttribute("username",username);
            System.out.println("登陆成功");
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Method methods = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            methods.invoke(new userServlet(),request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
