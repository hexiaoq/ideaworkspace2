package Servlet.register.book;

import Servlet.register.userServlet;
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
import java.util.List;

public class bookServlet extends HttpServlet {
    service.iml.bookservice.bookserviceimp bookserviceimp=new bookserviceimp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //href标签只能是get方法,所以将post方法写在get中,以便处理href标签
        doPost(req,resp);
    }

//    servlet的完整流程(便于以后观看)  以addbook举例
//    ex:首先在网页的添加图书页面输入图书信息(book_add.jsp) 此网页填完图书信息后,跳转到此并将图书的信息和页面的信息以参数的形式发送过来
    //此处将图书信息保存到数据库中,再将页面信息以参数的形式发给pageservlet,通过它获得添加后的页面

    protected void addbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BOOK bean = new BOOK();
        int pageNo=webutils.parseInt(request.getParameter("pageNo"),0)+1;
        webutils.copypartobean(request.getParameterMap(), bean);
        bookserviceimp.addbook(bean);
    response.sendRedirect(request.getContextPath()+"/manager/bookservlet?action=page&&pageNo="+pageNo);



    }

    //通过service中的方法,将页面要展示的数据储存在page中,再存在request域中,调转到目标页面后,再提取出来
    //一个request请求时,request中数据保持不变
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
        Page<BOOK> bookPage = bookserviceimp.page(pageNo,pagesize);
        bookPage.setUrl("/manager/bookservlet?action=page");
        request.setAttribute("page",bookPage);


        request.getRequestDispatcher("/pages/manager/book_manager2.jsp").forward(request,response);


    }
    protected void pagebyprice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
        Page<BOOK> bookPage = bookserviceimp.page(pageNo,pagesize);
        bookPage.setUrl("manager/bookservlet");
        request.setAttribute("page",bookPage);

        request.getRequestDispatcher("/pages/manager/book_manager2.jsp").forward(request,response);


    }
    //和updatebook方法一起完成修改图书的功能
    //此方法负责将所需要修改的图书从数据库中得到,并回显到表单中,然后updatebook方法将修改后的表单封装成对象
    //同步到数据库中,完成修改,最后list显示出来所有图书,展示给用户修改后的图书表
    protected void getbook(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    { Integer id = Integer.valueOf(request.getParameter("id"));
        BOOK book = bookserviceimp.querybookbyid(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit1.jsp").forward(request,response);

    }
    protected void deletebookbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        bookserviceimp.deletebookbyid(id);
        response.sendRedirect(request.getContextPath()+"/manager/bookservlet?action=page");

    }
    protected void updatebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BOOK book = new BOOK();
        webutils.copypartobean(request.getParameterMap(), book);
      bookserviceimp.updatebook(book);
        System.out.println(request.getParameter("pageNo"));
      //F5刷新浏览器时,是再次执行上一次请求,而此方法为两次请求,本次请求和上次请求没有关系,刷新时不会再次添加图书,
        // 而resquest的方法则为一次请求,刷新时为反复添加图书
        response.sendRedirect(request.getContextPath()+"/manager/bookservlet?action=page&&pageNo="+request.getParameter("pageNo"));

    }
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<BOOK> books = bookserviceimp.queryallbooks();
        request.setAttribute("books",books);

        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Method methods = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            methods.invoke(new bookServlet(),request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
