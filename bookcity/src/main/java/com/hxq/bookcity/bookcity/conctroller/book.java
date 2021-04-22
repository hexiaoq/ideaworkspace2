package com.hxq.bookcity.bookcity.conctroller;

import com.hxq.bookcity.bookcity.Service.bookservice;
import com.hxq.bookcity.bookcity.pojo.BOOK;
import com.hxq.bookcity.bookcity.pojo.Page;
import com.hxq.bookcity.bookcity.utils.webutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class book {
    @Autowired
    bookservice bookservice;
    @RequestMapping("/manager/page")
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
        Page<BOOK> bookPage = bookservice.page(pageNo,pagesize);
        bookPage.setUrl("manager/page");
        request.setAttribute("page",bookPage);


        request.getRequestDispatcher("/pages/manager/book_manager2.jsp").forward(request,response);


    }
    @RequestMapping("client/page")
    protected void page1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
        Page<BOOK> bookPage = bookservice.page(pageNo,pagesize);
        bookPage.setUrl("/client/page");
        request.setAttribute("page",bookPage);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }
    @RequestMapping("/addbook")
    protected void addbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BOOK bean = new BOOK();
        int pageNo=webutils.parseInt(request.getParameter("pageNo"),0)+1;
        webutils.copypartobean(request.getParameterMap(), bean);
        bookservice.addbook(bean);
        response.sendRedirect(request.getContextPath()+"/manager/page?pageNo="+pageNo);



    }
    @RequestMapping("/delete")
    protected void deletebookbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        bookservice.deletebookbyid(id);
        response.sendRedirect(request.getContextPath()+"/manager/page");

    }
    @RequestMapping("/update")
    protected void updatebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BOOK book = new BOOK();
        webutils.copypartobean(request.getParameterMap(), book);
        bookservice.updatebook(book);
        System.out.println(request.getParameter("pageNo"));
        //F5刷新浏览器时,是再次执行上一次请求,而此方法为两次请求,本次请求和上次请求没有关系,刷新时不会再次添加图书,
        // 而resquest的方法则为一次请求,刷新时为反复添加图书
        response.sendRedirect(request.getContextPath()+"/manager/page?pageNo="+request.getParameter("pageNo"));

    }
    //和updatebook方法一起完成修改图书的功能
    //此方法负责将所需要修改的图书从数据库中得到,并回显到表单中,然后updatebook方法将修改后的表单封装成对象
    //同步到数据库中,完成修改,最后list显示出来所有图书,展示给用户修改后的图书表
    @RequestMapping("/getbook")
    protected void getbook(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    { Integer id = Integer.valueOf(request.getParameter("id"));
        BOOK book = bookservice.querybookbyid(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit1.jsp").forward(request,response);

    }
    @RequestMapping("/pagebyprice")
    protected void pagebyprice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
        int min=webutils.parseInt(request.getParameter("min"),0);
        int max=webutils.parseInt(request.getParameter("max"),10000);
        Page<BOOK> bookPage = bookservice.pagebyprice(pageNo,pagesize,min,max);
        StringBuilder s=new StringBuilder("/pagebyprice?");
        if(request.getParameter("min")!=null)
            s.append("min").append(min);
        if(request.getParameter("max")!=null)
            s.append("&max").append(max);


        bookPage.setUrl(String.valueOf(s));
        request.setAttribute("page",bookPage);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }

}
