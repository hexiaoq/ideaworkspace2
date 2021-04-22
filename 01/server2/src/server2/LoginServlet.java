package server2;

import java.io.IOException;

public class LoginServlet implements Servlet {


   public void service(request r,response re) throws IOException {

       re.add("<html>");
       re.add("<head>");
       re.add("<pre>");
       re.add("第一个servlet");
       re.add("</pre>");
       re.add("</head>");
       re.add("<body>");
       re.add("欢迎回来"+r.getvalue("uname"));
       re.add("</body>");
       re.add("</html>");
       re.givebrowser(200);
    }
}
