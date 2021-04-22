package Servlet.register;

import pojo.User;
import service.iml.serviceimp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerservlet extends HttpServlet {
    private service.iml.serviceimp service=new serviceimp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String code=request.getParameter("code");


        if(code.equals("abc"))
        {
            if(service.exsistusername(name))
            {
                request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
            System.out.println("用户已存在");}
            else {
                service.register(new User(null,name,email,password));
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
            System.out.println("注册成功");
            }
        }

        else {
            request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
            System.out.println("验证码错误");
        }

    }


}
