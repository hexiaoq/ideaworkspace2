package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class cookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }
    //将浏览器的cookie传输到服务器中
    protected void getcookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            response.getWriter().write(String.valueOf(cookie));
        }

    }
    protected void creatcookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie cookie=new Cookie("key1","value1");

        response.setContentType("text/html;charset=utf-8");
        response.addCookie(cookie);
        response.getWriter().write("cookie创建成功");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Method methods = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            methods.invoke(new cookieServlet(),request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
