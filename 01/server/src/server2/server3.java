package server2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server3 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        server3 server = new server3();
        server.start();

    }

    public void start() {
        try {
            serverSocket = new ServerSocket(8888);//建立服务器套接口，指明端口
            System.out.println("服务器建立");
            receive();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void receive() throws IOException {
        Socket socket = serverSocket.accept();//当有客户端访问服务器套接口指明的端口时，便建立服务器与客户端之间的套接口
        System.out.println("一个服务器已建立连接");
       request r=new request(socket);
       r.request();

            response re=new response(socket);
            
            re.add("<html>");
            re.add("<head>");
            re.add("<pre>");
            re.add("success");
            re.add("</pre>");
            re.add("</head>");
            re.add("<body>");
            re.add("欢迎回来"+r.getvalue("uname"));
            re.add("</body>");
            re.add("</html>");
            re.givebrowser(200);

        }




    public void end() {

    }
}
