import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class  servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("柜台2检车是否带有材料"+req.getParameter("password"));
        System.out.println("检查是否有柜台1的章"+req.getAttribute("key1"));

        System.out.println("做柜台2的业务");
    }
}
