import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       //设置服务器的编码 response.setCharacterEncoding("UTF-8");
//       //设置浏览器的编码 response.setHeader("Content-Type","text/html;charset=UTF-8");

        //方法2 同时设置两者的编码
        response.setContentType("text/html;charset=utf-8");


        PrintWriter writer = response.getWriter();

        writer.println("何小强必将成为一名伟大的程序猿");

    }
}
