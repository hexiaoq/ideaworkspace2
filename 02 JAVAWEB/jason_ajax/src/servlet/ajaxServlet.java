package servlet;

import bean.person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class ajaxServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        try {
            Method methods = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            methods.invoke(new ajaxServlet(),request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void ajax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("使用了ajax");

        person he=new person(1,"hxq handsomeboy");
        Gson gson=new Gson();
        String info=gson.toJson(he);
        System.out.println(info);
        PrintWriter writer = response.getWriter();
        writer.write(info);

    }

}
