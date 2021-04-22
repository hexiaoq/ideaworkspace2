import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 页面重定向功能,实现页面跳转
 */
public class Response1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("此网站已搬迁");

//     //请求重定向 方案1   response.setStatus(302);
//        response.setHeader("Location","http://localhost:8080/servlet2/response2");
//方案2
        response.sendRedirect("http://localhost:8080/servlet2/response2");
    }
}
