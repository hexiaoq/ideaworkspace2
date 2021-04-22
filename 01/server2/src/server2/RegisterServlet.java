package server2;


import java.io.IOException;

public class RegisterServlet implements Servlet{

   public void service(request r,response re) throws IOException {
      System.out.println("注册成功了");

   }
}
