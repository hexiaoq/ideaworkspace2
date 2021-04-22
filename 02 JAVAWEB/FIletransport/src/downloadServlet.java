import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class downloadServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String file="photo.jpg";

        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/"+file);
        System.out.println("要下载的文件类型:"+mimeType);
        response.setContentType(mimeType);

        //获得要下载的文件
        //先获得输入输出流
        InputStream is = servletContext.getResourceAsStream("/"+file);
        ServletOutputStream os = response.getOutputStream();

        //告诉服务器自己的数据是要下载还是作为相应提
        //Content-Disposition表示怎么处理数据
        //attachment表示作为附件下载    加了这行代码后文件就不会直接显示在浏览器上了
        response.setHeader("Content-Disposition","attachment; filename="+ URLEncoder.encode(file,"utf-8"));
        //通过jar包工具,完成流数据传输
        IOUtils.copy(is,os);





    }
}
