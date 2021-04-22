package Servlet.register.cart;

import Servlet.register.userServlet;
import pojo.BOOK;
import pojo.Cart;
import pojo.Cartitem;
import service.iml.bookservice.bookserviceimp;
import service.iml.serviceimp;
import utils.webutils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class cartServlet extends HttpServlet {
    service.iml.bookservice.bookserviceimp serviceimp=new bookserviceimp();
    protected  void updatecount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {Cart cart= (Cart) req.getSession().getAttribute("cart");
        int id = webutils.parseInt(req.getParameter("id"), 0);
        int count = webutils.parseInt(req.getParameter("count"), 0);
        cart.updatecount(id,count);

        //referer可以保存浏览器请求之前的地址信息
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);


    }


    protected  void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if(cart!=null)
        {cart.clear();}
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);

    }

    protected  void deleteitem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id=webutils.parseInt(req.getParameter("id"),0);
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        cart.deleteitem(id);
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);



    }

    protected  void additems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = webutils.parseInt(req.getParameter("id"),0);
        BOOK book = serviceimp.querybookbyid(id);
        Cartitem bookitem=null;
        bookitem=new Cartitem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if(cart==null)
        {
            cart=new Cart();
            cart.additems(bookitem);
            req.getSession().setAttribute("cart",cart);

        }
        else
        cart.additems(bookitem);
        req.getSession().setAttribute("lastname",book.getName());
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);



    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Method methods = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            methods.invoke(new cartServlet(),request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
