package Servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;

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
        System.out.println("什么情况");
        if(ServletFileUpload.isMultipartContent(request))
        {
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list=upload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField())
                    {
                        System.out.println("表单name属性:"+fileItem.getFieldName());
                        System.out.println("表单value属性:"+fileItem.getString("utf-8"));
                    }
                    else {
                        System.out.println("表单name属性:"+fileItem.getFieldName());
                        System.out.println("文件名"+fileItem.getName());
                        fileItem.write(new File("F:\\"+fileItem.getName()));

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
