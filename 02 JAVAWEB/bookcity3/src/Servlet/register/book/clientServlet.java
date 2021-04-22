package Servlet.register.book;

import pojo.BOOK;
import pojo.Page;
import service.iml.bookservice.bookserviceimp;
import utils.webutils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

public class clientServlet extends HttpServlet {
    service.iml.bookservice.bookserviceimp bookserviceimp=new bookserviceimp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //href标签只能是get方法,所以将post方法写在get中,以便处理href标签
        doPost(req,resp);
    }



    //通过service中的方法,将页面要展示的数据储存在page中,再存在request域中,调转到目标页面后,再提取出来
    //一个request请求时,request中数据保持不变
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
        Page<BOOK> bookPage = bookserviceimp.page(pageNo,pagesize);
        bookPage.setUrl("/client/bookservlet?action=page");
        request.setAttribute("page",bookPage);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }
    protected void pagebyprice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
      int min=webutils.parseInt(request.getParameter("min"),0);
      int max=webutils.parseInt(request.getParameter("max"),10000);
        Page<BOOK> bookPage = bookserviceimp.pagebyprice(pageNo,pagesize,min,max);
        StringBuilder s=new StringBuilder("/client/bookservlet?action=pagebyprice");
        if(request.getParameter("min")!=null)
            s.append("&min").append(min);
        if(request.getParameter("max")!=null)
            s.append("&max").append(max);


        bookPage.setUrl(String.valueOf(s));
        request.setAttribute("page",bookPage);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Method methods = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            methods.invoke(new clientServlet(),request,response);
        } catch (Exception e) {
           e.printStackTrace();
        }

    }
}
