import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class uploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(request))
        {
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = upload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if(fileItem.isFormField())
                    {
                        System.out.println(fileItem.getFieldName()+"  "+fileItem.getString("utf-8"));
                    }
                    else
                    {
                        System.out.println(fileItem.getFieldName()+"  "+fileItem.getName());
                        File file=new File("F:\\idea workspace\\02 JAVAWEB\\FIletransport\\photo2.jpg");
                        fileItem.write(file);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        else System.out.println("不是文件");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
