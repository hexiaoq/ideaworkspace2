package Servlet.register.login;

import pojo.User;
import service.iml.serviceimp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    private service.iml.serviceimp service=new serviceimp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String username=request.getParameter("username");
     if(service.login(new User(null,username,null,password))==null)
     {
         System.out.println("输入的账户或者密码错误");
         request.getRequestDispatcher("/pages/user/login.html").forward(request,response);

     }
     else {
         System.out.println("登陆成功");
         request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
     }

    }


}
