package Servlet.register;

import Servlet.register.userServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class  baseservlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Method methods = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            methods.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
